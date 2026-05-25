package prac01.ps02;

class Item {
	// 필드
	String name;
	int power;

	// 생성자
	public Item(String name, int power) {
		this.name = name;
		this.power = power;
	}

	// 메소드(인스턴스 메소드) - 객체 정보를 문자열로 반환
	public String toString() {
		return String.format("Item { name: %s, power: %d }", name, power);
	}
}
