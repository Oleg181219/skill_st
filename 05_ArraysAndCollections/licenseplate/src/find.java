import java.util.*;

public class find {


    public static long sortBruteForceTime(ArrayList<String> arrayList, String number) {
        long startTime = System.currentTimeMillis();
        arrayList.contains(number);
        long endTime = System.currentTimeMillis() - startTime;
        return endTime;
    }
    public static long BinaryTime(ArrayList<String> arrayList, String number) {
        long startTime = System.currentTimeMillis();
        Collections.binarySearch(arrayList, number);
        long endTime = System.currentTimeMillis() - startTime;
        return endTime;
    }

    public static long hashSetTime(Set<String> arrayList, String number) {
        long startTime = System.currentTimeMillis();
        arrayList.contains(number);
        long endTime = System.currentTimeMillis() - startTime;
        return endTime;
    }

    public static long treeSetTime(Set<String> arrayList, String number) {
        long startTime = System.currentTimeMillis();
        arrayList.contains(number);
        long endTime = System.currentTimeMillis() - startTime;
        return endTime;
    }

}


