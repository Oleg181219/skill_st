public class Alfabet {

    public static void main(String[] args) {

        String alfabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int stringLenght = alfabet.length();
        for (int i = 0; i< stringLenght; i++){
            System.out.println("Буква (" + alfabet.charAt(i) + ") имеет код =" + ((int)(alfabet.charAt(i))));
        }

    }
}
