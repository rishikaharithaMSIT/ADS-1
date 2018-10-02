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
     * Array list containing the cricket objects
     */
    private static ArrayList<Cricket> cricketList
        = new ArrayList<Cricket>();
    /**
     * main function to read input
     * Time Complexity : O(N) (while loop)
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            Cricket cricket = new Cricket(tokens[0],
                                          Integer.parseInt(tokens[1]),
                                          Integer.parseInt(tokens[2]),
                                          Integer.parseInt(tokens[3]));
            cricketList.add(cricket);
        }

        selectionSort();

        //print ArrayList
        for (int i = 0; i < cricketList.size() - 1; i++) {
            System.out.print(cricketList.get(i).name + ",");
        }
        System.out.print(cricketList.get(
                             cricketList.size() - 1).name);
        System.out.println();



    }
    /**
     * method to perform selection sort
     * Time Complexities .
     * Best - O(N)
     * Worst - O(N)
     * Average - O(N)
     *
     */
    public static void selectionSort() {

        for (int i = cricketList.size() - 1; i >= 0 ; i--) {
            Cricket max = cricketList.get(i);
            int index = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (max.compareTo(cricketList.get(j)) == 1) {
                    max = cricketList.get(j);
                    index = j;
                }
            }
            Cricket temp = cricketList.get(i);
            cricketList.set(i, max);
            if (index != -1) cricketList.set(index, temp);
        }

    }

}
