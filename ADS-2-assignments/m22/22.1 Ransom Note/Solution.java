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
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        SeparateChainingHashST<String, Integer> st
            = new SeparateChainingHashST<String, Integer>();
        Scanner scan = new Scanner(System.in);
        String[] sizes = scan.nextLine().split(" ");
        String[] magzine = scan.nextLine().split(" ");
        String[] ransom = scan.nextLine().split(" ");

        for (int i = 0; i < ransom.length; i++) {
            String key = ransom[i];
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
            }

        }
        for (int i = 0; i < magzine.length; i++) {
            String key = magzine[i];
            if (st.contains(key)) {
                st.put(key, st.get(key) - 1);
            }

        }
        for (String s : st.keys()) {
            if (st.get(s) > 0) {
                System.out.println("No");
                return;
            }
            //System.out.println(s + " " + st.get(s));
        }
        System.out.println("Yes");

    }
}
