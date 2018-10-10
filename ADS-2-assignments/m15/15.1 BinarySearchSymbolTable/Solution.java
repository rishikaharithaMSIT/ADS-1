import java.util.Scanner;
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
        String s = scan.nextLine();
        String[] str = s.split(" ");
        BinarySearchST<String, Integer> b
            = new BinarySearchST<>(str.length);
        for (int i = 0; i < str.length; i++) {
            b.put(str[i], i);
        }
        while (scan.hasNext()) {
            String[] inp = scan.nextLine().split(" ");
            switch (inp[0]) {
            case "max":
                System.out.println(b.max());
                break;
            case "floor":
                System.out.println(b.floor(inp[1]));
                break;
            case "rank":
                System.out.println(b.rank(inp[1]));
                break;
            case "deleteMin":
                b.deleteMin();
                break;
            case "contains":
                System.out.println(b.contains(inp[1]));
                break;
            case "keys":
                //b.print();
                MyIterable<String> myList = new MyIterable<>(b.keys);
                for (String i : myList) {
                    System.out.println(i);

                }
                break;
            case "get":
                System.out.println(b.get(inp[1]));
                break;
            default:
            }
        }

        // System.out.println(b.max());
        // System.out.println(b.floor("R"));
        // System.out.println(b.rank("B"));
        // b.deleteMin();
        // System.out.println(b.contains("C"));
        // b.print();
        // System.out.println(b.get("A"));

    }
}
