import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cardNumber {
    public static void main(String[] args) throws IOException {


       /* System.out.println("Введите Фамилию Имя Отчество:");
        String incomingNumber = ((new BufferedReader(new InputStreamReader(System.in))).readLine()).trim();*/
        String incomingNumber = "<1234> <7464> 2745 <7468>";
        //privateCard.searchAndReplaceDiamonds(incomingNumber);
       System.out.println("4-"+privateCard.searchAndReplaceDiamonds(incomingNumber));
    }
}


