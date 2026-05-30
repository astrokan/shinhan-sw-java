package ch07.sec02;

public class Phone {
	public String model;
	public String color;
	
	public void bell() {
		System.out.println("bell rings!!!!!");
	}
	
	public void sendVoice(String message) {
		System.out.println("self: " + message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("opp: " + message);
	}
	
	public void hangUp() {
		System.out.println("quit");
	}
	
}
