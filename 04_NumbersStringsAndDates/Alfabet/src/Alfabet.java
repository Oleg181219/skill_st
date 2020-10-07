import java.util.regex.Pattern;

public class Alfabet {

    public static void main(String[] args) {

       /* String alfabet = "<>";
        int stringLenght = alfabet.length();
        for (int i = 0; i < stringLenght; i++) {
            System.out.println("Буква (" + alfabet.charAt(i) + ") имеет код =" + ((int) (alfabet.charAt(i))));
        }
*/
        Pattern p = Pattern.compile("\\s+");
    String news = "Britain’s finance minister has charmed the public with his easy manner and empathy since the " +
            "pandemic plunged the country into crisis in March. Over coffee and croissants in his rooms at No. " +
            "11 Downing Street, Rishi Sunak is now winning over his party—and a growing number of his colleagues " +
            "want him to move next door to take over as prime minister.";
        System.out.println(news);
        System.out.println(news.length());
        String[] newString = p.split(news);
        for (int i = 0; i < newString.length; i++){
            System.out.println(newString[i]);
        }

    }
}
