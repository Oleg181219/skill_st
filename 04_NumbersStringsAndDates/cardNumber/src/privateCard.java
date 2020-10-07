public class privateCard {


    /*private static boolean checkInput (String incomingNumber){
        for ( int i = 0; i <= incomingNumber.length(); i++){
            if (((int)incomingNumber.charAt(i) >= 48) & ((int)incomingNumber.charAt(i) >= 57)) ||
            ((int)incomingNumber.charAt(i) >= 32){

            }
        }
    }*/

    public static String searchAndReplaceDiamonds(String incomingNumber) {


        // String outComingNumber = new String();
        String rep = "***";
        String transformNumber = incomingNumber;
        int j = transformNumber.length();
        System.out.println(incomingNumber);
        int firstMin = transformNumber.indexOf("<");
        int firstMax = transformNumber.indexOf(">");
        String replace = transformNumber.substring(firstMin + 1, firstMax);
        System.out.println("1-" + replace);
        incomingNumber = incomingNumber.replace(replace, rep);
        System.out.println("2-" + incomingNumber);

            if ((incomingNumber.lastIndexOf(">") > firstMax &
                    ((incomingNumber.lastIndexOf(">")) <= incomingNumber.length()))) {
                int min = transformNumber.lastIndexOf("<");
                int max = transformNumber.lastIndexOf(">");
                replace = transformNumber.substring(min + 1, max);
                incomingNumber = incomingNumber.replace(replace, rep);
            }
        System.out.println("еще есть");

        return incomingNumber;


    }


}
