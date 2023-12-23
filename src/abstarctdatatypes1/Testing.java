package abstarctdatatypes1;



/**
 * A test harness for the JulianDate class.
 */
public class Testing {

    /**
     * Runs a series of tests on the JulianDate class and prints the results.
     */
    public static void main(String[] args) {
        testDaysBetween();
        testTomorrow();
        testYesterday();
        System.out.println("All tests passed!");
    }

    
    /**
     * Tests the daysBetween method of the JulianDate class.
     * Creates two JulianDate objects for known dates and checks that the number of days between them is correct.
     */
    public static void testDaysBetween() {
        JulianDate jd1 = new JulianDate(2021, 5, 1);
        JulianDate jd2 = new JulianDate(2021, 5, 5);
        int expected = 4;
        int actual = jd2.daysBetween(jd1);
        assertEquals(expected, actual, "testDaysBetween");
    }

    /**
     * Tests the tomorrow method of the JulianDate class.
     * Creates a JulianDate object for a known date and checks that the resulting date is one day after the original date.
     */
    public static void testTomorrow() {
        JulianDate jd = new JulianDate(2021, 5, 5);
        JulianDate expected = new JulianDate(2021, 5, 6);
        JulianDate actual = jd.tomorrow();
        assertEquals(expected.getJulian(), actual.getJulian(), "testTomorrow");
    }

    /**
     * Tests the yesterday method of the JulianDate class.
     * Creates a JulianDate object for a known date and checks that the resulting date is one day before the original date.
     */
    public static void testYesterday() {
        JulianDate jd = new JulianDate(2021, 5, 5);
        JulianDate expected = new JulianDate(2021, 5, 4);
        JulianDate actual = jd.yesterday();
        assertEquals(expected.getJulian(), actual.getJulian(), "testYesterday");
    }

    

    /**
     * Helper method to check that two integer values are equal.
     */
    private static void assertEquals(double d, double e, String testName) {
        if (d != e) {
            System.err.println("ERROR: " + testName + " failed.");
            System.err.println("Expected: " + d);
            System.err.println("Actual: " + e);
            System.exit(1);
        }
    }
}