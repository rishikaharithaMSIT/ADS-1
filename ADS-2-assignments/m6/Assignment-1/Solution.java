import java.util.Scanner;
class AddLargeNumbers {

    public static LinkedList numberToDigits(String number) {
        LinkedList l = new LinkedList();
        String[] numbers = number.split("");
        for (int i = 0; i < numbers.length; i++) {
            l.push(numbers[i]);
        }
        //l.printList();
        return l;
    }

    public static String digitsToNumber(LinkedList list) {
        String number = "";
        //list.printList();
        while (!list.isEmpty()) {
            number += list.pop();
        }
        return number;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        System.out.println(list1.size + " " + list2.size + " size");
        if(list2.size > list1.size) {
            int diff = list2.size-list1.size;
            while(diff > 0) {
                list1.push("0");
                diff--;
            }
        }
        list1.printList();
        
        list2.printList();
        
        System.out.println(list1.size + " " + list2.size + " size atferrrrrrrrr");
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
            if(s1.size == 0) {
                System.out.print(s%10);
                System.out.print(s/10);
            }
            else {
                System.out.print(s % 10);
            }
            
        }
        //System.out.print(s);
        return new LinkedList();
    }
}

public class Solution {
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
class LinkedList {
    Node first = null;
    Node last = null;
    int size = 0;
    class Node {
        String data;
        Node next;
        Node(String data) {
            this.data = data;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void push(String element) {
        Node newnode = new Node(element);
        if (isEmpty()) {
            first = newnode;
            last = first;
            last.next = null;
            size++;
            return;
        }
        Node oldlast = last;
        last = newnode;
        oldlast.next = last;
        last.next = null;
        size++;

    }
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String item = first.data;
        first = first.next;
        size--;
        return item;

    }
    public void printList() {
        Node tnode = first;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();

    }
}
class Stack {
    Node first = null;
    int size = 0;
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void push(int ele) {
        Node newnode = new Node(ele);
        newnode.next = first;
        first = newnode;
        size++;
    }

    public int pop() {
        int item = first.data;
        first = first.next;
        size--;
        return item;
        
    }
    public void printList() {
        Node tnode = first;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }
}