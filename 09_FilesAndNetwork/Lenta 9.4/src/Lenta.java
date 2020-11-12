import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lenta {
    private static final String target = "files/";
    private static Logger rootLogger;

    public static void main(String[] args) {
        rootLogger = LogManager.getRootLogger();
        try {
            Document doc = Jsoup.connect("https://lenta.ru").get();
            Elements links1 = doc.select("img");

            for (Element elements : links1) {
                String absHref = elements.attr("abs:src");
                URL website = new URL(absHref);
                String string = website.toString();
                String[] filds = string.split("/");
                String nameFile = filds[filds.length - 1];

                if (nameFile.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)")) {
                    String finalTarget = target.concat(nameFile);
                    File newDir = new File(target);
                    if (!newDir.exists()) newDir.mkdir();
                    ReadableByteChannel readableByteChannel = Channels.newChannel(website.openStream());
                    FileOutputStream fileOutputStream = new FileOutputStream(finalTarget);
                    fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            rootLogger.error(e.getMessage() + "\n");
        }

    }


}

