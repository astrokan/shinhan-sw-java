package ch07.sec02;

public class SmartPhone extends Phone {
	public boolean wifi;
	
	public SmartPhone(String model, String color) {
		this.model = model; // Phone에게 물려받은 필드 model, color
		this.color = color;
	}
	
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("wifi status changed.");
	}
	
	public void internet() {
		System.out.println("internet connection succeed.");
	}
}
