import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;


public class licenseplate {

    public static void main(String[] args) {
        String licenseplate = "";
        String zero = "000";
        String zeroNum = "0";

        ArrayList<Integer> region = new ArrayList<>();
        ArrayList<String> arrayPlate = new ArrayList<>();
        for (int reg = 1; reg <= 199; reg++) {
            for (int letters1 = 1040; letters1 <= 1061; letters1++) {
                if ((letters1 == 1040) | (letters1 == 1042) | (letters1 == 1045) | (letters1 == 1050) | (letters1 == 1052) |
                        (letters1 == 1053) | (letters1 == 1054) | (letters1 == 1056) | (letters1 == 1057) | (letters1 == 1058) |
                        (letters1 == 1059) | (letters1 == 1061)) {
                    for (int letters2 = 1040; letters2 <= 1061; letters2++) {
                        if ((letters2 == 1040) | (letters2 == 1042) | (letters2 == 1045) | (letters2 == 1050) | (letters2 == 1052) |
                                (letters2 == 1053) | (letters2 == 1054) | (letters2 == 1056) | (letters2 == 1057) | (letters2 == 1058) |
                                (letters2 == 1059) | (letters2 == 1061)) {
                            for (int letters3 = 1040; letters3 <= 1061; letters3++) {
                                if ((letters3 == 1040) | (letters3 == 1042) | (letters3 == 1045) | (letters3 == 1050) | (letters3 == 1052) |
                                        (letters3 == 1053) | (letters3 == 1054) | (letters3 == 1056) | (letters3 == 1057) | (letters3 == 1058) |
                                        (letters3 == 1059) | (letters3 == 1061)) {
                                    for (int num = 0; num < 1000; num++) {
                                        // if (letters1 == letters2 & letters2 == letters3) {  если нужны номера только одинаковые буквы и одинаковые цифры, убираем комент
                                        if (num == 0) {
                                            if (reg >= 10) {
                                                licenseplate = String.valueOf((char) letters1).concat(zero).concat(String.valueOf((char) letters2))
                                                        .concat(String.valueOf((char) letters3)).concat(Integer.toString(reg));
                                                arrayPlate.add(licenseplate);
                                            }
                                            if (reg < 10) {
                                                licenseplate = String.valueOf((char) letters1).concat(zero).concat(String.valueOf((char) letters2))
                                                        .concat(String.valueOf((char) letters3)).concat(zeroNum).concat(Integer.toString(reg));
                                                arrayPlate.add(licenseplate);
                                            }
                                        }
                                        if (((num % 111) == 0) & (num != 0)) {
                                            if (reg >= 10) {
                                                licenseplate = String.valueOf((char) letters1).concat(Integer.toString(num)).concat(String.valueOf((char) letters2))
                                                        .concat(String.valueOf((char) letters3)).concat(Integer.toString(reg));
                                                arrayPlate.add(licenseplate);
                                            }
                                            if (reg < 10) {
                                                licenseplate = String.valueOf((char) letters1).concat(Integer.toString(num)).concat(String.valueOf((char) letters2))
                                                        .concat(String.valueOf((char) letters3)).concat(zeroNum).concat(Integer.toString(reg));
                                                arrayPlate.add(licenseplate);
                                            }
                                        }
                                        // } и тут тоже.
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(arrayPlate);
        Set<String> hashSet = new HashSet<>(arrayPlate);
        Set<String> treeSet = new TreeSet<>(arrayPlate);

        System.out.println("Длинна листа = " + arrayPlate.size());
        System.out.println("длина HashSet = " + hashSet.size());
        System.out.println("длина TreeSet = " + treeSet.size());

        Boolean l = true;

        while (l) {
            Scanner in = new Scanner(System.in);
            String number = in.nextLine();

            System.out.println("Время поиска перебором в ArrayList = " + find.sortBruteForceTime(arrayPlate, number) + "ms");
            System.out.println("Бинарный поиск в ArrayList = " + find.BinaryTime(arrayPlate, number) + "ms");
            System.out.println("поиск в HashSet = " + find.hashSetTime(hashSet, number) + "ms");
            System.out.println("поиск в TreeSet = " + find.treeSetTime(treeSet, number) + "ms");
        }

    }
}

