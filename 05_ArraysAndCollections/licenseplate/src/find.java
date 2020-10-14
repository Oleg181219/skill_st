import java.util.*;

public class find {


    public static long sortBruteForceTime(ArrayList<String> arrayList, String number) {
        long startTime = System.nanoTime();
        arrayList.contains(number);
        long endTime = System.nanoTime() - startTime;
        return endTime;
    }

    public static long BinaryTime(ArrayList<String> arrayList, String number) {
        long startTime = System.nanoTime();
        Collections.binarySearch(arrayList, number);
        System.out.println("номер позиции в листе " + Collections.binarySearch(arrayList, number));
        long endTime = System.nanoTime() - startTime;
        return endTime;
    }

    public static long hashSetTime(Set<String> arrayList, String number) {
        long startTime = System.nanoTime();
        arrayList.contains(number);
        System.out.println("результат поиска HashSet-" + arrayList.contains(number));
        long endTime = System.nanoTime() - startTime;
        return endTime;
    }

    public static long treeSetTime(Set<String> arrayList, String number) {
        long startTime = System.nanoTime();
        arrayList.contains(number);
        System.out.println("результат поиска TreeSet-" + arrayList.contains(number));
        long endTime = System.nanoTime() - startTime;
        return endTime;
    }

}


