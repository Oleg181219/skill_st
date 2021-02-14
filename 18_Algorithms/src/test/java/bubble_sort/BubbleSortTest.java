package bubble_sort;
import abstract_class.AbstractSortArrayClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest  extends AbstractSortArrayClass {
    @Override
    public void sortArray(int[] array) {
        int[] test = new int[]{9, 5, 7, 6, 11, 8, 12, 10};
        BubbleSort.sort(test);
    }

//    @Test
//    @DisplayName("BubbleSort")
//    public static void testBubbleSort(int[] array) {
//        int[] test = new int[]{9, 5, 7, 6, 11, 8, 12, 10};
//        int[] original = new int[]{5, 6, 7, 8, 9, 10, 11, 12};
//        BubbleSort.sort(test);
//        assertArrayEquals(original, test);
//    }
}

