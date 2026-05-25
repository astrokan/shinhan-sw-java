package prac00.omok;

import java.util.Scanner;

public class Controller {
	// 입력 값 유효성 검증, 돌 배치 
	public static void move(Board board, Player player) {
		
		while(true) {
			// 유효한 값 보낼때까지
			System.out.println();
			System.out.print(player.name+"> ");
			
			Scanner scanner = new Scanner(System.in);
			String[] input = scanner.nextLine().split(" ");
			
			if (hasRightForm(input, board)) {
				// 소문자 -> 대문자, 값 계산(숫자 위치로)
				String col = input[0].toUpperCase();
				int x = col.charAt(0) - 'A';
				if (x < 0 || x >= board.size){
					System.out.println("형식이 올바르지 않습니다. 다시 입력하시오!");
					continue;
				}
				int y = Integer.parseInt(input[1]);
				
				if (board.mark(player.stone, y, x)) break;
				else {
					System.out.println("이미 돌이 있으니 딴 곳에 두세요!");
				}
			}
			else {
				System.out.println("형식이 올바르지 않습니다. 다시 입력하시오!");
			}
		}
	}
	
	// 입력값 유효성 검증 
	public static boolean hasRightForm(String[] array, Board board) {
		if (array.length != 2) return false;
		if (array[0].length() != 1) return false;
		
		try {
			int second_input = Integer.parseInt(array[1]);
			if (second_input < 0 || second_input >= board.size) return false;
		} catch (NumberFormatException e) {
			return false;
		}
	
		return true;
	}
	
	// 오목 완성 또는 오목 초과 발생 -> 바로 종료 
	public static boolean hasOmok(Board board) {
    	// 방문 여부 판단
    	board.visited = new boolean[board.size][board.size][4];
    	
    	for (int i=0; i<board.size; i++) {
    		for (int j=0; j<board.size; j++) {
    			if (!board.map[i][j].equals(".")) {
    				int ret = board.search(i,j,board.map[i][j]);
    				
    				if (ret == 5) {
    		    		System.out.println("오목 입니다!");
    		    		return true;
    		    	} else if (ret >= 6) {
    		    		System.out.println("오목 초과 패배‍!️");
    		    		return true;
    		    	}
    			}
    		}
    	}
    	
    	return false;
    }
}
