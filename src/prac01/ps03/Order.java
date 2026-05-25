package prac01.ps03;

class Order {
	// 필드(인스턴스 필드)
	int orderNum;
	Menu[] menus;

	// 생성자
	public Order(int orderNum, Menu[] menus) {
		this.orderNum = orderNum;
		this.menus = menus;
	}

	// 메소드(인스턴스 메소드)
	public int totalPrice() {
		/* 1. 모든 주문 메뉴의 총합을 반환하세요. */
		int sum = 0;
		for (Menu menu : menus) {
			sum += menu.price;
		}

		return sum;
	}
}
