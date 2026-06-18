package ch20.oracle.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import ch20.oracle.sec09.exam02.Board;

public class BoardExample2 {
	
	
	//Field
	private Scanner scanner = new Scanner(System.in);
	private Connection conn;
	
	//Constructor
	public BoardExample2() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
		} catch(Exception e) {
		e.printStackTrace();
		exit();
		}	
	}

	// Method
	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("-----------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------");
		
		try {
			// SQL(문자열)
			String sql = "" +
			"SELECT bno, btitle, bcontent, bwriter, bdate " +
			"FROM boards " +
			"ORDER BY bno DESC";
			// SQL을 준비 prepare
			PreparedStatement pstms = conn.prepareStatement(sql); // pstms 생성: 2
			ResultSet rs = pstms.executeQuery(); // rs 생성: 3
			
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.printf("%-6s%-12s%-16s%-40s\n",
						board.getBno(),
						board.getBwriter(),
						board.getBdate(),
						board.getBtitle());
			}
			rs.close();
			pstms.close();
		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
		mainMenu();
	}

	public void mainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();

		switch (menuNo) {
		case "1" -> create();
		case "2" -> read();
		case "3" -> clear();
		case "4" -> exit();
		}
	}

	public void create() {
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목:");
		board.setBtitle(scanner.nextLine());
		System.out.print("내용:");
		board.setBcontent(scanner.nextLine());
		System.out.print("작성자:");
		board.setBwriter(scanner.nextLine());
		
		System.out.println("-----------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if(menuNo.equals("1")) {
			try {
				String sql = "" +
				"INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate) " +
				"VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
			list();
		}
		
	}

	public void read() {
		System.out.println("[게시물 읽기]");
		System.out.print("bno: ");
		int bno = Integer.parseInt(scanner.nextLine());
		
		try {
			String sql = "" +
			"SELECT bno, btitle, bcontent, bwriter, bdate " +
			"FROM boards " +
			"WHERE bno=?";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getInt("bcontent"));
				board.setBwriter(rs.getInt("bwriter"));
				board.setBdate(rs.getInt("bdate"));
				System.out.println("##################");
				System.out.println("번호: ");
				System.out.println("##################");
				
				rs.close();
				pstmt.close();
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		list();
		

		list();
	}

	public void clear() {
		System.out.println("*** clear() 메소드 실행됨");
		list();
	}

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		BoardExample2 boardExample = new BoardExample2();
		boardExample.list();
	}

}
