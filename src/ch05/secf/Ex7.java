package ch05.secf;

public class Ex7 {

	public static void main(String[] args) {
		
		int[] array = {1,5,3,8,2};
		int ret = Integer.MIN_VALUE;
		for (int i=0; i<array.length; i++) {
			ret = Math.max(ret, array[i]);
		}
		
		System.out.println("max_element: " + ret);

	}

}
