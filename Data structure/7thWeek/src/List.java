interface List<T> {
	// 수업 시간에 구현한 인터페이스
	public boolean isEmpty();
	public void insert(T item);
	public int size();
	public String toString();

	public void reset();
	public boolean hasNext();
	public T next();
}
