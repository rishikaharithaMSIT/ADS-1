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
	}
}
class BinarySearchST<Key extends Comparable<Key>, Value> {
	Key[] keys;
	Value[] values;
	int size;
	//Comparator<Key> comparator;
	BinarySearchST() {
		keys = (Key[])new Comparable[10];
		values = (Value[])new Comparable[10];
		size = 0;
	}
	public boolean contains(Key key) {
		for (int i = 0; i < size; i++) {
			if (((Comparable<Key>) keys[i]).compareTo(key) == 0) {
				return true;
			}
		}
		return false;
	}
	public int rank(Key key) {
		// for (int i = 0; i < size; i++) {
		// 	if (((Comparable<Key>) keys[i]).compareTo(key) == 0) {
		// 		return i;
		// 	}
		// }
		// return -1;
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int cmp = key.compareTo(keys[mid]);
			if      (cmp < 0) high = mid - 1;
			else if (cmp > 0) low = mid + 1;
			else return mid;
		}
		return low;
	}
	public void put(Key key, Value val) {
		int index = rank(key);
		if (contains(key)) {
			values[index] = val;
		} else {
			keys[index] = key;
			values[index] = val;
			size++;
		}
	}
	public Value get(Key key) {
		Value val = null;
		for (int i = 0; i < size; i++) {
			if (keys[i].compareTo(key) == 0) {
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