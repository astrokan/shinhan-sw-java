package ch12.sec11.exam01;

public class GetClassExample {

	public static void main(String[] args) {
		
		// 1
		Class clazz = Car.class;
		
		// 2
//		Class clazz = Class.forName("ch12.sec11.exam01.Car");
		
		// 3
//		Car car = new Car();
//		Class clazz = car.getClass();
		
		System.out.println("패키지: " +clazz.getPackage(). getName()); 
		System.out.println("클래스 간단 이름: " +clazz.getSimpleName()); 
		System.out.println("클래스 전체 이름: " + clazz.getName()); 
	}

}
