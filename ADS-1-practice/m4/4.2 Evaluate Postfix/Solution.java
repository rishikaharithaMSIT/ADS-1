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
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            Stack stack = new Stack();
            for (int i = 0; i < line.length; i++) {
                switch (line[i]) {
                case "*" :
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a * b);
                    break;
                case "-" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a - b);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a / b);
                    break;
                case "+" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                    break;
                default:
                    stack.push(Integer.parseInt(line[i]));
                }
            }
            stack.printList();
        }


    }

}

