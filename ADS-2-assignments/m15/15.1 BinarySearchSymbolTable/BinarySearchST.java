import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
class BinarySearchST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
	Key[] keys;
	Value[] values;
	int size;

	public Iterator<Key> iterator() {
		return Arrays.asList(keys).iterator();
	}
	BinarySearchST(int len) {
		keys = (Key[])new Comparable[len];
		values = (Value[])new Comparable[len];
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
			for (int i = 0; i < keyCopy.length && j < size; i++) {
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
		if (contains(key)) {
			return key;
		}
		if ((i - 1) < 0) {
			return null;
		}
		return keys[i - 1];
	}
	public Value get(Key key) {
		if (contains(key) == false) {
			return null;
		}
		int i = rank(key);
		Value val = values[i];
		return val;
	}
	public Key max() {
		return keys[size - 1];
	}
	public void deleteMin() {
		keys = Arrays.copyOfRange(keys, 1, size);
		values = Arrays.copyOfRange(values, 1, size);
		size--;
	}
	public void print() {
		
	}
	// 	for (int i = 0; i < size; i++) {
	// 		System.out.println(keys[i] + " " + values[i]);
	// 	}
	// }

}
class MyIterable<Key> implements Iterable<Key> {
	private List<Key> list;
	public MyIterable(Key[] k) {
		list = Arrays.asList(k);


	}

	public Iterator<Key> iterator() {
		return list.iterator();

	}

}
