package abstractdatatypes;

public class JulianDate {

    private double julianDate;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private double second;
    private int lastChirstmasYear = 2017;
    
    public JulianDate(int year, int month, int day, int hour, int minute, double second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.julianDate = calculateJulian();

    }
    public JulianDate(double julianDate) {
        this.julianDate = julianDate;
    }
    
    public JulianDate() {
    	
    }

    //converts Gregorian date to a Julian date 
    public double calculateJulian() {
        int a = (14 - month) / 12;
        int y = year + 4800 - a;
        int m = month + 12 * a - 3;
        int  jdn = day + (153 * m + 2) / 5 + 365 * y + y / 4 - y / 100 + y / 400 - 32045;
        double jd = jdn + (hour - 12) / 24.0 + minute / 1440.0 + second / 86400.0;
        return jd;	
    }

    //converts Julian date to a Gregorian date 
    //algorithm from chatGPT
      public JulianDate calculateGregorian(double jd) {
    	  int jdn = (int) Math.floor(jd + 0.5);
          double f = jd + 0.5 - jdn;
          int a, b, c, d, e, month, year, day, hour, minute;
          if (jdn >= 2299161) {
              a = (int) Math.floor((jdn - 1867216.25) / 36524.25);
              b = jdn + 1 + a - a / 4;
          } else {
              b = jdn;
          }
          c = b + 1524;
          d = (int) Math.floor((c - 122.1) / 365.25);
          e = (int) Math.floor(365.25 * d);
          month = (int) Math.floor((c - e) / 30.6001);
          day = (int) (c - e + f - (int) Math.floor(30.6001 * month));
          if (month <= 13) {
              month -= 1;
          } else {
              month -= 13;
          }
          if (month > 2) {
              year = d - 4716;
          } else {
              year = d - 4715;
          }
          hour = (int) Math.floor((jd + 0.5 - jdn) * 24);
          minute = (int) Math.floor(((jd + 0.5 - jdn) * 24 - hour) * 60);
          double second = ((jd + 0.5 - jdn) * 24 * 3600 - hour * 3600 - minute * 60);
          return new JulianDate(year, month, day, hour, minute, second);
    }
     
    // Pre-lab methods
    public int daysBetween(JulianDate other) {
        double difference = Math.abs(julianDate - other.getJulian());
        return (int) Math.round(difference);
    }

    public JulianDate tomorrow() {
        return new JulianDate(julianDate + 1);
    }

    public JulianDate yesterday() {
        return new JulianDate(julianDate - 1);
    }
    
    // get the weekday 
    public int getDayOfWeek() {
    	 int jdn = (int) Math.floor(julianDate + 0.5);
    	 int weekday = (int) jdn%7 + 1;
    	 return weekday;
    }
    
    //find the next christmas day on sunday after 25.12.20117
    public int getChristmasEveOnSunday() {
    	lastChirstmasYear++;
    	JulianDate newChristmasDay = new JulianDate(lastChirstmasYear, 12, 24, 0, 0, 0);
    	if(newChristmasDay.getDayOfWeek() == 7) {
//    		System.out.println(newChristmasDay.getYear());  //2023
    		return newChristmasDay.getYear();
    	}
    	return getChristmasEveOnSunday();
    }
    
    //returns the calculated Julian date and the fields
    public double getJulian() {
        return julianDate;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public double getSecond() {
        return second;
    }

}
