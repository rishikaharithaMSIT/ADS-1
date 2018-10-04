import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int ans = factorial(num);
		System.out.println("Factorial : " + ans);
	}
	static int fact(int num) {
		if (num == 1) {
			return 1;
		} else {
			return num * fact(num - 1);
		}
	}
}
