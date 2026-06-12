package ch16.sec01;

public class LambdaExample {

	public static void main(String[] args) {
		action((x,y) -> {
			int result = x + y;
			System.out.println("result: " + result);
		});
		
		action((x,y)->{
			int result = x - y;
			System.out.println("result: " + result);
		});
		
		action2((x,y)->x+y); // action2((x,y) -> return (x+y));

	}
	
	public static void action(Calculable calculable) {
		int x = 10;
		int y = 4;
		calculable.calculate(x, y);
	}
	
	public static void action2(Calculable2 calculable) {
		int x = 10;
		int y = 4;
		calculable.calculate(x, y);
	}
}
