package prac07;

import java.util.*;

/*
규칙 1) 계좌번호는 0 ~ 9 사이의 숫자와 특수문자 -로만 이루어집니다. 
규칙 2) 계좌번호에 포함된 숫자의 개수는 11개 이상 14개 이하입니다.
규칙 3) 계좌번호에 포함된 -의 개수는 0개 이상 3개 이하입니다.
규칙 4) 계좌번호에 포함된 -는 연속해서 나타날 수 없고, 계좌번호의 처음이나 마지막 자리에 나타날 수 없습니다.
 * 
 * 비트마스킹 -> Map + 비트마스킹
 * 
 * 
 * 
 * */
public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		String[] nums1 = {
			    "4514--234495-1", "305-44-291501", "1-2-34-495-8623",
			    "492134545151", "623-421523-67341", "-5439-59639921",
			    "6235-7X3+47-7456", "98-76-543-210", "512-73-634901",
			    "000-999999-22555", "064-82-792561"
			};
		
		
		String[] nums2 = {
			    "1-2-3-456789012", "582845-385823", "48572-39485-89012",
			    "4-5-2-593328484", "4958-392945123-", "49582039415423",
			    "7-3-7-000000000", "485723-693812", "39482746582734",
			    "1-1-1-111111111", "A4944-5095-4951", "4851293412223"
			};
		
		String[] nums3 = {
			    "592356=5345", "49-694-4495-64", "5923565345%"
			};

		System.out.println(Arrays.toString(s.solution(nums1)));
		System.out.println(Arrays.toString(s.solution(nums2)));
		System.out.println(Arrays.toString(s.solution(nums3)));
		
	}

}


class Solution {
		
	public int[] solution(String[] nums) {
		Map<String, Integer> mp = new HashMap<>();
		
		for (String s: nums) {
			if (isValid(s)) {
				String tmp = "";
				// 검증된 계좌번호 분류 시작
				String[] arr = s.split("-");
				for (String token: arr) {
					tmp += token.length();
				}
				mp.put(tmp, (mp.getOrDefault(tmp, 0) + 1));
			}
		}
		
		List<Integer> list = new ArrayList<>(mp.values());
		
		Collections.sort(list, Collections.reverseOrder());

		return list.stream().mapToInt(i->i).toArray();
	}
	
	private boolean isValid(String s) {
		
		// 양 끝에 -
		if (s.charAt(0) == '-'  || s.charAt(s.length()-1) == '-') return false;
		
		// 0 이상 3 이하의 - 개수
		String[] arr = s.split("-");
		int cnt = 0;
		for (String str: arr) {
			if (str.isEmpty()) return false; // 연속된 -
			cnt++;
		}
		
		if (cnt >= 5) return false;
		
		// 계좌번호는 0 ~ 9 사이의 숫자와 특수문자 -로만 이루어집니다.
		// 계좌번호에 포함된 숫자의 개수는 11개 이상 14개 이하입니다.
		
		int nDigit=0;
		for (String token: arr) {
			for (char c: token.toCharArray()) {
				if (c < '0' || c > '9') return false;
				else nDigit++;
			} 
		}
		if (nDigit < 11 || nDigit > 14) return false;
		
		return true;	
	}
}