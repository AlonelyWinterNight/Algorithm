class Student implements Comparable<Student> {
	private int number; // �й��� �����ϴ� �ν��Ͻ� ����
	private String name; // �л� �̸��� �����ϴ� �ν��Ͻ� ����
	private SortedLinkedList<Course> courseList; // �����ϴ� ������ ���� ����Ʈ�� ����

	public Student(int number, String name, SortedLinkedList<Course> courseList) {
		this.number = number;
		this.name = name;
		this.courseList = courseList;// ������
	}

	// �л��� �����ϴ� ������ �� ���� ���� ��ȯ�ϴ� �޼ҵ�
	public int getTotalCredits() {
		courseList.reset();
		int sum = 0;
		while (courseList.hasNext()) {
			sum += courseList.next().getCredit();
		}
		return sum;
	}

	public int compareTo(Student other) {
		if (number >= other.number) {
			return 0;
		} else
			return -1;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(number);
		s.append(String.format("%20s", name));
		s.append(String.format("%20s", "total credits: "));
		s.append(getTotalCredits());
		s.append("\n");
		s.append(courseList.toString()+"\n");
		return s.toString();
	}
}
