import java.util.Scanner;
public class Solution {    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(pairStar(str));
    }
    static String pairStar(String str) {
        if(str.length() <= 1) {
            return str;
        }
        if(str.charAt(0) == str.charAt(1)) {
            return str.charAt(0) + "*" + Append(str.substring(1));
        }
        return str.charAt(0) + Append(str.substring(1));
    }
}
