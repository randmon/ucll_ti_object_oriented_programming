package RekenenTest.domain;

import java.util.*;

public class ParticipantGroup {

	private final Queue<String> group;
	private final Map <String, ArrayList<Boolean>> scores;
	
	public ParticipantGroup(List<String> participants){
		group = new LinkedList<>(participants);
		scores = new TreeMap<>(); // Tree is automatically sorted
		for (String deelnemer : participants) {
			scores.put(deelnemer, new ArrayList<>());
		}
	}	

	public List<String> getDeelnemers() {
		return new ArrayList<>(group);
	}
	
	public int countParticipants(){
		return group.size();
	}

	public String getActiveParticipant() {
		return group.peek();
	}

	public String getAndMoveActiveParticipant() {
		String s = group.poll();
		group.offer(s);
		return s;
	}

	public void registerScore(String participant, boolean correctAnswer) {
		if (scores.containsKey(participant)) {
			scores.get(participant).add(correctAnswer);
		} else {
			throw new IllegalArgumentException("Participant not found");
		}
	}

	public int getScore(String participant) {
		int score = 0;
		for (boolean b : scores.get(participant)) {
			if (b) score++;
		}
		return score;
	}

	public String getWinner(){
        int max = getHighestPoints();
        for (String p : group) {
        	int score = getScore(p);
            if (score == max)
                return p;
        }
        return null;
    }

	public Set<String> getWinners() {
		int max = getHighestPoints();
		Set<String> winners = new HashSet<>();
		for (String p : group) {
			int score = getScore(p);
			if (score == max) {
				winners.add(p);
			}
		}
		return winners;
	}

	public int getHighestPoints() {
		int max = 0;
		for (String p : group) {
			int score = getScore(p);
			if (score > max) {
				max = score;
			}
		}
		return max;
	}

	public String overviewPoints(){
		Map<Integer, Set<String>> result = new TreeMap<>((s1, s2) -> s2 - s1); // sort descending
		for (var e : scores.entrySet()) {
			int points = e.getValue().stream().map(x -> x? 1 : 0).reduce(0, Integer::sum);
			if (result.containsKey(points)) {
				result.get(points).add(e.getKey());
			} else {
				Set<String> set = new HashSet<>();
				set.add(e.getKey());
				result.put(points, set);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (var e : result.entrySet()) {
			sb.append(e.getKey()).append(": ").append(e.getValue()).append("\n");
		}
		return sb.toString();
	}

	public Map<String, ArrayList<Boolean>> getScores() {
		return scores;
	}
}
