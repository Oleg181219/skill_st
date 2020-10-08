import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;


public class fio {



    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("Введите Фамилию Имя Отчество:");
            String incomingString = ((new BufferedReader(new InputStreamReader(System.in))).readLine()).trim();

            if (!check(incomingString)) {
                continue;
            }

            Pattern p = Pattern.compile("\\s+");
            String[] newString = p.split(incomingString);
            for( int i = 0; i < newString.length; i++){
                if( i == 0){
                    newString[i] = newString[i].trim();
                    newString[i] = newString[i].substring(0,1).toUpperCase() + newString[i].substring(1).toLowerCase();
                    System.out.println("Фамилия: " + newString[i]);
                }
                if( i == 1){
                    newString[i] = newString[i].trim();
                    newString[i] = newString[i].substring(0,1).toUpperCase() + newString[i].substring(1).toLowerCase();
                    System.out.println("Имя: " + newString[i]);
                }
                if( i == 2){
                    newString[i] = newString[i].trim();
                    newString[i] = newString[i].substring(0,1).toUpperCase() + newString[i].substring(1).toLowerCase();
                    System.out.println("Отчество: " + newString[i]);
                }
            }
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


