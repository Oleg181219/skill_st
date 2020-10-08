public class Mnemonic {

    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        System.out.println(text);
        String[] mnem = text.split(",?\\s+");
        int i = 0;
        String bufer = "";
        while (!mnem[i].equals(mnem[mnem.length - 1 - i])) {
            bufer = mnem[i];
            mnem[i] = mnem[mnem.length - 1 - i];
            mnem[mnem.length - 1 - i] = bufer;
            i++;
        }
        for (int j = 0; j < mnem.length; j++) {
            System.out.print(" " + mnem[j]);
        }
    }
}
