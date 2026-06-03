package ch12.sec11.exam01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // 롬복: 클래스에 이미 구현된 메서드가 있다면 만들지 않음. 
@AllArgsConstructor
public class Car {
	private String model;
	private String owner;
	
	public Car() {
		
	}
	
	public String getModel() {
		return "model: " + model;
	}
}
