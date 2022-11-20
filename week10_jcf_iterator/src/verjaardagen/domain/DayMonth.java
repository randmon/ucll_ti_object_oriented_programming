package verjaardagen.domain;

import java.time.LocalDate;

public class DayMonth implements Comparable<DayMonth> {
	private final String[] months = { "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" };
	
	private final int day, month;

	public DayMonth(int day, int month) {
		this.day = day;
		this.month = month;
	}

	public DayMonth(LocalDate date) {
		if (date == null) {
			throw new IllegalArgumentException();
		}
		this.day = date.getDayOfMonth();
		this.month = date.getMonthValue();
	}

	@Override
	public String toString(){
		return this.day + " " + months[this.month-1];
	}

	@Override
	public int compareTo(DayMonth o) {
		if (this.month == o.month) {
			return this.day - o.day;
		}
		return this.month - o.month;
	}
}
