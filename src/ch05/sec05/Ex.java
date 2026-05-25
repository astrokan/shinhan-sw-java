package ch05.sec05;

public class Ex {

	public static void main(String[] args) {
		
		// 파일명을 밀리세컨드로 변환
		
		// String fileName = "asdfasdfasdf.jpg";
		String fileName = "2025.1.1.1.jpg";
		
		/*
		 * 
		 * 자바에서 마침표(.)를 기준으로 문자열을 자를 때 split("\\.")을 사용
		 * 점(.)은 정규표현식에서 '모든 문자'를 뜻하므로, 이스케이프(\\) 처리가 필수.
		 * 
		 * */
		
//		for(int i=0; i<tokens.length; i++) {
//			System.out.println(tokens[i]);
//		}
		
		//sol 1(배열로 split)
		
		String[] tokens = fileName.split("\\.");
		
		// 왜 length를 사용? 2026.05.19.jpg의 경우를 고려
		String newFileName = System.currentTimeMillis() + "." + tokens[tokens.length-1];
		System.out.println(newFileName);
		
		//sol 2(중첩 메서드)
	
		newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		System.out.println(newFileName);
	}

}
