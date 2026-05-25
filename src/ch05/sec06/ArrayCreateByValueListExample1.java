package ch05.sec06;

public class ArrayCreateByValueListExample1 {

	public static void main(String[] args) {
		// type 1
//		String[] season = { "Spring", "Summer", "Fall", "Winter" };
		
		// type 2 정의 / 대입 분리
		String[] season;
		
		season = new String[]{"Spring", "Summer", "Fall", "Winter"};
		
		// type 3(null로 자리 채우기)
//		String[] season = new String[4];
//		
//		season[0] = "Spring";
//		season[1] = "Summer";
//		season[2] = "Fall";
//		season[3] = "Winter";
		
		
		
		System.out.println("season[0] : " + season[0]);
		System.out.println("season[1] : " + season[1]);
		System.out.println("season[2] : " + season[2]);
		System.out.println("season[3] : " + season[3]);
		
		season[1] = "여름";
		System.out.println("season[1] : " + season[1]);
		System.out.println();
		
		int[] scores = { 83, 90, 87 };
		
		int sum = 0;
		for (int i=0; i<3; i++) {
			sum += scores[i];
		}
		System.out.println("총합 : " + sum);
		double avg = (double) sum / 3;
		System.out.println("평균 : " + avg);

	}

}
