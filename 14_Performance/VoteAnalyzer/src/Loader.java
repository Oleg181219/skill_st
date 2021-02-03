
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;


/**
 * Что нужно сделать
 * <p>
 * 1. Перепишите проект VoteAnalyzer, чтобы в нём применялся SAXParser.
 * <p>
 * 2. Оптимизируйте его по использованию памяти.
 * <p>
 * 3. Измерьте три значения используемой памяти при парсинге файла data-18M.xml:
 * - при использовании DOM-парсера, 102-106 млн байт
 * - при использовании SAXParser’а, 112-114 млн байт
 * - после дополнительной оптимизации.
 */

public class Loader {

    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();


    public static void main(String[] args) throws Exception {
        /**
         * 12233891
         * выбор файла для парсинга
         */
//        String fileName = "res/data-0.2M.xml";
//        String fileName = "res/data-1M.xml";
//        String fileName = "res/data-18M.xml";
        String fileName = "res/data-1572M.xml";

        long time = System.currentTimeMillis();
        long usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();


        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();

        /**
         * инициализация подключения к базе
         * создание таблицы
         */
        DBConnection.getConnection();

        /**
         * запуск SAX-парсинга
         */
        saxParser.parse(new File(fileName), handler);
        System.out.println("memory usage = " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) - usage));
        System.out.println("time  = " + (System.currentTimeMillis() - time));


    }
}
