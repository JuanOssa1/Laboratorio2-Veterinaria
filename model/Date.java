package model;
public class Date {
	// Constants
	// Attributes from the class
	private int day;
	private int month;
	private int year;

	// Association attributes
	// builder class Pets (will be called in the main class)
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	// Setters that allows to change variable information in a future
	public void setDay(int newDay) {
		day = newDay;
	}

	public void setmonth(int newMonth) {
		month = newMonth;
	}

	public void setYear(int newYear) {
		year = newYear;
	}

	// Gets that allows to use the information of the attributes in another
	// class
	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}

}