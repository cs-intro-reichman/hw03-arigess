/**
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2;     // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days in January

    /**
     * Prints the calendars of all the years in the 20th century. Also prints the
     * number of Sundays that occured on the first day of the month during this period.
     */
    public static void main(String args[]) {
        int requestedYear = Integer.parseInt(args[0]);
        while (year != requestedYear) { //until we reach the requested year
            advance();
        }
        while (year == requestedYear) {
            if (dayOfWeek == 1) {
                System.out.printf("%d/%d/%d Sunday\n", dayOfMonth, month, year);
            } else {
                System.out.printf("%d/%d/%d\n", dayOfMonth, month, year);
            }
            advance();

        }


    }

    // Advances the date (day, month, year) and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
    private static void advance() {
        if (dayOfWeek == 7) {
            dayOfWeek = 1;
        } else dayOfWeek++;
        if (dayOfMonth == nDaysInMonth) { //means we advance a month
            dayOfMonth = 1;
            if (month == 12) { //if that's the end of December
                month = 1;
                year++;
            } else month++;
            nDaysInMonth = nDaysInMonth(month, year);
        } else dayOfMonth++;

    }

    // Returns true if the given year is a leap year, false otherwise.
    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    // Returns the number of days in the given month and year.
    // April, June, September, and November have 30 days each.
    // February has 28 days in a common year, and 29 days in a leap year.
    // All the other months have 31 days.
    private static int nDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (isLeapYear(year)) return 29;
                else return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return 0;
    }
}