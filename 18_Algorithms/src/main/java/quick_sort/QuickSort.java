package quick_sort;

public class QuickSort
{
    public static void sort(int[] array)
    {
        if(array.length <= 1) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int from, int to)
    {
        if(from < to)
        {
            int pivot = partition(array, from, to);
            sort(array, from, pivot - 1);
            sort(array, pivot + 1, to);
        }
    }

    private static int partition(int[] array, int from, int to) {

        int pivot = array[from];

        int begin = from - 1;
        int end = to + 1;

        while (begin < end) {

            for (begin++; array[begin] < pivot; begin++);
            {

                for (end--; array[end] > pivot; end--) ;
                {

                    if (begin < end) {
                        int temp = array[begin];
                        array[begin] = array[end];
                        array[end] = temp;
                    }
                }
            }
        }
        return end;
    }

}
