package ch20.oracle.sec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TransactionExample {

	public static void main(String[] args) {
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
			
			conn.setAutoCommit(false);
			
			// SQL(문자열)
			String sql1 = "UPDATE accounts SET balance=balance-? WHERE ano=?";
			// sql을 준비
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1,10000);
			pstmt1.setString(2, "111-111-1111");
			int rows1 = pstmt1.executeUpdate();
			if(rows1 == 0) throw new Exception("출금되지 않았음");
			pstmt1.close();
			
			String sql2 = "UPDATE accounts SET balance=balance+? WHERE ano=?";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1,10000);
			//pstmt2.setString(2, "222-222-2222");
			pstmt2.setString(2, "333-222-2222");
			int rows2 = pstmt2.executeUpdate();
			if(rows2 == 0) throw new Exception("입금되지 않았음");
			pstmt2.close();
			
			conn.commit();
			System.out.println("계좌 이체 성공");
		
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch(SQLException e1) {}
			System.out.println("계좌 이체 실패");
			e.printStackTrace();
			
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {}
			}
		}

	}

}
