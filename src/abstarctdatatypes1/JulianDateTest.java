package abstarctdatatypes1;

public class JulianDateTest {

   
	public static void main(String[] args) {
        // Test case 1: Basic date conversion
        JulianDate jd1 = new JulianDate(2022, 1, 1);
        assert jd1.getJulian() == 2459580.5;
        assert jd1.getGregorian()[0] == 2022;
        assert jd1.getGregorian()[1] == 1;
        assert jd1.getGregorian()[2] == 1;

        // Test case 2: Days between dates
        JulianDate jd2 = new JulianDate(2023, 1, 10);
        assert jd2.daysBetween(jd1) == 9;

        // Test case 3: Tomorrow method
        JulianDate jd3 = jd1.tomorrow();
        assert jd3.getJulian() == 2459581.5;
        assert jd3.getGregorian()[0] == 2022;
        assert jd3.getGregorian()[1] == 1;
        assert jd3.getGregorian()[2] == 2;

        // Test case 4: Yesterday method
        JulianDate jd4 = jd2.yesterday();
        assert jd4.getJulian() == 2459579.5;
        assert jd4.getGregorian()[0] == 2022;
        assert jd4.getGregorian()[1] == 1;
        assert jd4.getGregorian()[2] == 9;

        // Test case 5: Leap year conversion
        JulianDate jd5 = new JulianDate(2000, 2, 29);
        assert jd5.getJulian() == 2451604.5;
        assert jd5.getGregorian()[0] == 2000;
        assert jd5.getGregorian()[1] == 2;
        assert jd5.getGregorian()[2] == 29;
    }
}