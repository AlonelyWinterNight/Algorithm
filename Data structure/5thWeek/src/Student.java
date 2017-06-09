class Student implements Comparable<Student> {
	private int number; // 학번
	private String name;
	private double score; // 점수 (100.0 만점)

	public Student(int number, String name, Double score) {
		this.number = number;
		this.name = name;
		this.score = score;
	}

	public void print() {
		System.out.println(number + " " + name + " " + score);
	}

	// 연결 리스트에서 비교하기 위해서 다음의 메소드를 완성
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

