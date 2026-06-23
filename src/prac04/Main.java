package prac04;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {

		Solution s = new Solution();
		int tickets1 = 10;
		int[][] requests1 = { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } };
		int tickets2 = 8;
		int[][] requests2 = { { 1, 9 }, { 3, 6 }, { 2, 5 } };
		int tickets3 = 20000;
		int[][] requests3 = { { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } };

		System.out.println(s.solution(tickets1, requests1));
		System.out.println(s.solution(tickets2, requests2));
		System.out.println(s.solution(tickets3, requests3));
	}
}

class Solution {
	public int solution(int tickets, int[][] requests) {
		int soldTickets = 0;

		Arrays.sort(requests, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o2[1] - o1[1]; // 내림차순
				return o1[0] - o2[0]; // 오름차순
			}

		});

		for (int i=0; i<requests.length; i++) {
			if (requests[i][1] > tickets) continue;
			tickets -= requests[i][1];
			soldTickets += requests[i][1];
//			System.out.println(requests[i][0] +"st = " + soldTickets);
			if (tickets == 0) break;
		}

		return soldTickets;
	}
}