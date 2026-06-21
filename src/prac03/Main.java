package prac03;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Solution s = new Solution();

		// 1번 데이터 세트

		int[] periods1 = new int[] { 8, 23, 24 };

		int[][] payments1 = new int[][] {
				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 } };

		int[] estimates1 = new int[] { 100000, 100000, 100000 };

		// 2번 데이터 세트

		int[] periods2 = new int[] { 24, 59, 59, 60 };

		int[][] payments2 = new int[][] {
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 } };

		int[] estimates2 = new int[] { 350000, 50000, 40000, 50000 };

		System.out.println(Arrays.toString(s.solution(periods1, payments1, estimates1)));
		System.out.println(Arrays.toString(s.solution(periods2, payments2, estimates2)));
	}
}

class Solution {
	public int[] solution(int[] periods, int[][] payments, int[] estimates) {
		int[] answer = { 0, 0 };

		for (int i = 0; i < periods.length; i++) { // 회원 순회
			
			if (periods[i] < 23) continue; // VIP 일 수 없고, 한달 뒤 VIP가 될 수도 없음.
			
			int oldPay = payments[i][0]; // 곧 소멸할 payment
			int sum = 0;
			for (int j = 0; j < payments[i].length; j++) {sum += payments[i][j];}
			
			// before 갱신금액
			boolean beforeVip = isVip(periods[i], sum);
			// System.out.println("before_vip: " + beforeVip);
			
			sum -= oldPay;
			sum += estimates[i];
			
			// after 갱신금액
			boolean afterVip = isVip(periods[i]+1, sum);
			// System.out.println("after_vip: " + afterVip);
			
			if (!beforeVip && afterVip) { answer[0]++; }
			else if (beforeVip && !afterVip) { answer[1]++; }
			else continue;
		}

		return answer;
	}
	
	// vip는 true, 그 외 false
	public boolean isVip(int period, int payments) {
		if (period < 24) {
			return false;
		} else if (period < 60) {
			if (payments >= 900000) {
				return true;
			} else return false;
			
		} else {
			if (payments >= 600000) {
				return true;
			} else return false;
		}
	}
}