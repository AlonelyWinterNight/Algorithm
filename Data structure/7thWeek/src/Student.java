class Student implements Comparable<Student> {
	private int number; // 학번을 저장하는 인스턴스 변수
	private String name; // 학생 이름을 저장하는 인스턴스 변수
	private SortedLinkedList<Course> courseList; // 수강하는 과목을 정렬 리스트에 저장

	public Student(int number, String name, SortedLinkedList<Course> courseList) {
		this.number = number;
		this.name = name;
		this.courseList = courseList;// 생성자
	}

	// 학생이 수강하는 과목의 총 학점 수를 반환하는 메소드
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
