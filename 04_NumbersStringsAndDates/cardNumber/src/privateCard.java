public class privateCard {




    public static String searchAndReplaceDiamonds(String incomingNumber) {



        String rep = "<***>";
        String replace = "";
        String transformNumber = incomingNumber;
        int lengthIncomingNumber = incomingNumber.length();

        System.out.println("входящее значение   = " + incomingNumber);



            while (transformNumber.lastIndexOf(">") < lengthIncomingNumber) {
                if (incomingNumber.lastIndexOf(">") != lengthIncomingNumber) {
                    int min = transformNumber.indexOf("<");
                    int max = transformNumber.indexOf(">");
                    replace = transformNumber.substring(min , max + 1 );
                    incomingNumber = incomingNumber.replace(replace, rep);
                    transformNumber = transformNumber.substring(max + 1);
                    System.out.println("=======" + transformNumber);
                    System.out.println(incomingNumber);
                }
            }

        return incomingNumber;


    }


}
