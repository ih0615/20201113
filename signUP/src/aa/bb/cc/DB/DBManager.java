package aa.bb.cc.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import aa.bb.cc.bean.Member;

public class DBManager {
	public void base() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement("");
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

	public void insert(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement(
					"insert into joinin (회원번호,이름,성별,아이디,비밀번호,주소,전화번호,이메일,취미,가입날짜) values ((select NVL(max(회원번호)+1,1) from joinin), ?, ?, ?, ?, ?, ?, ?, ?, sysdate)");
			pstmt.setString(1, member.getPname());
			pstmt.setString(2, member.getPgender());
			pstmt.setString(3, member.getPid());
			pstmt.setString(4, member.getPpwd());
			pstmt.setString(5, member.getPaddr());
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

	public ArrayList<Member> select() {
		ArrayList<Member> al = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement("select * from joinin order by 회원번호");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member temp = new Member();
				temp.setPidx(rs.getString("회원번호"));
				temp.setPname(rs.getString("이름"));
				temp.setPgender(rs.getString("성별"));
				temp.setPid(rs.getString("아이디"));
				temp.setPpwd(rs.getString("비밀번호"));
				temp.setPaddr(rs.getString("주소"));
				temp.setPemail(rs.getString("이메일"));
				temp.setPhobby(rs.getString("취미"));
				temp.setPtel(rs.getString("전화번호"));
				al.add(temp);
			}
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
		return al;
	}

	public void delete(String idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement("delete from joinin where 회원번호=?");
			pstmt.setInt(1,Integer.parseInt(idx));
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
