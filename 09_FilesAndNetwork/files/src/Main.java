import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat f = new DecimalFormat("##.00");


        for (; ; ) {
            try {
                System.out.println("Введите путь: ");
                String incomingPath = ((new BufferedReader(new InputStreamReader(System.in))).readLine()).trim();

                Path folder = Paths.get(incomingPath);
                double size = Files.walk(folder)
                        .filter(p -> p.toFile().isFile())
                        .mapToLong(p -> p.toFile().length())
                        .sum();

                int length = (int) (Math.log10(size) + 1);
                if(length >= 10 ){
                    System.out.println("Размер папки " + incomingPath +"cоставляет "+ f.format(size/1024/1024/1024) +" Gb");
                }
                if(length < 10 & length >= 7){
                    System.out.println("Размер папки " + incomingPath +"cоставляет "+f.format(size/1024/1024) +" Mb");
                }
                if(length < 7 & length >= 4){
                    System.out.println("Размер папки " + incomingPath +"cоставляет "+f.format(size/1024) +" kb");
                }
                if(length < 4){
                    System.out.println("Размер папки " + incomingPath +"cоставляет "+f.format(size) +" b");
                }
                System.out.println("кол-во символов "+length);
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());

            }

            }

        }
    }

