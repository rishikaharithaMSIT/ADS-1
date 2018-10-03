import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main function to take in input.
     * Time complexity : O(N).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] list = scan.nextLine().split(",");
            int low  = 0;
            int high = list.length - 1;
            list  = sort(list, low, high);
            System.out.println(Arrays.toString(list));
            System.out.println();
        }


    }
    /**
     * function to sort the array
     * Time Complexity:
     * Best : O(NlogN)
     * Worst : O(NlogN)
     * Average : O(NlogN)
     *
     * @param      list  The list
     * @param      low   The low
     * @param      high  The high
     *
     * @return     { description_of_the_return_value }
     */
    public static String[] sort(final String[] list,
                                final int low, final  int high) {
        //List aux = list.subList(low, high+1);
        String[] aux = Arrays.copyOfRange(list, low, high + 1);
        final int eight = 8;
        if (aux.length <= eight) {
            System.out.println("Insertion sort method invoked...");
            return insertionSort(aux);
        }


        if (low + 1 >= high) {
            if (aux.length == 2) {
                if (aux[0].compareTo(aux[1]) > 0) {
                    String temp = aux[0];
                    aux[0] = aux[1];
                    aux[1] = temp;
                }
            }
            System.out.println(Arrays.toString(aux));
            return aux;
        }
        int mid = (low + high) / 2;

        String[] a1 = sort(list, low, mid);
        //System.out.println("sort1 " +  Arrays.toString(a1)
        // + " " + low + " " + mid);
        String[] a2 = sort(list, mid + 1, high);
        //System.out.println("sort2 " +  Arrays.toString(a2)
        // + " " + (mid + 1) + " " + high);
        String[] a3 = merge(a1, a2);
        //System.out.println("merge " +  Arrays.toString(a3));
        return a3;

    }
    /**
     * to merge two sorted arrays.
     * Time Complexity:
     * Best : O(N)
     * Worst : O(N)
     * Average : O(N)
     *
     * @param      arr1  The arr 1
     * @param      arr2  The arr 2
     *
     * @return     string array
     */
    public static String[] merge(final String[] arr1,
                                 final String[] arr2) {
        //System.out.println("in merge function - " +
        //Arrays.toString(a1)
        // + " - "+ Arrays.toString(a2));
        int t = arr1.length + arr2.length;
        int n1 = arr1.length;
        int n2 = arr2.length;
        String[] arr3 = new String[t];
        int i = 0, j = 0, k = 0;

        if (arr1[n1 - 1].compareTo(arr2[0]) < 0
                || arr1[n1 - 1].compareTo(arr2[0]) == 0) {
            String[] list =  new String[t];
            System.out.print("Array is already sorted. ");
            System.out.print("So, skipped the call to merge...");
            System.out.println();
            int count = 0;

            for (int p = 0; p < arr1.length; p++) {
                list[p] = arr1[p];
                count++;
            }
            for (int l = 0; l < arr2.length; l++) {
                list[count++] = arr2[l];
            }
            return list;
        }

        // Traverse both array
        while (i < n1 && j < n2) {
            if (arr1[i].compareTo(arr2[j]) < 0) {

                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            arr3[k++] = arr1[i++];
        }
        while (j < n2) {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }
    /**
     * Determines if sorted.
     * Time Complexity:
     * Best : O(N)
     * Worst : O(N)
     * Average : O(N)
     *
     * @param      array  The array
     *
     * @return     True if sorted, False otherwise.
     */
    public static boolean isSorted(final String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * insertion sort.
     * Time Complexity:
     * Best : O(N)
     * Worst : O(N^2)
     * Average : O(N^2)
     *
     * @param      arr   The arr
     *
     * @return     { description_of_the_return_value }
     */
    public static String[] insertionSort(final String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0 && (arr[j].compareTo(key)) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}

