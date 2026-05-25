package ch04.secf;

import java.util.Scanner;

public class Example7 {

	public static void main(String[] args) {

		long money = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");
			System.out.print("선택> ");

			try {
				String value = sc.nextLine();

				if ("1".equals(value)) {
					System.out.print("예금액>");
					long deposit = Long.parseLong(sc.nextLine());
					money += deposit;

				} else if ("2".equals(value)) {
					System.out.print("출금액>");
					long withdrawal = Long.parseLong(sc.nextLine());
					if (money - withdrawal < 0) {
						System.out.println("잔고를 모두 출금합니다. 출금액: " + money);
					}
					money = Math.max(0, money - withdrawal);

				} else if ("3".equals(value)) {
					System.out.println("잔고>" + money);
				} else if ("4".equals(value)) {
					sc.close();
					System.out.println();
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("1~4 사이의 정수를 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("[error class] " + e.getClass());
				System.out.println("[error messsage]" + e.getMessage());
				sc.nextLine();
			}

		}

	}

}
