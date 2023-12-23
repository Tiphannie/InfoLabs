package abstarctdatatypes1;

public class JulianDate {

    private double julianDate;
    
    public JulianDate(double julianDate) {
        this.julianDate = julianDate;
    }

    public JulianDate(int year, int month, int day) {
        this.julianDate = calculateJulian(year, month, day);
    }

   
    
    //converts Gregorian date to a Julian date 
    private static double calculateJulian(int year, int month, int day) {
        int a = (14 - month) / 12;
        int y = year + 4800 - a;
        int m = month + 12 * a - 3;
        int  jdn = day + (153 * m + 2) / 5 + 365 * y + y / 4 - y / 100 + y / 400 - 32045;
        return jdn + 0.5;
    }
    
    //returns the calculated Julian date 
    public double getJulian() {
        return julianDate;
    }

    

    //converts Julian date to a Gregorian date 
      private int[] calculateGregorian() {
          int jdn = (int) Math.floor(julianDate + 0.5);
          int f = (int) Math.floor(jdn + 1401) * 4 / 1461;
          int e = (int) (jdn - 1461 * f / 4 + 31) * 12 / 36525;
          int day = (int) (jdn - 1461 * f / 4 + 153 * e / 5);
          int month = (int) (e + 3 - 12 * (e / 10));
          int year = (int) (f - 4715 + (7 - month) / 10);
          return new int[]{year, month, day};
    }
      
   //returns the calculated Gregorian date 
     public int[] getGregorian() {
          return calculateGregorian();
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
    
    //converting the dates from one type to the other 
    public int[] gregorianFromDate(int year, int month, int day) {
        JulianDate jd = new JulianDate(year, month, day);
        return jd.calculateGregorian();
    }

    public static int[] julianFromDate(int year, int month, int day) {
        double jd = calculateJulian(year, month, day);
        JulianDate julianDate = new JulianDate(jd);
        int[] gregorianDate = julianDate.calculateGregorian();
        return new int[]{gregorianDate[0], gregorianDate[1], gregorianDate[2]};
    }


}
