package prac06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// numstrs: 1 이상 100 이하
// numstrs의 원소: 길이가 1 이상 100 이하인 문자열
// words의 길이는 1 이상 10 이하
// 

public class Main {
	

	public static void main(String[] args) {
		Solution s = new Solution();
		
		// 첫 번째 행 데이터
		String[] numstrs1 = {"ZASSETE", "S4Z537B", "7_ASZEYB"};
		String[] words1 = {"2455373", "425", "373", "378"};
				
		// 두 번째 행 데이터
		String[] numstrs2 = {"ZAZZ373"};
		String[] words2 = {"2422373", "5455373", "2455373"};
		
		System.out.println(Arrays.toString(s.solution(numstrs1, words1)));
		System.out.println(Arrays.toString(s.solution(numstrs2, words2)));
		
	}
	
}

class Solution {
	private final String[][] str_list = {
			{"0", "O", "()"},
			{"1", "I"},
			{"2", "Z", "S", "7_"},
			{"3", "E", "B"},
			{"4", "A"},
			{"5", "Z", "S"},
			{"6", "b", "G"},
			{"7", "T", "Y"},
			{"8", "B", "E3"},
			{"9", "g", "q"}};
	
	public int[] solution(String[] numstrs, String[] words) {
		
		int[] answer = new int[words.length];
		for (int i=0; i<words.length; i++) { // words 순회
			answer[i] += countWords2(numstrs, words[i]);
		}
		
		return answer;
	}
	
	public int countWords2(String[] arr, String word) {
		int cnt = 0;
		for (int i=0; i<arr.length; i++) { // 문자열 순회
			
			String targetS = arr[i]; // 선택한 문자열
			for (int j=0; j<targetS.length(); j++) { // 문자열 1개 선택
				if (go(targetS, j, word, 0, new HashMap<>())) {
					cnt++;
					break;
				}
			}
		}
		return cnt;
	}
	
	public boolean go(String targetS, int strIdx, String word, int wordIdx, Map<String,String> strToNum) {
		
		if (wordIdx == word.length()) { // word가 포함되어있음. 체킹 완료.
			return true;
		}
		
		if (strIdx >= targetS.length()) { // 문자열 스캔 시작점이 outOFIdx임.
			return false;
		}
		
		String letterOfWord = String.valueOf(word.charAt(wordIdx)); // 숫자열 글자 가져오기
		int digit = word.charAt(wordIdx) - '0'; // 인덱스 접근 위한 int형 변환
		String[] digitArr = str_list[digit];
		
		
		for (String s : digitArr) {
            if (!targetS.startsWith(s, strIdx)) continue; // word에 대응하는 심볼로 매칭 불가
            if (strToNum.containsKey(s) && !strToNum.get(s).equals(letterOfWord)) {
                continue; // 다른 숫자가 이 심볼을 쓰고 있음 → 규칙 위반, skip
            }

            if (!strToNum.containsKey(s)) { // 이미 있던 심볼로 조회 시작
                strToNum.put(s, letterOfWord);
                if (go(targetS, strIdx + s.length(), word, wordIdx + 1, strToNum)) {
                    return true;
                }
                strToNum.remove(s); // 백트래킹
            }
            else { // 신규 심볼 -> 맵에 등록 (이미 같은 숫자로 등록된 건 다시 넣지 않음)
            	if (go(targetS, strIdx + s.length(), word, wordIdx + 1, strToNum)) {
                    return true;
                }
            }
        }

        return false;
	}

}
