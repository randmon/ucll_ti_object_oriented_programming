package RekenenTest.domain;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Test {
	private final ParticipantGroup group;
	private final Quiz quiz;
	private int index = 0;

	public Test(ParticipantGroup group, Quiz quiz) {
		this.group = group;
		this.quiz = quiz;
	}

	public boolean isFinished() {
		return index >= quiz.getAmountOfQuestions();
	}

	public String getNextQuestion() {
		Question currentQuestion = quiz.getQuestion(index);
		index++;
	    return (currentQuestion.question());
	}
		
	public int countParticipants(){
		return group.countParticipants();
	}
	
	public String getCurrentParticipant(){
		return group.getActiveParticipant();
	}

	/**
	 * Checks if answer is correct, registers true/false result for the current participant
	 * and moves to the next participant
	 *
	 * @param answer the answer to check
	 */
	public void play(String answer) {
		Question currentQuestion = quiz.getQuestion(index-1);
		boolean result = currentQuestion.isCorrectAnswer(answer);
		String currentParticipant = group.getAndMoveActiveParticipant();
		group.registerScore(currentParticipant, result);
	}

	/**
	 * Return the players with the most points
	 *
	 */
	public Set<String> getWinners() {
		return group.getWinners();
	}

	public String getParticipantAnswers() {
		Map<String, ArrayList<Boolean>> scores = group.getScores();
		StringBuilder result = new StringBuilder();
		for (var p : scores.entrySet()) {
			result.append(p.getKey()).append(": ").append(p.getValue()).append("\n");
		}
		return result.toString();
	}	
}
