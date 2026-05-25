package ch05.secf;

import java.util.Arrays;
import java.util.Scanner;

public class Ex9 {

	public static void main(String[] args) {

		int[] scores = null;

		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("-----------------------------------------------");
				System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
				System.out.println("-----------------------------------------------");

				System.out.print("선택> ");
				String s = sc.nextLine();
				if ("1".equals(s)) { // 점수
					System.out.print("학생수> ");
					int numOfStudents = Integer.parseInt(sc.nextLine());
					scores = new int[numOfStudents];

				} else if ("2".equals(s)) { // 점수입력
					System.out.println(scores.length + "명의 점수를 입력해주세요.");

					for (int i = 0; i < scores.length; i++) {
						System.out.print("scores[" + i + "]: ");
						scores[i] = Integer.parseInt(sc.nextLine());
					}

				} else if ("3".equals(s)) {
					System.out.println(Arrays.toString(scores));
					for (int i = 0; i < scores.length; i++) {
						System.out.println("scores[" + i + "]: " + scores[i]);
					}

				} else if ("4".equals(s)) {
					int sum = 0;
					int n = scores.length;
					int max = Integer.MIN_VALUE;

					for (int i = 0; i < n; i++) {
						max = Math.max(max, scores[i]);
						sum += scores[i];
					}

					double avg = (double) sum / n;

					System.out.println("최고 점수: " + max);
					System.out.println("평균 점수: " + avg);

				} else if ("5".equals(s)) {
					System.out.println("프로그램 종료.");
					sc.close();
					break;
				}

			} catch (Exception e) {
				System.out.println("Exception occurs!!!!!!");
			}

		}

	}

}
