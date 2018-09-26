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
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(scan.nextLine());
        }
        Arrays.sort(array);
        //System.out.println(Arrays.toString(array));
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                int sum = array[i] + array[j];
                int abc  = 0 - sum;
                int isFound = binarySearch(array,
                                           j + 1, size - 1, abc);
                //System.out.println(sum+" - "+ abc);
                //System.out.println(j);
                if (isFound != -1) {
                    // System.out.println(count + " co");
                    count++;
                }
            }
        }
        // System.out.println("hai");
        System.out.println(count);

    }

    /**
     * @param      arr  The arguments
     * @param      l  The arguments
     * @param      r  The arguments
     * @param      x  The arguments
     * @return     int
     */
    public static int binarySearch(final int[] arr, final int l,
                                   final int r, final int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }


}