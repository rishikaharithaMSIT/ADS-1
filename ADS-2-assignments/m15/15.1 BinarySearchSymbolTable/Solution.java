// void put (Key k, Value v) inserts key and a value at appropriate position in the arrays.
// boolean contains(Key k) return true if the given key is in the symboltable.
// Value get(Key k) return value paired with Key.
// Key max() return largest key
// Key floor(Key key) return largest key less than or equal to key
// int rank(Key key) return number of keys less than key
// void deleteMin() delete smallest key
// Iterable<Key> keys() return all keys, in sorted order
import java.util.Scanner;
import java.util.Comparator;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchST<Integer, String> b = new BinarySearchST<>();
		b.put(2, "A");
		b.put(5, "B");
		b.put(5, "C");
		b.print();
		System.out.println(b.get(2));
	}
}
class BinarySearchST<Key, Value> {
	Key[] keys;
	Value[] values;
	int size;
	Comparator<Key> comparator;
	BinarySearchST() {
		keys = (Key[])new Object[10];
		values = (Value[])new Object[10];
		size = 0;
	}
	public int contains(Key key) {
		for (int i = 0; i < size; i++) {
			if (((Comparable<Key>) keys[i]).compareTo(key) == 0) {
				return i;
			}
		}
		return -1;
	}
	public void put(Key key, Value val) {
		if (contains(key) != -1) {
			int index = contains(key);
			values[index] = val;
		} else {
			keys[size] = key;
			values[size] = val;
			size++;
		}
	}
	public Value get(Key key) {
		Value val = null;
		for (int i = 0; i < size; i++) {
			if (((Comparable<Key>) keys[i]).compareTo(key) == 0) {
				val = values[i];
				break;
			}
		}

		return val;
	}
	public void print() {

		for (int i = 0; i < size; i++) {
			System.out.print(keys[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(values[i] + " ");
		}
	}

}