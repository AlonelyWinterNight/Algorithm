class Course implements Comparable<Course> {
	private String name;
	private int credit; // 학점
	private char grade; // 과목 성적

	public Course(String name, int credit, char grade) { // 생성자
		this.name = name;
		this.credit = credit;
		this.grade = grade;
	}

	public void print() {
		System.out.println(name + " " + credit + " " + grade);
	}

	// 연결 리스트에서 비교하기 위해서 다음의 메소드를 완성
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

