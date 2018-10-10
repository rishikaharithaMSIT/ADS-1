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
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchST<String, Integer> b = new BinarySearchST<>();
		String s = "S E A R C H E X A M P L E";
		String[] str = s.split(" ");
		for(int i =0;i<str.length;i++){
			b.put(str[i],i);
		}
		System.out.println(b.max());
		System.out.println(b.floor("R"));
		System.out.println(b.rank("B"));
		b.deleteMin();
		b.print();
		System.out.println(b.contains("C"));
		System.out.println(b.get("A"));
		
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
	public void exchange(int i, int j) {
		Key tempKey = keys[i];
		Value tempVal = values[i];
		keys[i] = keys[j];
		keys[j] = tempKey;
		values[i] = values[j];
		values[j] = tempVal;
	}
	public void put(Key key, Value val) {
		int index = rank(key);
		//System.out.println("index" + index);
		if (contains(key)) {
			values[index] = val;
		} else {
			Key[] keyCopy = Arrays.copyOfRange(keys, index, size);
			Value[] valCopy = Arrays.copyOfRange(values, index, size);
			keys[index] = key;
			values[index] = val;
			size++;
			int j = index + 1;
			for (int i = 0; i < keyCopy.length; i++) {
				keys[j] = keyCopy[i];
				values[j] = valCopy[i];
				j++;
			}
			// System.out.println(index + " - " + (size-1));
			// System.out.println(keys[index] + " : " + keys[size-1]);
			//exchange(index, size-1);
		}

	}
	public Key floor(Key key) {
		int i = rank(key);
		if(contains(key)) {
			return key;
		}
		return keys[i-1];
	}
	public Value get(Key key) {
		if(!contains(key)) {
			return null;
		}
		int i = rank(key);
		Value val = values[i];
		return val;
	}
	public Key max() {
		return keys[size-1];
	}
	public void deleteMin() {
		keys = Arrays.copyOfRange(keys, 1, size);
		values = Arrays.copyOfRange(values, 1, size);
		size--;
	}
	public void print() {

		for (int i = 0; i < size; i++) {
			System.out.println(keys[i] + " " + values[i]);
		}
	}

}