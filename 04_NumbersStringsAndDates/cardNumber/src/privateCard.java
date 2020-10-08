public class privateCard {




    public static String searchAndReplaceDiamonds(String incomingNumber) {

        incomingNumber = incomingNumber.replaceAll("<.+?>", "***");
        incomingNumber = incomingNumber.replaceAll("\\s+", "");
        return incomingNumber;
    }


}
