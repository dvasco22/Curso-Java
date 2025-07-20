package local.data;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Dates {

    @SuppressWarnings("deprecation")
    void useDate() {
        // Deprecated since Java 1.1, but still widely used
        // Use java.time package for new code
        Date date = new Date();
        System.out.println("Current Date: " + date);
        System.out.println("Year: " + (date.getYear() + 1900)); // getYear() is deprecated
        System.out.println("Month: " + (date.getMonth() + 1)); // getMonth() is deprecated
        System.out.println("Day: " + date.getDate());
    }

    void useCalendar() {
        // Calendar is more flexible than Date, but still considered legacy
        // Use java.time package for new code
        Calendar calendar = Calendar.getInstance();
        System.out.println("Current Calendar Date: " + calendar.getTime());
        System.out.println("Year: " + calendar.get(Calendar.YEAR));
        System.out.println("Month: " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("Day: " + calendar.get(Calendar.DAY_OF_MONTH));
    }

    void useLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Current LocalDateTime: " + localDateTime);
        System.out.println("Year: " + localDateTime.getYear());
        System.out.println("Month: " + localDateTime.getMonthValue());
        System.out.println("Day: " + localDateTime.getDayOfMonth());
        System.out.println(localDateTime.plusDays(100));

    }

    public static void main(String[] args) {
        Dates dates = new Dates();
        dates.useLocalDateTime();
    }

}