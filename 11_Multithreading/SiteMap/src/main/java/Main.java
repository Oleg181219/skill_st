import java.io.FileOutputStream;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static String ROOT_SITE = "https://lenta.ru/";

    public static void main(String[] args){
        MainNode sitemapRoot = new MainNode(ROOT_SITE);
        new ForkJoinPool().invoke(new MainNodeRecursive(sitemapRoot));
        FileOutputStream stream;
        try {
            stream = new FileOutputStream("src/main/resources/sitemap.txt");
            String result = createSitemapString(sitemapRoot, 0);
        stream.write(result.getBytes());
        stream.flush();
        stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String createSitemapString(MainNode node, int depth) {
        String tabs = String.join("", Collections.nCopies(depth, "\t"));
        StringBuilder result = new StringBuilder(tabs + node.getUrl());
        node.getChildren().forEach(child -> {
            result.append("\n").append(createSitemapString(child, depth + 1));
        });
        return result.toString();

    }
}
