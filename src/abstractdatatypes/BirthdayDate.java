package abstractdatatypes;

import java.time.LocalDate;
import java.util.Scanner;

public class BirthdayDate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Birth year: ");
        int year = scanner.nextInt();

        //prompt for birthday and make sure input is valid
        int month;
        do {
        	System.out.print("Birth month: ");
        	month = scanner.nextInt();
        	if(month < 0 || month > 12) {
        		System.out.println("invalid month");      
        	}
        }
        while( month < 0 || month > 12);

        
        int day;
        do {
        	System.out.print("Birth day: ");
        	day = scanner.nextInt();
        	if(day < 0 || day > 31) {
        		System.out.println("invalid day");
        	}
        }
        while( day < 0 || day > 31);
        
      

        JulianDate birthday = new JulianDate(year, month, day, 0, 0, 0);
        LocalDate now = LocalDate.now();
        JulianDate today = new JulianDate(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), 0, 0, 0);
        
        int ageInDays = today.daysBetween(birthday);
        int ageInYears = ageInDays / 365;
        int remainingdays = ageInDays % 365; 
        int monthsOld = remainingdays / 30; 
        int days = remainingdays % 30; 
        
        

        System.out.println("You are " + ageInYears + " years, " + monthsOld  + " months, and " + days + " days old.");
        System.out.println("You are " + ageInDays + " days old!");

        JulianDate birthDate = new JulianDate(year, month, day, 12, 0, 0);
        int weekday = birthDate.getDayOfWeek(); 
        String weekdayName = "";
        switch (weekday) {
            case 0:
                weekdayName = "Sunday";
                break;
            case 1:
                weekdayName = "Monday";
                break;
            case 2:
                weekdayName = "Tuesday";
                break;
            case 3:
                weekdayName = "Wednesday";
                break;
            case 4:
                weekdayName = "Thursday";
                break;
            case 5:
                weekdayName = "Friday";
                break;
            case 6:
                weekdayName = "Saturday";
                break;
        }

        System.out.println("You were born on a " + weekdayName);

        if (today.getMonth() == birthDate.getMonth() && today.getDay() == birthDate.getDay()) {
            System.out.println("Happy birthday!");
        }

        if (ageInDays % 100 == 0) {
            System.out.println("Congratulations on living " + ageInDays + " days!");
        }
        scanner.close();
    }

}