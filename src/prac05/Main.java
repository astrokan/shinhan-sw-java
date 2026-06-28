package prac05;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		// case 1
		int n1 = 4;
		int[] amounts1 = { 1000000, 490000, 700000, 290000 };
		
		// case 2
		int n2 = 6;
		int[] amounts2 = { 30000, 70000, 10000 };

		System.out.println(Arrays.toString(s.solution(n1, amounts1)));
		System.out.println(Arrays.toString(s.solution(n2, amounts2)));
	}
}

class Solution{
	public int[] solution(int n, int[] amounts) {
		
		// answer: 물건 낙찰 가격 배열
		int[] answer = new int[n];
		
		// arr: {남은 자본 , 참가자 번호}를 저장한 2차원 배열
		int[][] arr = new int[amounts.length][2];
		for (int i=0; i<amounts.length; i++) {
			arr[i][0] = amounts[i];
			arr[i][1] = i;
		}
		
		// 물건 개수 n만큼 순회
		for (int i=0; i<n; i++) {
			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] == o2[0]) return o1[1] - o2[1]; // 참가자 번호 오름차순
					return o2[0] - o1[0]; // 자본 내림차순
				}
			});
			
			int firstMoney = arr[0][0];
			int secondMoney = arr[1][0];
			
			if (firstMoney == secondMoney) { // 최대 자본 보유자가 2명 이상일 경우
				arr[0][0] = 0;
				answer[i] = firstMoney;
			} else {
				arr[0][0] -= secondMoney + 10000;
				answer[i] = secondMoney + 10000;
			}
			
		}
		
		return answer;
	}
}


/*
 * 경매 물품 n <= 100
 * 
 * amounts 의 길이 = m ≤ 100
 * 
 * 
 *  amounts 의 원소 ≤ 10억 -> 10000의 배수
 * 
 * 
 * 
 * */