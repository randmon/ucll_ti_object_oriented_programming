package verjaardagen.domain;

import java.util.*;

public class BirthdayCalendar {
	private final Map<DayMonth, Set<Person>> calendar;
	
	public BirthdayCalendar(){
		this.calendar = new TreeMap<>();
	}
	
	public void addBirthday(Person p){
		DayMonth dayMonth = new DayMonth(p.birthday());
		if (calendar.containsKey(dayMonth)) {
			calendar.get(dayMonth).add(p);
		} else{
			calendar.put(dayMonth, new HashSet<>(Set.of(p)));
		}
	}
	
	public void removePerson(Person p) {
		DayMonth dayMonth = new DayMonth(p.birthday());
		if (calendar.containsKey(dayMonth)) {
			calendar.get(dayMonth).remove(p);
		}
		// If the set is empty, remove the key from the map
		if (calendar.get(dayMonth).isEmpty()) {
			calendar.remove(dayMonth);
		}
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		for (DayMonth d : this.calendar.keySet()){
			// left justify datemonth into 15 spaces
			s.append("\n");
			s.append(String.format("%-15s", d));
			for (Person p : this.calendar.get(d)){
				s.append("| ");
				s.append(String.format("%-30s", p));
			}
		}
		return s.toString();
	}
}
