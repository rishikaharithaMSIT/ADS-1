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
        Deque<Integer> q = new Deque<>();
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            switch (line[0]) {
            case "pushLeft":
                q.pushLeft(Integer.parseInt(line[1]));
                //q.printList();
                break;
            case "pushRight":
                q.pushRight(Integer.parseInt(line[1]));
                //q.printList();
                break;
            case "popRight":
                q.popRight();
                //q.printList();
                break;
            case "popLeft":
                q.popLeft();
                //q.printList();
                break;
            case "size":
                System.out.println(q.getSize());
                break;
            default :
            }
        }

    }
}

