import java.util.Scanner;

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        final int five = 5;
        final int six = 6;
        int n = Integer.parseInt(scan.nextLine());
        BinarySearchST<String, Integer> maxs = new BinarySearchST<>();
        BinarySearchST<String, Integer> mins = new BinarySearchST<>();
        String[] line;
        int hours = six;
        while (hours > 0) {
            int k = n;
            MinPQ<Stock> onemin = new MinPQ<Stock>();
            MaxPQ<Stock> onemax = new MaxPQ<Stock>();
            while (k > 0) {
                line = scan.nextLine().split(",");
                onemin.insert(new Stock(line[0], line[1]));
                onemax.insert(new Stock(line[0], line[1]));
                k--;
            }
            int top = five;
            while (top > 0) {
                Stock s = onemax.delMax();
                if (maxs.contains(s.getName())) {
                    maxs.put(s.getName(), maxs.get(s.getName()) + 1);
                } else {
                    maxs.put(s.getName(), 1);
                }
                System.out.println(s.getName() + " " + s.getVal());
                top--;
            }
            System.out.println();
            int low = five;
            while (low > 0) {
                Stock s = onemin.delMin();
                if (mins.contains(s.getName())) {
                    mins.put(s.getName(), mins.get(s.getName()) + 1);
                } else {
                    mins.put(s.getName(), 1);
                }
                System.out.println(s.getName() + " " + s.getVal());
                low--;
            }
            System.out.println();
            hours--;

        }
        int comms = Integer.parseInt(scan.nextLine());
        while (comms > 0) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "get" :
                if (tokens[1].equals("maxST")) {
                    if (maxs.contains(tokens[2])) {
                        System.out.println(
                            maxs.get(tokens[2]));
                    } else {
                        System.out.println("0");
                    }

                } else {
                    if (mins.contains(tokens[2])) {
                        System.out.println(
                            mins.get(tokens[2]));
                    } else {
                        System.out.println("0");
                    }
                }

                break;
            case "intersection" :
                int size1 = maxs.size();
                int size2 = mins.size();
                if (size2 > size1) {
                    for (String each : mins.keys()) {
                        if (maxs.contains(each)) {
                            System.out.println(each);
                        }
                    }
                } else {
                    for (String each : maxs.keys()) {
                        if (mins.contains(each)) {
                            System.out.println(each);
                        }
                    }
                }
                break;
            default :

            }
            // for (String word : maxs.keys()) {
            //  System.out.println(word + " - " + maxs.get(word));
            // }
            comms--;
        }
        // String max = "";
        // maxs.put(max, 0);
        // for (String word : maxs.keys()) {
        //  if (st.get(word) > st.get(max))
        //      max = word;
        // }
        // System.out.println(max + "max");

    }
}
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
    /**
     * name.
     */
    private String name;
    /**
     * values.
     */
    private double val;
    /**
     * Constructs the object.
     *
     * @param      name1  The name 1
     * @param      val1   The value 1
     */
    Stock(final String name1, final String val1) {
        this.name = name1;
        this.val = Double.parseDouble(val1);
    }
    /**
     * compares stock values.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Stock that) {
        if (this.val < that.val) {
            return -1;
        }
        if (this.val > that.val) {
            return 1;
        }
        if (this.name.compareTo(that.name) > 0) {
            return 1;
        }
        if (this.name.compareTo(that.name) < 0) {
            return -1;
        }

        return 0;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the value.
     *
     * @return     The value.
     */
    public double getVal() {
        return val;
    }
}
