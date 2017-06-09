class Student implements Comparable<Student> {
	private int number; // �й�
	private String name;
	private double score; // ���� (100.0 ����)

	public Student(int number, String name, Double score) {
		this.number = number;
		this.name = name;
		this.score = score;
	}

	public void print() {
		System.out.println(number + " " + name + " " + score);
	}

	// ���� ����Ʈ���� ���ϱ� ���ؼ� ������ �޼ҵ带 �ϼ�
	public int compareTo(Student other) {
		if (name.compareTo(other.name) > 0) {
			return 1;
		} else if (name.compareTo(other.name) == 0) {
			return 0;
		} else {
			return -1;
		}
	}
}

