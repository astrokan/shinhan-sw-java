package prac02;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 부동소수점 오차 1. 상품가격: 1000.10원, 수수료: 0.20원 합계는? 2. 1천만원 대출, 연이율 3.5% ->대출 이자는?
		 */


		// 1-1
		long price100 = 100010;
		long fee100 = 20;
		
//		System.out.println((1000.10*100 + 0.20*100) / 100);
		System.out.println((double)(price100 + fee100) / 100);
		
		
		// 1-2
		double price = 1000.10;
		double fee = 0.20;
		
		BigDecimal price_b = new BigDecimal(String.valueOf(price)); // new BigDecimal("1000.10");
		BigDecimal fee_b = new BigDecimal(String.valueOf(fee)); // new BigDecimal("0.20");
		
		BigDecimal sum = price_b.add(fee_b);
		System.out.println(sum.setScale(2, RoundingMode.DOWN));
		
		// 2-1
		long loanInt = 10000000;
		long ratePerYear1000 = 35;
		
		System.out.println((double)loanInt * ratePerYear1000 / 1000);
		
		// 2-2
		double loan = 10000000;
		double ratePerYear = 0.035;
		
		BigDecimal loan_b = new BigDecimal(String.valueOf(loan));
		BigDecimal ratePerYear_b = new BigDecimal(String.valueOf(ratePerYear));
		
		
		BigDecimal interest = loan_b.multiply(ratePerYear_b);
		// 소수점이 길어질 경우를 대비, 버림 처리
		// 소수점 2번째 자리까지 표기
		System.out.println(interest.setScale(2, RoundingMode.DOWN));

	}

}
