package abstarctdatatypes1;

import java.util.Scanner;

import abstractdatatypes.JulianDate;

public class JulianDateBirthday {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Ask for birthday input
        System.out.print("Enter your birthday (yyyy mm dd): ");
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();
        
        // Calculate days old and weekday born
        JulianDate birthday = new JulianDate(year, month, day, 0, 0, 0);
        JulianDate today = new JulianDate(2023, 5, 6, 0, 0, 0);
        int daysOld = today.daysBetween(birthday);
        String weekdayBorn = getWeekdayName(birthday.calculateGregorian(birthday.getJulian()).getDayOfWeek());
        
        // Print results
        System.out.println("You are " + daysOld + " days old!");
        System.out.println("You were born on a " + weekdayBorn + ".");
        if (today.getMonth() == month && today.getDay() == day) {
            System.out.println("Happy birthday! 🎂");
        }
        if (daysOld % 100 == 0) {
            System.out.println("Congratulations on living " + daysOld + " days!");
        }
    }
    
    // Returns the name of the weekday based on a number (0 = Sunday, 1 = Monday, etc.)
    private static String getWeekdayName(int weekday) {
        String[] weekdayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return weekdayNames[weekday];
    }
}
