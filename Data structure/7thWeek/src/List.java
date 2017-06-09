interface List<T> {
	// ���� �ð��� ������ �������̽�
	public boolean isEmpty();
	public void insert(T item);
	public int size();
	public String toString();

	public void reset();
	public boolean hasNext();
	public T next();
}
