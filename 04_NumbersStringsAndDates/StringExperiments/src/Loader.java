
public class Loader {


    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        System.out.println(text);

        int startVasya = text.indexOf("Вася заработал");
        int finishVasya = text.indexOf("руб");
        String res1 = text.substring(startVasya + 14, finishVasya).trim();
        int startPetya = text.indexOf("Петя -");
        int finishPetya = text.indexOf(", а Маша");
        String res2 = text.substring(startPetya + 6, finishPetya - 5).trim();
        int startMasha = text.indexOf("Маша - ");
        int finishMasha = text.lastIndexOf("рублей");
        String res3 = text.substring(startMasha + 6, finishMasha).trim();

        int summ = Integer.parseInt(res1) + Integer.parseInt(res3) + Integer.parseInt(res2);
        System.out.println(summ);

        String newText = text.replaceAll("[^0-9]", " ");
        System.out.println(newText);
        String[] sent = newText.split("\\s+");
        int newSumm = 0;
        for (int i = 1; i < sent.length; i++) {
            sent[i] = sent[i].trim();
            /*System.out.println(sent[i]);
            System.out.println(sent[i].length());*/
            newSumm += Integer.parseInt(sent[i]);

        }
        System.out.println(" сумма зарплат = " + newSumm + " руб.");
    }


}