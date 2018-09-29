import java.util.Scanner;
class AddLargeNumbers {
    
    public static LinkedList numberToDigits(String number) {
        LinkedList l = new LinkedList();
        String[] numbers = number.split("");
        for(int i =0;i<numbers.length;i++) {
            l.push(numbers[i]);
        }
        return l;
    }

    public static String digitsToNumber(LinkedList list) {
        return null;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        return new LinkedList();
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
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
    public void push(String element){
        Node newnode = new Node(element);
        if(isEmpty()) {
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
    public void printList() {
        Node tnode = first;       
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        
    }
}