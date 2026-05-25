package ch04.sec02;

public class IfNestedExample {

	public static void main(String[] args) {
		int score = (int) (Math.random() * 20) + 81;
		System.out.println("점수: " + score);

		String grade;

		if (score >= 90) {
			if (score >= 95) { // score >= 95
				grade = "A+";
			} else { // score >= 90 && score < 95
				grade = "A";
			}
		} else {
			if (score >= 85) { // score < 90 && score >= 85
				grade = "B+";
			} else { // score < 85
				grade = "B";
			}
		}

		System.out.println("학점: " + grade);
	}

}
