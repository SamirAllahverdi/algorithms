package newImplemenations.hackerRank;

import java.util.Arrays;
import java.util.List;

public class DayOfProgrammer {

    public static final int NOT_START_FROM_0_INDEX = 0;
    public static final int TRANSITION_YEAR = 1918;
    public static final int DAY_OF_PROGRAMMER = 256;
    public static final int FEBRUARY = 2;
    public static final int DAYS_OF_FEBRUARY_IN_TRANSITION_YEAR = 15;
    public static final int DAYS_OF_FEBRUARY_IN_LEAP_YEAR = 29;

    static List<Integer> daysOfMonth =
            Arrays.asList(NOT_START_FROM_0_INDEX,
                    31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

    /**
     * https://www.hackerrank.com/challenges/day-of-the-programme
     */
//    public static void main(String[] args) {
//
//        System.out.println(dayOfProgrammer(TRANSITION_YEAR)); /* expected 26.09.1918*/
//        System.out.println(dayOfProgrammer(2017)); /* expected 13.09.2017 */
//        System.out.println(dayOfProgrammer(2700)); /* expected 13.09.2700 */
//    }


    public static String dayOfProgrammer(int year) {

        int day = 0;
        int programmerDayMonth = 0;
        int programmerDayMonthOfDay = 0;

        for (int month = 1; month < daysOfMonth.size(); month++) {

            if (day + daysOfMonth.get(month) >= DAY_OF_PROGRAMMER) {
                programmerDayMonthOfDay = DAY_OF_PROGRAMMER - day;
                programmerDayMonth = month;
                break;
            }

            if (month == FEBRUARY && year == TRANSITION_YEAR) {
                day += DAYS_OF_FEBRUARY_IN_TRANSITION_YEAR;
            } else if (month == FEBRUARY && isLeapYear(year)) {
                day += DAYS_OF_FEBRUARY_IN_LEAP_YEAR;
            } else {
                day += daysOfMonth.get(month);
            }
        }

        return String.format("%d.%02d.%d", programmerDayMonthOfDay, programmerDayMonth, year);
    }

    public static boolean isLeapYear(int year) {
        return year < TRANSITION_YEAR ?
                isJulianCalendarLeapYear(year) : isGregorianCalendarLeapYear(year);
    }

    private static boolean isGregorianCalendarLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }


    private static boolean isJulianCalendarLeapYear(int year) {
        return year % 4 == 0;
    }

}


