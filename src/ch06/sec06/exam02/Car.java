package ch06.sec06.exam02;

public class Car {
	
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;
	
	Car() {
		
	}
	
	Car(String company) {
		this.company = company;
	}
	
	void car() {
		System.out.println("생성자 호출");
	}
}
