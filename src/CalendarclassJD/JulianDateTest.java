package CalendarclassJD;

public class JulianDateTest {

	public static void main(String[] args) {
		// Test cases
        JulianDate date1 = new JulianDate(2023, 1, 1);
        JulianDate date2 = new JulianDate(2023, 2, 15);
        System.out.println("Days between date1 and date2: " + date1.daysBetween(date2));

        JulianDate date3 = new JulianDate(2022, 12, 20);
        JulianDate date4 = new JulianDate(2023, 1, 10);
        System.out.println("Days between date3 and date4: " + date3.daysBetween(date4));

        JulianDate date5 = new JulianDate(2023, 3, 10);
        JulianDate date6 = new JulianDate(2023, 3, 11);
        System.out.println("Days between date5 and date6: " + date5.daysBetween(date6));

        JulianDate date7 = new JulianDate(2023, 9, 1);
        JulianDate date8 = new JulianDate(2023, 9, 1);
        System.out.println("Days between date7 and date8: " + date7.daysBetween(date8));

        JulianDate tomorrow = date1.tomorrow();
        System.out.println("Tomorrow's date: " + tomorrow.getYear() + "-" + tomorrow.getMonth() + "-" + tomorrow.getDay());

        JulianDate yesterday = date2.yesterday();
        System.out.println("Yesterday's date: " + yesterday.getYear() + "-" + yesterday.getMonth() + "-" + yesterday.getDay());
	}

}
