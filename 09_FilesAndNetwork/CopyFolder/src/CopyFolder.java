import java.io.*;

public class CopyFolder {

    public static void main(String[] args) {
        try {
            System.out.println("Введите путь к копируемой папке: ");
            String incomingPath = ((new BufferedReader(new InputStreamReader(System.in))).readLine()).trim();

            System.out.println("Введите путь куда копировать: ");
            String outcomingPath = ((new BufferedReader(new InputStreamReader(System.in))).readLine()).trim();

            File sourceFolder = new File(incomingPath);
            File destinationFolder = new File(outcomingPath);

            if (!sourceFolder.exists()) {
                System.out.println("Такого пути не сущестует.");
                System.exit(0);
            } else {
                copyFolder(sourceFolder, destinationFolder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

    public static void copyFolder(File sourceFolder, File destinationFolder) {

        if (sourceFolder.isDirectory()) {
            if (!destinationFolder.exists()) {
                destinationFolder.mkdir();
                System.out.println("Директория скопирована из " + sourceFolder + "  в " + destinationFolder);
            }

            String[] files = sourceFolder.list();

            assert files != null;
            for (String file : files) {
                File srcFile = new File(sourceFolder, file);
                File destFile = new File(destinationFolder, file);
                copyFolder(srcFile, destFile);
            }
        } else {
            try {
                InputStream in = new FileInputStream(sourceFolder);
                OutputStream out = new FileOutputStream(destinationFolder);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                in.close();
                out.close();
                System.out.println("Файл скопирован из " + sourceFolder + " в " + destinationFolder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}




