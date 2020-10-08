public class privateCard {




    public static String searchAndReplaceDiamonds(String incomingNumber) {
        String rep = "<***>";
        String replace = "";
        String transformNumber = incomingNumber;
        while (transformNumber.lastIndexOf("<") != -1) {
                    int min = transformNumber.indexOf("<");
                    int max = transformNumber.indexOf(">");
                    replace = transformNumber.substring(min , max + 1 );
                    incomingNumber = incomingNumber.replace(replace, rep);
                    transformNumber = transformNumber.substring(max + 1);
            }
        return incomingNumber;
    }


}
