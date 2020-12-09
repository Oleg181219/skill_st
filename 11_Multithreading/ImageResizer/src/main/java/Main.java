import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImagingOpException;
import java.io.File;


public class Main {
    private static int newWidth = 300;

    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        String srcFolder = "/Users/olegprokhorov/Pictures/scr";
        String dstFolder = "/Users/olegprokhorov/Pictures/dst";
        long start = System.currentTimeMillis();
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        int mid = files.length / i;
        int startPos = 0;
//        BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws Exception {
//            return Scalr.resize(originalImage, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC,
//                    targetWidth, targetHeight, Scalr.OP_ANTIALIAS);
//        }
        try {
            for (int j = 0; j < mid; j++) {
                File[] nameMass = new File[mid];
                System.arraycopy(files, startPos, nameMass, 0, nameMass.length);
                ImageResizer resizer = new ImageResizer(nameMass, newWidth, dstFolder, start);
                new Thread(resizer).start();
                startPos += mid;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("num core: " + i);
        System.out.println(files.length);

    }

}
