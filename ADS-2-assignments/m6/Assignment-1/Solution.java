import java.util.Scanner;
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * { function_description }.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(String number) {
        LinkedList l = new LinkedList();
        String[] numbers = number.split("");
        for (int i = 0; i < numbers.length; i++) {
            l.push(numbers[i]);
        }
        //l.printList();
        return l;
    }
    /**
     * { function_description }.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(LinkedList list) {
        String number = "";
        //list.printList();
        while (!list.isEmpty()) {
            number += list.pop();
        }
        return number;
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        if (list2.size > list1.size) {
            int diff = list2.size - list1.size;
            while (diff > 0) {
                s1.push(0);
                diff--;
            }
        }

        while (!list1.isEmpty()) {
            String number = list1.pop();
            s1.push(Integer.parseInt(number));
        }
        while (!list2.isEmpty()) {
            String number = list2.pop();
            s2.push(Integer.parseInt(number));
        }

        String sum = "";
        int carry = 0;
        int s = 0;
        while (!s1.isEmpty()) {
            s = s1.pop() + s2.pop() + carry;
            carry = s / 10;
            if (s1.size == 0) {
                //System.out.print(s%10);
                sum += (s % 10) + "";
                if (s / 10 != 0) {
                    //System.out.print(s/10);
                    sum += (s / 10) + "";
                }
            } else {
                sum += (s % 10) + "";
                //System.out.print(s % 10);
            }

        }

        String ans = "";
        for (int i = sum.length() - 1; i >= 0; i--) {
            ans += sum.charAt(i);
        }

        LinkedList result = numberToDigits(ans);
        return result;
    }
}
/**
 * { item_description }.
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        }
    }
}

