package ch05.sec09;

import java.util.Arrays;

public class ArrayCopyByForExample {

	public static void main(String[] args) {
		int[] oldIntArray = { 1, 2, 3 };

		// 1. for문을 통한 복사
		int[] newIntArray = new int[5];
		for (int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}

		for (int i = 0; i < newIntArray.length; i++) {
			System.out.print(newIntArray[i] + ", ");

		}

		System.out.println();
		System.out.println(Arrays.toString(newIntArray));

		// 2. arraycopy 메서드를 통한 복사
		int[] newIntArray2 = new int[5];
		System.arraycopy(oldIntArray, 0, newIntArray2, 0, oldIntArray.length);
		System.out.println(Arrays.toString(newIntArray2));
		
		// 3. copyOf를 활용
		int[] newIntArray3 = Arrays.copyOf(oldIntArray, 5);
		System.out.println(Arrays.toString(newIntArray3));
	}

}
