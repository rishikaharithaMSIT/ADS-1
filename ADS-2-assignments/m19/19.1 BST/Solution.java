import java.util.Scanner;

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { Main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree<Key, Integer> bstobj
            = new BinarySearchTree<>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                Key newkey = new Key(tokens[1], tokens[2],
                                     Float.parseFloat(
                                         tokens[2 + 1]));
                bstobj.put(newkey, Integer.parseInt(
                               tokens[2 + 2]));
                break;
            case "get":
                newkey = new Key(tokens[1], tokens[2],
                                 Float.parseFloat(
                                     tokens[2 + 1]));
                System.out.println(bstobj.get(newkey));
                break;
            case "min":
                System.out.println(bstobj.min());
                break;
            case "max":
                System.out.println(bstobj.max());
                break;
            case "floor":
                newkey = new Key(tokens[1], tokens[2],
                                 Float.parseFloat(
                                     tokens[2 + 1]));
                System.out.println(bstobj.floor(newkey));
                break;
            case "ceiling":
                newkey = new Key(tokens[1], tokens[2],
                                 Float.parseFloat(
                                     tokens[2 + 1]));
                System.out.println(bstobj.ceiling(newkey));
                break;
            case "select":
                System.out.println(bstobj.select(
                                       Integer.parseInt(
                                           tokens[1])));
                break;
            default:
            }
        }
    }
}
