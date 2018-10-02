import java.util.Scanner;
import java.util.ArrayList;
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
     * Array list containing the cricket objects.
     */
    private static ArrayList<Cricket> cricketList
        = new ArrayList<Cricket>();
    /**
     * main function to read input.
     * Time Complexity : O(N) (while loop).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        final int three = 3;
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            Cricket cricket = new Cricket(tokens[0],
                                          Integer.parseInt(tokens[1]),
                                          Integer.parseInt(tokens[2]),
                                          Integer.parseInt(tokens[three]));
            cricketList.add(cricket);
        }

        insertionSort();

        //print ArrayList
        for (int i = 0; i < cricketList.size() - 1; i++) {
            System.out.print(cricketList.get(i).name + ",");
        }
        System.out.print(cricketList.get(
                             cricketList.size() - 1).name);
        System.out.println();



    }
    /**
     * method to perform insertion sort
     * Time Complexities .
     * Best - O(N)
     * Worst - O(N)
     * Average - O(N)
     *
     */
    public static void insertionSort() {
        for (int i = cricketList.size() - 1; i >= 0 ; i--) {
            Cricket elem = cricketList.get(i);
            for (int j = i + 1; j <= cricketList.size() - 1; j++) {
                if (elem.compareTo(cricketList.get(j)) == -1) {
                    Cricket temp = cricketList.get(j);
                    cricketList.set(j, elem);
                    cricketList.set(j - 1, temp);
                }
            }

        }

    }

}
