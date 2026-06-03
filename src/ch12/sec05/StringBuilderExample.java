package ch12.sec05;

public class StringBuilderExample {

	public static void main(String[] args) {
//		String data = new StringBuilder()
//				.append("DEF")
//				.insert(0, "ABC")
//				.delete(3, 4)
//				.toString();
//		System.out.println(data);
		
		long start = System.currentTimeMillis();
		
//		String str = "";
//		for (int i=0; i<1000000; i++) {
//			str += i;
//		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}
