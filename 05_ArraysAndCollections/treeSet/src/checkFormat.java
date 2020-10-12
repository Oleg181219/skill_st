public class checkFormat {
    private static String stringBegin;
    private static String stringEnd;


    public static Boolean checkInput(String incomingString) {
        String command = incomingString.toUpperCase();
        if (command.contains("ADD") | command.contains("LIST"))
            return true;
        System.out.println("Нет такой команды. Внимательно проверьте правильность ввода команды");
        return false;
    }

    public static Boolean checkFormatMail(String incomingString) {

        if (!incomingString.contains("@")) {
            System.out.println("Неверный формат e-mail");
            return false;
        }

        String stringBegin = incomingString.substring(incomingString.indexOf(' ')).trim();
        String middle = stringBegin.substring(0, stringBegin.indexOf("@")).trim();
        String stringEnd = incomingString.substring(incomingString.indexOf('@') + 1).trim();

        if (middle.contains(" ")) {
            System.out.println("Неверный формат e-mail");
            return false;
        }
        System.out.println("stringEnd  " + stringEnd);
        if (!stringEnd.contains(".")) {
            System.out.println("Неверный формат e-mail");
            return false;
        }
        return true;
    }


}
