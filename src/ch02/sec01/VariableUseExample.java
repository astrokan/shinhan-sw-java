package ch02.sec01;

public class VariableUseExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간 " + minute + "분");
		
		int totalMinute = (hour*60) + minute;
		
		System.out.println("총 " + totalMinute + "분");
		
		long var1 = 10000000000L; // L무조건 붙여야 함!!!!!! 100억은 int 범위를 넘어선다.
		long var2 = 100;
		
		double pi = 3.14;
		int pi2 = (int)pi;
		System.out.println(pi2); // 소수점 유실
		
		// 우변 둘 중 하나 double 타입이어야 유실 없음
		int x = 5;
		int y = 4;
		double z = x / y;
		
	}
}