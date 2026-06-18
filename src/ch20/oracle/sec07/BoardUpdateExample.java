package ch20.oracle.sec07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardUpdateExample {

	public static void main(String[] args) {
		// 커넥션 객체 선언
		Connection conn = null;
		
		try {
			// 드라이버클래스 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 커넥션객체 생성(db접속정보)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"testuser",
					"test1234"
					);
			
			// SQL(문자열)
			String sql = "" + 
					"DELETE FROM boards WHERE bwriter=?";
			// sql을 준비
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
			// ?자리에 값을 저장
			pstmt.setString(1, "winter");
			
			// 실행 후 변경이 일어난 개수 리턴
			int rows = pstmt.executeUpdate();
			System.out.println("삭제된 행 수: " + rows);
			
			pstmt.close();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {}
			}
		}

	}

}
