package ch12.sec08;

import java.text.DecimalFormat;

public class DecimalFormatExample {

	public static void main(String[] args) {
		double num = 1234567.89;
		
		DecimalFormat df;
		
		df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#,###.0"); // 반올림 진행 (소수점 첫째자리까지)
		System.out.println(df.format(num));

	}

}
