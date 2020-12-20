
import java.io.File;


public class Main {
    private static final int newWidth = 1024;


    public static void main(String[] args) {

        int i = Runtime.getRuntime().availableProcessors();
        String srcFolder = "/Users/olegprokhorov/Pictures/scr";
        String dstFolder = "/Users/olegprokhorov/Pictures/dst";
        long start = System.currentTimeMillis();
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        assert files != null;
        int mid = files.length / i;
        int startPos = 0;

        try {
            for (int j = 0; j < mid - 2; j++) {
                if ((mid * j + mid) < files.length) {
                    File[] nameMass = new File[mid];
                    int count = nameMass.length;
                    System.arraycopy(files, startPos, nameMass, 0, count);
                    BufferedImageResizer bufferedImageResizer = new BufferedImageResizer(nameMass, newWidth, dstFolder, start);
                    new Thread(bufferedImageResizer).start();
                }
                if (((mid * j + mid) > files.length) & (mid * j < files.length)) {
                    int count = files.length - (j * mid);
                    File[] nameMass = new File[count];
                    System.arraycopy(files, startPos, nameMass, 0, count );
                    BufferedImageResizer bufferedImageResizer = new BufferedImageResizer(nameMass, newWidth, dstFolder, start);
                    new Thread(bufferedImageResizer).start();
                }
                startPos += mid;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("num core: " + i);
        System.out.println(files.length);

    }
    // перая часть задания.
//                ImageResizer resizer = new ImageResizer(nameMass, newWidth, dstFolder, start);
//                new Thread(resizer).start();
    // со зездочкой
}
