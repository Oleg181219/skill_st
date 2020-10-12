import java.util.Scanner;
import java.util.TreeSet;


public class main {
    public static void main(String[] args) {
        TreeSet<String> email = new TreeSet<>();
        String data;

        while (true) {
            System.out.println("==================================================================");
            System.out.println("Введите команду. " +
                    "\nADD  добавляет email в список; " +
                    "\nLIST  выводит список e-mail; ");
            System.out.println("==================================================================");
            Scanner in = new Scanner(System.in);
            String incomingString = in.nextLine().trim();
            if (!checkFormat.checkInput(incomingString)) {
                continue;
            }
            String command = "";
            command = incomingString.toUpperCase();
            if (command.contains("LIST")) {
                if (email.isEmpty()) {
                    System.out.println("Список пустой");
                }
                System.out.println(email);
            }
            if (command.contains("ADD")) {
                if (checkFormat.checkFormatMail(incomingString)) {
                    email.add(incomingString.substring(incomingString.indexOf(' ')));

                }
            }
        }
    }
}
