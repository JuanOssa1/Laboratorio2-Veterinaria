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
	// Gets that allows to use the information of the attributes in another
	/**
	 * Description: This method allows to get the day of a date to use it in another class if is needed 
	 * @return The day of a date
	 */
	public int getDay() {
		return this.day;
	}
	/**
	 * Description: This method allows to get the month of a date to use it in another class if is needed 
	 * @return The month of a date
	 */
	public int getMonth() {
		return this.month;
	}
	/**
	 * Description: This method allows to get the day of a date to use it in another class if is needed 
	 * @return The day of a date
	 */
	public int getYear() {
		return this.year;
	}

}