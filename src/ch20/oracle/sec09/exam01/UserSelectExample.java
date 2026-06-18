package ch20.oracle.sec09.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelectExample {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"testuser",
					"test1234"
					);
			
			String sql = "" +
			"SELECT userid, username, userpassword, userage, useremail " +
			"FROM users " +
			"WHERE userid=?";
			
			pstmt = conn.prepareStatement(sql);
			// ?자리에 값을 저장
			pstmt.setString(1, "winter");
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("userpassword"));
				user.setUserAge(rs.getInt(4));
				user.setUserEmail(rs.getString(5)); // 칼럼 순번을 이용
				System.out.println(user);
			} else {
				System.out.println("사용자 아이디가 존재하지 않음");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 해제는 생성했던 순서의 역순으로 -> 안전하게
			try {rs.close();} catch (Exception e) {} 
			try {pstmt.close();} catch (Exception e) {}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}

	}

}
