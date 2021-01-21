import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

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

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-18M.xml";

        long usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLHandler handler= new XMLHandler();
        saxParser.parse(new File(fileName), handler);

        usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usage;
        System.out.println("usage SAX-parsing = " + usage);

        handler.printDuplicatedVotes();
        handler.printWorkTimes();
    }
}
