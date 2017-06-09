interface List<T> {
	// ���� �ð��� ������ �������̽�
	public boolean isEmpty();
	public void insert(T item);
	public boolean remove(T item);
	public boolean search(T item);
	public int size();
	public String toString();

	// Ž���ϱ� ���� �޼ҵ�.
	public void reset();
	public boolean hasNext();
	public T next();

	// ������ �������̽��� �����Ѵ�.
	public void insert(int num, T item); // item�� ����Ʈ�� num��° ���� ��忡 ����
	public void removeAll(T item);	// ����Ʈ�� �ִ� ��� item�� ���� 5�� ��� 5�� ����.
	public void append(T item);	// item�� ����Ʈ�� �� ���� ����.
	public T retrieve(int num);	// ����Ʈ�� num ��° ��带 ��ȯ
}
