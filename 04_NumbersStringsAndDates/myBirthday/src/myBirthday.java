import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class myBirthday {


    public static void main(String[] args) {
        int day = 18;
        int month = 12;
        int year = 1977;
        SimpleDateFormat dateFormat = new SimpleDateFormat(" - dd.MM.yyyy -  EEE", Locale.ENGLISH);// убираем локализацию, получаем на русском
        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);
        System.out.println(nowYear);
        Calendar calendar = new GregorianCalendar(year, Calendar.JANUARY, day);
        calendar.set(Calendar.MONTH, month - 1);
        int i = calendar.get(Calendar.YEAR);
        while (i <= nowYear) {
            System.out.println(((i+1) - year - 1) + dateFormat.format((calendar.getTime())));
            calendar.add(Calendar.YEAR, 1);
            i = calendar.get(Calendar.YEAR);
        }
    }
}
