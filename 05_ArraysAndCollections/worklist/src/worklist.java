import java.util.ArrayList;
import java.util.Scanner;


public class worklist {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        char p = '0';
        char q = '9';

        while (true) {
            System.out.println("==================================================================");
            System.out.println("Введите команду. \n  LIST  выводит дела с их порядковым номером; " +
                    "\n  ADD  добавляет дело в конец списка или на определенное место при указании номера места; " +
                    "\n  EDIT  заменяет дело с указанным номером; " +
                    "\n  DELETE  удаляет");
            System.out.println("==================================================================");
            Scanner in = new Scanner(System.in);
            String incomingString = in.nextLine();
            if (!choice.checkInput(incomingString)) {
                continue;
            }
            String command = incomingString.toUpperCase();

            if (command.contains("ADD")) {
                if (choice.checkNum(incomingString)) {
                    list.add(choice.positionToAddNum(incomingString) - 1, choice.stringData(incomingString));
                } else list.add(choice.stringData(incomingString));
            }

            if (command.contains("LIST")) {
                if (list.size() == 0) {
                    System.out.println("Список дел пуст");
                }
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("Запись №" + (i + 1) + " " + list.get(i));
                }

            }
            if (command.contains("EDIT")) {
                if (choice.checkNum(incomingString)) {
                    if (list.size() > (choice.positionToAddNum(incomingString) - 1)) {
                        list.set(choice.positionToAddNum(incomingString) - 1, choice.stringData(incomingString));
                    } else System.out.println(" Такого поля не существует");
                }
            }

            if (command.contains("DELETE")) {
                if (list.isEmpty()) {
                    System.out.println("Список дел пуст");
                }
                list.remove(Integer.parseInt(incomingString.substring(incomingString.lastIndexOf(' ')).trim()) - 1);
            }
        }
    }
}
