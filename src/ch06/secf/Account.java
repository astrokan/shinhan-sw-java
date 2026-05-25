package ch06.secf;

public class Account {
	private String accNo;
	private String owner;
	private long balance;
	
	Account(String accNo, String owner, long balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}
	
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	public long getBalance() {
		return balance;
	}
	
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public void deposit(long money) {
		this.balance += money;
	}
	
	public void withdraw(long money) {
		if (this.balance - money < 0) {
			System.out.print("잔액을 초과한 금액을 출금 요청했습니다. 잔고 전액 출금합니다");
			System.out.println("MONEY: " + this.balance);
			this.balance= 0;
		} else {
			this.balance -= money;
		}
	}
	// 출금 시 고려 가능한 사항 -> 전고 전액 출금이 아닌 출금 자체를 거부

}
