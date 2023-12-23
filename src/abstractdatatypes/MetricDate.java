package abstractdatatypes;

public class MetricDate{
	int year;
	int month;
	int day;
	
	public MetricDate(JulianDate jd) {
		fromJulianDate(jd);
	}
	
	public static void main(String[] args) {
		JulianDate jd = new JulianDate(2002, 23, 2, 0, 0, 0);
		MetricDate md = new MetricDate(jd);
		md.printBirthday();
		System.out.println(md.toJulianDate());
	}
	//conver from juliandate to metricdate
	private void fromJulianDate(JulianDate julianDate) {
	    int julianDayNumber = (int) julianDate.calculateJulian();
	    // here we assume the year will start from 0;
	    int metricYear = julianDayNumber / (1000); 
	    int metricMonth = (julianDayNumber / 100) % 10;
	    int metricDay = julianDayNumber % 100;
	    year = metricYear;
	    month = metricMonth;
	    day = metricDay;
	    return; 
	}
	
	public void printBirthday() {
		System.out.println("You are " + year + " years old");
	}
	
	//convert from metricdate to juliandate
	public double toJulianDate() {
	    int julianDayNumber = year * 1000 + month * 10 + day;
	    return julianDayNumber - 0.5;
	}
}

