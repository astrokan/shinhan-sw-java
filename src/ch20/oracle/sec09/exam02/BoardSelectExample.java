package ch20.oracle.sec09.exam02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch20.oracle.sec09.exam01.User;

public class BoardSelectExample {

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
			"SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " +
			"FROM boards " +
			"WHERE bwriter=?";
			
			pstmt = conn.prepareStatement(sql);
			// ?자리에 값을 저장
			pstmt.setString(1, "winter");
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));

				System.out.println(board);
				
				Blob blob = board.getBfiledata();
				if (blob != null) {
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream(board.getBfilename());
					is.transferTo(os);
					os.flush();
					os.close();
					is.close();
				}
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
