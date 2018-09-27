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
        int testcases = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split("");
            Stack stack =  new Stack();
            boolean flag = false;
            for (int i = 0; i < line.length; i++) {
                if (line[i].equals("{") || line[i].equals("[")
                        || line[i].equals("(")) {
                    stack.push(line[i]);
                }
                if (line[i].equals("}")) {
                    String a;
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if (!stack.isEmpty()) {
                        a = stack.pop();
                        if (!a.equals("{")) {
                            flag = true;
                            break;
                        }
                    }

                }
                if (line[i].equals("]")) {
                    String a;
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if (!stack.isEmpty()) {
                        a = stack.pop();
                        if (!a.equals("[")) {
                            flag = true;
                            break;
                        }
                    }

                }
                if (line[i].equals(")")) {
                    String a;
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if (!stack.isEmpty()) {
                        a = stack.pop();
                        if (!a.equals("(")) {
                            flag = true;
                            break;
                        }
                    }

                }

            }
            if (!flag && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


        }
    }
}

