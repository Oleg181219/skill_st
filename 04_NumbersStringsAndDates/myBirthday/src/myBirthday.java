import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class myBirthday {


    public static void main(String[] args) {
        int day = 18;
        int month = 12;
        int year = 1977;

        SimpleDateFormat dateFormat = new SimpleDateFormat(" - dd.MM.yyyy -  EEE", Locale.ENGLISH);
        Calendar calendar = new GregorianCalendar(year, Calendar.JANUARY, day);
        calendar.set(Calendar.MONTH, month - 1);
        while (calendar.get(Calendar.YEAR) < Calendar.getInstance().get(Calendar.YEAR)) {
            System.out.println(((calendar.get(Calendar.YEAR)+1) - year - 1) + dateFormat.format((calendar.getTime())));
            calendar.add(Calendar.YEAR, 1);
        }
    }
}
