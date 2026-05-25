package ch03.sec02;

public class ArithmeticOperatorExample {

	public static void main(String[] args) {
		byte v1 = 10;
		byte v2 = 4;
		int v3 = 5;
		long v4 = 10L;
		
		int result1 = v1 + v2;
		System.out.println("result1: " +result1);
		
		long result2 = v1 + v2 - v4;
		System.out.println("result2: " +result2);
		
		double result3 = (double) v1 / v2;
		System.out.println("result3: " +result3);
		
		int result4 = v1 % v2;
		System.out.println("result4: " +result4);
		
		String s1 = "admin";
		String s2 = new String("admin");
		String s3 = "admin";

		System.out.println(s1 == s2); // false. 왜? reference type은 메모리 주소값을 비교하는 꼴이 되어버림.
		System.out.println(s1 == s3); // true
		System.out.println(s1.equals(s2)); // true
	}

}
