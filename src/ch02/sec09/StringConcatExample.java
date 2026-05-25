package ch02.sec09;

public class StringConcatExample {

	public static void main(String[] args) {
		int result1 = 10 + 2 + 8;
		System.out.println("result1: " + result1);
		
		String result2 = 10 + 2 + "8";
		System.out.println("result2: " + result2);
		
		String result3 = 10 + "2" + 8;
		System.out.println("result3: " + result3);
		
		String result4 = "10" + 2 + 8;
		System.out.println("result4: " + result4);
		
		String result5 = "10" + (2 + 8);
		System.out.println("result5: " + result5);
		
		int result6 = Integer.parseInt(result5);
		System.out.println(result6+10);
		
		String result7 = String.valueOf(result6);
		System.out.println(result7);
		
		String result8 = result6 + ""; // = String.valueOf(result)
		
	}
}
