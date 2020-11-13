package aa.bb.cc.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import aa.bb.cc.mm.Member;

/**
 * @PackageName : aa.bb.cc.DB
 * @FileName : DBManager.java
 * @Since : 2020. 11. 5
 * @Author : KB
 * @Description :
 *              =====================================================================================
 *              Modification History
 *              =====================================================================================
 *              Date Author Note
 *              -------------------------------------------------------------------------------------
 *              2020. 11. 5 KB 최초 작성
 *
 */
public class DBManager {
	public void insert(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement("insert into joinin " + "(회원번호,이름,성별,아이디,비밀번호,주소,전화번호,이메일,취미,가입날짜) "
					+ "values (회원번호.nextval,?,?,?,?,?,?,?,?,sysdate)");
			pstmt.setString(1, member.getPname());
			pstmt.setString(2, member.getPgender());
			pstmt.setString(3, member.getPid());
			pstmt.setString(4, member.getPpw());
			pstmt.setString(5, member.getPadr());
			pstmt.setString(6, member.getPtel());
			pstmt.setString(7, member.getPemail());
			pstmt.setString(8, member.getPhobby());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {

			}
		}

	}
}
