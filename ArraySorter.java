import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 
 */
public class ArraySorter {

    // **** ****
    static int count = 0;

    /**
     * Recursive call
     * 
     * Time complexity:
     * Best: (n log(n))	 Average: Θ(n log(n))  Worst: O(n^2)
     * 
     * Space complexity:
     * O(log(n))
     */
    private static <E> void quicksort(E[] array, int start, int end, Comparator<E> comparator) {

        // ???? ????
        // System.out.println("quicksort <<< start: " + start + " end: " + end);

        // **** end condition ****
        if (end - start <= 0)
            return;

        // **** choose a random pivot (optimization technique) ****
        // int pivotIndex = (int)((end - start) * Math.random()) + start;
        // swap(array, pivotIndex, end - 1);

        // **** initialization ****
        int i = start;
        int j = end - 1;
        boolean movingI = true;

        // **** sort ****
        while (i < j) {

            // **** count this operation  ****
            count++;

            // **** ****
            if (comparator.compare(array[i], array[j]) > 0) {
                swap(array, i, j);
                movingI = !movingI;
            } else {
                if (movingI) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        // **** recursion ****
        quicksort(array, start, i, comparator);
        quicksort(array, i + 1, end, comparator);
    }

    /**
     * Entry point for recursive call.
     */
    private static <E> void quicksort(E[] array, Comparator<E> comparator) {

        // **** reset counter ****
        count = 0;

        // **** recursive call ****
        quicksort(array, 0, array.length, comparator);

        // **** display counter ****
        System.out.println("quicksort <<< count: " + count);
    }

    /**
     * Utility function.
     * Swaps two entries in the array.
     */
    public static <E> void swap(E[] array, int i, int j) {
        if (i == j)
            return;
        E temp      = array[i];
        array[i]    = array[j];
        array[j]    = temp;
    }

    /**
     * Test scafolding
     */
    public static void main(String[] args) {
        
        // **** array to sort ****
        Integer[] arr = new Integer[] {10, 5, 2, 3, 78, 53, 3, 1, 1, 24, 
                                        1, 35, 35, 2, 67, 4, 33, 30, 13};

        // ???? array info ????
        System.out.println("main <<< arr.length: " + arr.length);
        System.out.println("main <<<        arr: " + Arrays.toString(arr));


        // ???? sort array (swap a and b to change order) ????
        // Arrays.sort(arr, (a,b) -> b - a );
        // System.out.println("main <<<        arr: " + Arrays.toString(arr));

        // ???? shuffle array ????
        // List<Integer> lst = Arrays.asList(arr);
        // Collections.shuffle(lst);
        // arr  = lst.toArray(new Integer[lst.size()]);
        // System.out.println("main <<<        arr: " + Arrays.toString(arr));


        // **** sort array ****
        quicksort(arr, (a,b) -> a - b);

        // **** display sorted array ****
        System.out.println("main <<<        arr: " + Arrays.toString(arr));
    }

}