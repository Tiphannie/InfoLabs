package CalendarclassJD;

import java.util.Calendar;

public class JulianDate {
	  private int year;
	    private int month;
	    private int day;

	    // Nermin proposition <use integers> 
	    public JulianDate(int year, int month, int day) {
	        this.year = year;
	        this.month = month;
	        this.day = day;
	    }

	    //return the year, month and day 
	    public int getYear() {
	        return year;
	    }

	    public int getMonth() {
	        return month;
	    }

	    public int getDay() {
	        return day;
	    }
	    
	 // Helper method to convert JulianDate to Calendar
	    private Calendar getCalendar(JulianDate julianDate) {
	        Calendar cal = Calendar.getInstance();
	        cal.set(Calendar.YEAR, julianDate.getYear());
	        cal.set(Calendar.MONTH, julianDate.getMonth() - 1);
	        cal.set(Calendar.DAY_OF_MONTH, julianDate.getDay());

	        return cal;
	    }
	    
	 // Helper method to convert Calendar to JulianDate
	    private JulianDate getDate(Calendar calendar) {
	        int year = calendar.get(Calendar.YEAR);
	        int month = calendar.get(Calendar.MONTH) + 1;
	        int day = calendar.get(Calendar.DAY_OF_MONTH);

	        return new JulianDate(year, month, day);
	    }
	    
	 // Method to calculate the number of days between two dates
	    public int daysBetween(JulianDate otherDate) {
	        Calendar cal1 = getCalendar(this);
	        Calendar cal2 = getCalendar(otherDate);

	        long diffInMillis = cal2.getTimeInMillis() - cal1.getTimeInMillis();
	        return (int) (diffInMillis / (24 * 60 * 60 * 1000));
	    }
	    
	    
	 // Method to calculate the date for the next day
	    public JulianDate tomorrow() {
	        Calendar cal = getCalendar(this);
	        cal.add(Calendar.DAY_OF_MONTH, 1);

	        return getDate(cal);
	    }
	    
	 // Method to calculate the date for the previous day
	    public JulianDate yesterday() {
	        Calendar cal = getCalendar(this);
	        cal.add(Calendar.DAY_OF_MONTH, -1);

	        return getDate(cal);
	    }


}
