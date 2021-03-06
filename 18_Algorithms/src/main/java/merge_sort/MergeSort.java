package merge_sort;

public class MergeSort {
    public static void mergeSort(int[] array) {
        int n = array.length;
        if (n < 2) {
            return;
        }
        int middle = n / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[n - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        for (int i = middle; i < n; i++) {
            rightArray[i - middle] = array[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (rightArrayIndex >= right.length || (leftArrayIndex < left.length && left[leftArrayIndex] <= right[rightArrayIndex])) {
                array[i] = left[leftArrayIndex];
                leftArrayIndex++;
            } else {
                array[i] = right[rightArrayIndex];
                rightArrayIndex++;
            }
        }
    }
}
