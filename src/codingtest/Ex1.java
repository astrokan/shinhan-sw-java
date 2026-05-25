package codingtest;

public class Ex1 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		System.out.println(s.solution(5000, new int[] {10000, -13000, -4000, -2000, 6500, -20000}));
		System.out.println(s.solution(34151, new int[] {-34152, -40000, -50000}));

	}

}

/*
 1,000 ≤ m ≤ 500,000
 1 ≤ ledger 의 길이 (입출금 요청 횟수) ≤ 100
 1 ≤ ledger 의 모든 원소의 절댓값 ≤ 100,000
 // 최대 1000/0000 -> int 쌉가능
* */

class Solution {
	public int solution (int m, int[] ledger) {
		int account = 0;
		
		for (int i=0; i<ledger.length; i++) {
			if ((account + ledger[i]) >= -m) account += ledger[i];
			else continue;
		}
		
		return account;
	}
}
