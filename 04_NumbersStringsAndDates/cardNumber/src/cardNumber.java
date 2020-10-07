import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cardNumber {
    public static void main(String[] args) throws IOException {


       System.out.println("Введите номер карты. Выделите знаками < > те цифры которые нужно скрыть");
        String incomingNumber = ((new BufferedReader(new InputStreamReader(System.in))).readLine()).trim();


       System.out.println("4-"+privateCard.searchAndReplaceDiamonds(incomingNumber));
    }
}


