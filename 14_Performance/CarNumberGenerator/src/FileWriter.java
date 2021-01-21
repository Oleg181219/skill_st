import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter extends Thread {

    private StringBuffer stringBuffer = new StringBuffer();

    private int startRegionCode;
    private int finishRegionCode;
    private char[] letters;
    private int threadNum;
    private long start;

    public FileWriter(int startRegionCode, int endRegionCode, char[] letters, int threadNum, long startTime) {

        this.startRegionCode = startRegionCode;
        this.finishRegionCode = endRegionCode;
        this.letters = letters;
        this.threadNum = threadNum;
        this.start = startTime;
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, '0');
        }
        return numberStr.toString();
    }

    @Override
    public void run() {

        try {
            File resultFile = new File(createFilePath());
            PrintWriter printWriter = new PrintWriter(resultFile);

            for (int regionCode = startRegionCode; regionCode < finishRegionCode; regionCode++) {
                StringBuffer builder = new StringBuffer();
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                builder.append(firstLetter)
                                        .append(padNumber(number, 3))
                                        .append(secondLetter)
                                        .append(thirdLetter)
                                        .append(padNumber(regionCode, 2))
                                        .append("\n");
                            }
                        }
                    }
                }
                printWriter.write(builder.toString());
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println(stringBuffer.append("  Thread running time: ")
                .append(System.currentTimeMillis() - start)
                .append("ms.")
                .toString());
    }



    private String createFilePath() {
        stringBuffer.append("res/Thread№-(")
                .append(this.threadNum)
                .append(")_Regions_")
                .append(this.startRegionCode)
                .append("-")
                .append(this.finishRegionCode)
                .append(".txt");
        return stringBuffer.toString();
    }
}
