
class ArrayQueue<T> implements Queue<T> {
	private T[] items;
	private int front;
	private int rear;
	private int size;
	private int maxSize;

	ArrayQueue() {
		this(3);
	}

	public ArrayQueue(int max) {
		items = (T[]) new Object[max];
		front = 0;
		rear = 0;
		size = 0;
		maxSize = max;
	}

	private void resize() {
		int len = items.length;
		assert size == len;
		Object[] newItems = new Object[2 * len];

		System.arraycopy(items, front, newItems, 0, len - front);
		System.arraycopy(items, 0, newItems, len - front, rear);

		items = (T[]) newItems;
		front = 0;
		rear = size;
		maxSize = 2 * len;
	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = (front + 1) % maxSize; i != (rear + 1) % maxSize; i = ++i % maxSize) {
			str.append(items[i] + " ");
		}
		return str.toString();
	}

	@Override
	public void enqueue(T item) {
		if (size == maxSize - 1) {
			resize();
		} 
		rear = (rear + 1) % maxSize;
		items[rear] = item;
		size++;
	}

	@Override
	public T dequeue() {
		front = (front + 1) % maxSize;
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return null;
		} else {
			size--;
			return items[front];
		}
	}

	@Override
	public T peek() {
		return items[front];
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}
}
