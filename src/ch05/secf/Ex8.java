package ch05.secf;

public class Ex8 {

	public static void main(String[] args) {
		int sum = 0;
		int n = 0;
		
		int[][] array = {{95,86}, {83,92,96}, {78,83,93,87,88}};
		
		for (int i=0; i<array.length; i++) {
			n += array[i].length;
			for (int j=0; j<array[i].length; j++) {
				sum += array[i][j];
			}
		}
		
		double avg = (double) sum / n;
		
		System.out.println("sum: " + sum);
		System.out.println("avg: " + avg);

	}

}
