import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		while (scan.hasNext()) {
			String[] line = scan.nextLine().split("");
			Stack stack =  new Stack();
			boolean flag = false;
			for (int i = 0; i < line.length; i++) {
				if (line[i].equals("{") || line[i].equals("[") || line[i].equals("(")) {
					stack.push(line[i]);
				}
				if (line[i].equals("}")) {
					String a;
					if(!stack.isEmpty()) {
						a = stack.pop();
						if (!a.equals("{")) {
						flag = true;
						break;
					}
					}					
					
				}
				if (line[i].equals("]")) {
					String a;
					if(!stack.isEmpty()) {
						a = stack.pop();
						if (!a.equals("[")) {
						flag = true;
						break;
					}
					}
					
				}
				if (line[i].equals(")")) {
					String a;
					if(!stack.isEmpty()) {
						a = stack.pop();
						if (!a.equals("(")) {
						flag = true;
						break;
					}
					}
					
				}

			}
			if(flag) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}


		}
	}
}

class Stack {
	String[] s;
	int size;
	Stack() {
		s = new String[50];
		size = 0;
	}
	public void push(String ele) {
		try {
			s[size] = ele;
			size++;
			//System.out.println(Arrays.toString(s));
		} catch (Exception e) {
			resize();
			s[size] = ele;
			size++;

		}

	}
	boolean isEmpty() {
		return size == 0;
	}
	public void resize() {
		s = Arrays.copyOf(s , size * 2);
	}
	public String pop() {
		String item =  s[size - 1];
		s[size - 1] = null;
		size--;
		return item;
	}
	public String toString() {
		String p = "";
		for (int i = 0; i < size; i++) {
			p += s[i] + " ";
		}
		return p;

	}

}