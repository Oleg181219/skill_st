public class choice {
    private static int positionToAdd = 0;


    public static Boolean checkInput(String incomingString) {
        String command = incomingString.toUpperCase();
        if (command.contains("ADD") | command.contains("EDIT") | command.contains("DELETE")
                | command.contains("LIST"))
            return true;
        System.out.println("Нет такой команды. Внимательно проверьте правильность ввода команды");
        return false;
    }

    public static String stringData(String incomingString) {
        String data = incomingString.substring(incomingString.indexOf(' ')).trim();
        if ((data.charAt(0) > 48) & (data.charAt(0) <= 57)) {
            data = data.substring(data.indexOf(' ')).trim();
            return data;
        }
        return data;
    }

    public static int positionToAddNum(String incomingString) {
        String data = incomingString.substring(incomingString.indexOf(' ')).trim();
        positionToAdd = Integer.parseInt(data.substring(0, data.indexOf(' ')));
        return positionToAdd;
    }

    public static boolean checkNum(String incomingString) {
        String data = incomingString.substring(incomingString.indexOf(' ')).trim();
        if (((int) data.charAt(0) >= 48) & ((int) data.charAt(0) <= 57)) {
            return true;
        }
        return false;
    }
}


