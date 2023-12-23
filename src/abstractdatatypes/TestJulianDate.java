package abstractdatatypes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJulianDate {

	@Test
	  
    public void testDaysBetween() {
        JulianDate jd1 = new JulianDate(2021, 5, 1, 0, 0, 0);
        JulianDate jd2 = new JulianDate(2021, 5, 5, 0, 0, 0);
        int expected = 4;
        int actual = jd2.daysBetween(jd1);
        assertEquals(expected, actual);
    }
	@Test
    
    public void testTomorrow() {
        JulianDate jd = new JulianDate(2021, 5, 5, 0, 0, 0);
        JulianDate expected = new JulianDate(2021, 5, 6, 0, 0, 0);
        JulianDate actual = jd.tomorrow();
        assertEquals(expected.getJulian(), actual.getJulian(), 0.0001);
    }

	@Test
    
    public void testYesterday() {
        JulianDate jd = new JulianDate(2021, 5, 5, 0, 0, 0);
        JulianDate expected = new JulianDate(2021, 5, 4, 0, 0, 0);
        JulianDate actual = jd.yesterday();
        assertEquals(expected.getJulian(), actual.getJulian(), 0.0001);
    }
	@Test
	public void testcalculateJulian() {
		JulianDate jd = new JulianDate(2014, 1, 1, 0, 0, 0);
		double actual = jd.calculateJulian();
		assertEquals(actual, 2456658.50000, 0.00001);
	}
	
	@Test
    public void testCalculateGregorian() {
        JulianDate julianDate = new JulianDate();
        double julianValue = 2456658.50000; // Example Julian date value

        JulianDate gregorianDate = julianDate.calculateGregorian(julianValue);

        // Expected Gregorian date values
        int expectedYear = 2014;
        int expectedMonth = 1;
        int expectedDay = 1;
        int expectedHour = 0;
        int expectedMinute = 0;
        double expectedSecond = 0.0;

        // Asserting the converted Gregorian date values
        assertEquals(expectedYear, gregorianDate.getYear());
        assertEquals(expectedMonth, gregorianDate.getMonth());
        assertEquals(expectedDay, gregorianDate.getDay());
        assertEquals(expectedHour, gregorianDate.getHour());
        assertEquals(expectedMinute, gregorianDate.getMinute());
        assertEquals(expectedSecond, gregorianDate.getSecond(), 0.0001);
    }
	
	@Test
	public void testChristmasEve() {
		JulianDate jd = new JulianDate();
		int expected = 2023;
		int actual = jd.getChristmasEveOnSunday();
		assertEquals(expected, actual);
	}

	

}

