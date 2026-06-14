package ch17.sec06.exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapExample {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();

		studentList.add(new Student("홍길동", 85));
		studentList.add(new Student("홍길동", 92));
		studentList.add(new Student("홍길동", 87));

		studentList.stream()
			.mapToInt(s -> s.getScore())
			.forEach(score -> System.out.println(score));
		
		
		// 매개변수로 int[] -> List<Integer>
		int[] arr = {1,2,3};
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<arr.length; i++) {
			list.add(i);
		}
		
		// 매개변수로 int[] -> List<Integer>
		List<Integer> list2 = Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new));
		
		// List -> int[]
		int[] answer = list.stream().mapToInt(i->i).toArray();
		
		// List -> int[]
		
		int[] answer2 = new int[list.size()];
		for (int i=0; i<list.size(); i++) {
			answer2[i] = list.get(i);
		}
	}
}