package ch06.secf;

import java.util.Scanner;

public class BankApplication {
	
	// 밖으로 static 빼는게 능사가 아님. 참조자료형은 파라미터로 넘기면 그대로 주소값 넘어가니깐.
	// account와 idx는 main함수 안으로 넣고 파라미터로 넘기는 방향으로 가자.
	// 반면 기본자료형은 값을 넘김. (동치가 아님.)
	
	static Account[] account = new Account[100];
	static int idx = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		while (true) {
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------------");
			
			System.out.print("선택> ");
			String s = sc.nextLine();
			if ("1".equals(s)) {
				createAccount();
			} else if ("2".equals(s)) {
				showAccountList();
			} else if ("3".equals(s)) {
				deposit();
			} else if ("4".equals(s)) {
				withdraw();
			} else if ("5".equals(s)) {
				System.out.println("프로그램 종료");
				sc.close();
				break;
				
			}
		}

	}
	
	public static void createAccount() {
		String accNo, owner;
		long balance;
		
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		
		System.out.print("계좌번호: ");
		accNo = sc.nextLine();
		System.out.print("계좌주: ");
		owner = sc.nextLine();
		System.out.print("초기입금액: ");
		balance = Long.parseLong(sc.nextLine());
		
		account[idx++] = new Account(accNo, owner, balance);
		
		System.out.println("결과: 계좌가 생성되었습니다.");
		
		
		
		// !! 추가할 만한 고려사항: 이미 있는 계좌번호 생성 막
	}
	
	public static void showAccountList() {
		
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		
		for (int i=0; i<idx; i++) {
			System.out.println(account[i].getAccNo() + "\t" +
					account[i].getOwner()+ "\t" + account[i].getBalance());
			
		}
		
	}
	
	public static void deposit() {
		System.out.println("----------");
		System.out.println("예금");
		System.out.println("----------");
		
		// 1. 계좌번호 입력
		
		System.out.print("계좌번호: ");
		String accNo = sc.nextLine();
		
		
		int memberIdx = findMember(accNo);
		//System.out.println("memberIdx" + memberIdx);
		
		if (memberIdx >= 0) {
			// 2. 입금액 입력
			System.out.print("예금액: ");
			
			long money = Long.parseLong(sc.nextLine());
			account[memberIdx].deposit(money);
			
		} else {
			System.out.println("존재하지 않는 계좌번호입니다. 홈 화면으로 돌아갑니다.");
			return;
		}
		
	}
	
	public static int findMember(String accNo) {
		for (int i=0; i<idx; i++) {
			if (account[i].getAccNo().equals(accNo)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void withdraw() {
		System.out.println("----------");
		System.out.println("출금");
		System.out.println("----------");
		
		// 1. 계좌번호 입력
		
		System.out.print("계좌번호: ");
		String accNo = sc.nextLine();
		
		
		int memberIdx = findMember(accNo);
		
		if (memberIdx >= 0) {
			// 2. 출금액 입력
			System.out.print("출금액: ");
			
			long money = Long.parseLong(sc.nextLine());
			account[memberIdx].withdraw(money);
			
		} else {
			System.out.println("존재하지 않는 계좌번호입니다. 홈 화면으로 돌아갑니다.");
			return;
		}
		
	}

}
