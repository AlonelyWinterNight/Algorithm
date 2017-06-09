class Course implements Comparable<Course> {
	private String name;
	private int credit; // ����
	private char grade; // ���� ����

	public Course(String name, int credit, char grade) { // ������
		this.name = name;
		this.credit = credit;
		this.grade = grade;
	}

	public void print() {
		System.out.println(name + " " + credit + " " + grade);
	}

	// ���� ����Ʈ���� ���ϱ� ���ؼ� ������ �޼ҵ带 �ϼ�
	public int compareTo(Course other) {
		if (name.compareTo(other.name) > 0) {
			return 1;
		} else if (name.compareTo(other.name) == 0) {
			return 0;
		} else {
			return -1;
		}
	}
}

