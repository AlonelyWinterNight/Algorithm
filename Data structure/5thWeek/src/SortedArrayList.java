import java.util.NoSuchElementException;

class SortedArrayList<T extends Comparable<T>> {
	private T[] items;
	private int size = 0;
	private int maxSize = 5;

	public SortedArrayList() {
		items = (T[]) new Comparable[maxSize];
	}

	public SortedArrayList(int max) {
		items = (T[]) new Comparable[max];
		maxSize = max;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == maxSize;
	}

	public int size() {
		return size;
	}

	public void resize() {
		T[] newItems = (T[]) new Comparable[2 * items.length];
		for (int i = 0; i < items.length; i++) {
			newItems[i] = items[i];
		}
		items = newItems;
		maxSize = 2 * size;
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}

	public void println() { // Course, Student등을 위함.
		for (int i = 0; i < size; i++) {
			if (items[i].getClass().getName().equals(Course.class.getName())) {
				Course newItem = (Course) items[i];
				newItem.print();
			} else {
				Student newItem = (Student) items[i];
				newItem.print();
			}
		}
	}

	public void insert(T data) {
		if (isFull()) {
			resize();
		}
		int i, j;
		for (i = 0; i < size; i++) {
			if (items[i].compareTo(data) >= 0) {
				break;
			}
		}
		for (j = size - 1; j >= i; j--) {
			items[j + 1] = items[j];
		}
		items[i] = data;
		size++;
	}

	public boolean remove(T data) {
		if (isEmpty()) {
			throw new NoSuchElementException("remove(): list empty");
		} else {
			for (int i = 0; i < size; i++) {
				if (items[i].compareTo(data) == 0) {
					items[i] = items[size - 1];
					--size;
					return true;
				}
			}
		}
		return false;
	}

	public boolean search(T data) {
		if (isEmpty()) {
			throw new NoSuchElementException("search():list empty");
		} else {
			for (int i = 0; i < size; i++) {
				if (items[i].compareTo(data) == 0) {
					return true;
				}
			}
		}
		return false;
	}
}
