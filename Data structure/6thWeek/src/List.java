interface List<T> {
	// 수업 시간에 구현한 인터페이스
	public boolean isEmpty();
	public void insert(T item);
	public boolean remove(T item);
	public boolean search(T item);
	public int size();
	public String toString();

	// 탐색하기 위한 메소드.
	public void reset();
	public boolean hasNext();
	public T next();

	// 다음의 인터페이스를 구현한다.
	public void insert(int num, T item); // item을 리스트의 num번째 앞의 노드에 삽입
	public void removeAll(T item);	// 리스트에 있는 모든 item을 삭제 5면 모든 5를 삭제.
	public void append(T item);	// item을 리스트의 맨 끝에 삽입.
	public T retrieve(int num);	// 리스트의 num 번째 노드를 반환
}
