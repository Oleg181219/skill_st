import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class phone {

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("Введите номер телефона:");
            String incomingPhoneNumber = ((new BufferedReader(new InputStreamReader(System.in))).readLine()).trim();
            incomingPhoneNumber = incomingPhoneNumber.replaceAll("[^0-9]", "");
            if (!check(incomingPhoneNumber)) {
                continue;
            }
        }
    }

    public static boolean check(String incomingPhoneNumber) {
        int seven = '7';
        int eight = '8';
        if ((incomingPhoneNumber.length() > 11) || (incomingPhoneNumber.length() < 10)) {
            System.out.println("Проверьте количество цифр в номере. Обычно их 11 (одинадцать)");
            return false;
        }
        if (incomingPhoneNumber.length() == 10) {
            incomingPhoneNumber = "7" + incomingPhoneNumber;
            System.out.println("1:"+incomingPhoneNumber);
        }
        int firstNum = incomingPhoneNumber.charAt(0);
        if ((firstNum != seven) & (firstNum != eight)) {
            System.out.println("Неверный код страны");
            return false;
        }
        if (firstNum == eight) {
            incomingPhoneNumber = incomingPhoneNumber.replaceFirst("8", "7");
            System.out.println("2:"+incomingPhoneNumber);
            return true;
        }
        System.out.println(incomingPhoneNumber);
        return true;
    }
}


