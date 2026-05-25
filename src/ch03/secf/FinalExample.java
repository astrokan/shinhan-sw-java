package ch03.secf;

public class FinalExample {

	public static void main(String[] args) {
		int pencils = 534;
		int students = 30;
		
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);
		
		int pencilsLeft = pencils % students;
		
		System.out.println(pencilsLeft);
		
		int value = 356;
		System.out.println(value / 100 * 100);

	}

}
