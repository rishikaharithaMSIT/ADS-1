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
     * main function.
     * Time Complexity : O(N)
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        int testcases = Integer.parseInt(scan.nextLine());
        while (testcases > 0) {
            switch (type) {
            case "Integer" :
                String[] stringArr = scan.nextLine().split(",");
                Integer[] elements = Arrays.asList(stringArr)
                                     .stream().map(Integer::valueOf)
                                     .toArray(Integer[]::new);
                MinHeap<Integer> minHeap = new MinHeap<>(elements);
                boolean isMinHeap = minHeap.isMinHeap();
                System.out.println(isMinHeap);
                //System.out.println(Arrays.toString(elements));
                break;
            case "String" :
                stringArr = scan.nextLine().split(",");
                MinHeap<String> minHeapString = new MinHeap<>(stringArr);
                isMinHeap = minHeapString.isMinHeap();
                System.out.println(isMinHeap);
                break;
            case "Float" :
                stringArr = scan.nextLine().split(",");
                if (stringArr[0].equals("")) {
                    System.out.println("false");
                    break;
                }
                Float[] elementsF = Arrays.asList(stringArr)
                                    .stream().map(Float::valueOf)
                                    .toArray(Float[]::new);
                MinHeap<Float> minHeapFloat = new MinHeap<>(elementsF);
                isMinHeap = minHeapFloat.isMinHeap();
                System.out.println(isMinHeap);
                break;
            case "Double" :
                stringArr = scan.nextLine().split(",");
                Double[] elementsD = Arrays.asList(stringArr)
                                     .stream().map(Double::valueOf)
                                     .toArray(Double[]::new);
                MinHeap<Double> minHeapDouble = new MinHeap<>(elementsD);
                isMinHeap = minHeapDouble.isMinHeap();
                System.out.println(isMinHeap);
                break;
            default:
            }
            testcases--;
        }

    }
}
/**
 * Class for minimum heap.
 *
 * @param      <Gen>  The generate
 */
class MinHeap<Gen extends Comparable<Gen>> {
    /**
     * Genric array type.
     */
    private Gen[] elements;
    /**
     * size of array.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      array  The array
     */
    MinHeap(final Gen[] array) {
        elements = (Gen[]) array;
        size = elements.length;
        //System.out.println(Arrays.toString(elements));
    }
    /**
     * Determines if minimum heap.
     * Time Complexity :
     * Worst : O(N)
     * Average : O(N)
     * Best : O(1)
     *
     * @return     True if minimum heap, False otherwise.
     */
    public boolean isMinHeap() {
        int flag = 1;
        if (size == 1) {
            return true;
        }
        for (int i = size - 1; i > 0; i--) {
            int halveVal = ((i + 1) / 2) - 1;
            if (elements[i].compareTo(elements[halveVal]) < 0) {
                flag = 0;
                break;
            }
        }
        if (flag == 0) {
            return false;
        }
        return true;
    }
}
