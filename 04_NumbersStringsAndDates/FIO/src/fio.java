import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class fio {
    private static final int numSpace = 2;


    public static void main(String[] args) throws IOException {
        String space = new String(" ");


        while (true) {
            System.out.println("Введите Фамилию Имя Отчество:");
            String incomingString = ((new BufferedReader(new InputStreamReader(System.in))).readLine()).trim();

            if (!check(incomingString)) {
                continue;
            }

            int space1 = incomingString.indexOf(space);
            String familya = incomingString.substring(0, space1).trim();  // обрезаем лишние пробелы
            String newFamilya = familya.substring(0,1).toUpperCase() + familya.substring(1).toLowerCase(); // возвращаем первый символ в верхнем регистре остальные в нижнем
            System.out.println("Фамилия: " + newFamilya);
            int space2 = incomingString.lastIndexOf(space);
            String name = incomingString.substring(space1, space2).trim();
            String newName = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
            System.out.println("Имя: " + newName);
            String patronymic = incomingString.substring(space2, incomingString.length()).trim();
            String newPatronymic = patronymic.substring(0,1).toUpperCase() + patronymic.substring(1).toLowerCase();
            System.out.println("Отчество: " + newPatronymic);

            break;
        }
    }

    private static boolean check(String incomingString) {
        int numSpace1 = 0;
        for (int i = 0; i < incomingString.length(); i++) {
            if (incomingString.charAt(i) == 32) {
                numSpace1++;
            }
        }
        if (numSpace1 !=2){
            System.out.println("ФИО состоит из трех слов. Введите пожалуйста ФИО правильно");
            return false;
        }return true;
    }


}


