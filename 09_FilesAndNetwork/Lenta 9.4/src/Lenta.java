import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.Objects;

public class Lenta {
    private static String target = "files/";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://lenta.ru").get();
            Elements links1 = doc.select("img");

            for (Element elements : links1) {
                String absHref = elements.attr("abs:src");
                URL website = new URL(absHref);
                String string = website.toString();
                String[] filds = string.split("/");
                String nameFile = filds[filds.length - 1];
                String finalTarget = target.concat(nameFile);
                ReadableByteChannel readableByteChannel = Channels.newChannel(website.openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(finalTarget);
                fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

            }
            // это Objects.requireNonNull(directory.listFiles()))  IDEA  попросила. Я не стал отказываться.
            // разбираюсь что это такое.
            File directory = new File(target);
            Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                    .map(File::getName)
                    .forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

