class Course implements Comparable<Course> {
	private String name; // 과목명을 저장하는 인스턴스 변수
	private int credit; // 학점 수를 저장하는 인스턴스 변수
	private char grade; // 학점을 저장하는 인스턴스 변수

	public Course(String name, int credit, char grade) {
		this.name = name;
		this.credit = credit;
		this.grade = grade;
	}

	public Course() {
		name = null;
		credit = 0;
		grade = '\n';
	}

	public String getName() {
		return name;
	}

	public int getCredit() {
		return credit;
	}

	public char getGrade() {
		return grade;
	}

	public int compareTo(Course other) {
		if (name.compareTo(other.name) >= 0) {
			return 0;
		} else
			return -1;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("\t");
		s.append(String.format("%-20s", name));
		s.append(String.format("%8d", credit));
		s.append(String.format("%7s", grade));
		return s.toString();
	}
}
