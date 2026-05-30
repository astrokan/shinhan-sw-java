package ch07.sec02;

public class SmartPhoneExample {

	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		System.out.println("model: " + myPhone.model);
		System.out.println("color: " + myPhone.color);
		
		System.out.println("wifi status: " + myPhone.wifi);
		
		myPhone.bell();
		myPhone.sendVoice("hello?");
		myPhone.receiveVoice("hi. hi?");
		myPhone.sendVoice("bye");
		myPhone.hangUp();
		
		myPhone.setWifi(true);
		myPhone.internet();
		
		
	}

}
