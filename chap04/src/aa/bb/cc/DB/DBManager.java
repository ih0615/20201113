package aa.bb.cc.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import aa.bb.cc.bean.Member;

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

//제어문... 함수호출... 객체 사용...
public class DBManager {

	public Member selectOne(String idx) {
		Member member = new Member();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// ojdbc6.jar파일 추가되어있는지
			// DB연결하는 것
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement("select * from joinin where 회원번호=?");
			pstmt.setInt(1, Integer.parseInt(idx));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member.setIdx(rs.getString("회원번호"));
				member.setPname(rs.getString("이름"));
				member.setPid(rs.getString("아이디"));
				member.setPpwd(rs.getString("비밀번호"));
				member.setPgender(rs.getString("성별"));
				member.setPaddr(rs.getString("주소"));
				member.setPphone(rs.getString("전화번호"));
				member.setPemail(rs.getString("이메일"));
				member.setPhobby(rs.getString("취미"));
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

		return member;
	}

	public void insert(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
//			pstmt = conn.prepareStatement("insert into joinin " + 
//					"(회원번호,이름,성별,아이디,비밀번호,주소,전화번호,이메일,취미,가입시간) " + 
//					"VALUES (회원번호.nextVal,?,?,?,?,?,?,?,?,sysdate)");
			pstmt = conn.prepareStatement("insert into joinin " + "(회원번호,이름,성별,아이디,비밀번호,주소,전화번호,이메일,취미,가입날짜) "
					+ "values ((select nvl(max(회원번호)+1,1) from joinin),?,?,?,?,?,?,?,?,sysdate)");
			pstmt.setString(1, member.getPname());
			pstmt.setString(2, member.getPgender());
			pstmt.setString(3, member.getPid());
			pstmt.setString(4, member.getPpwd());
			pstmt.setString(5, member.getPaddr());
			pstmt.setString(6, member.getPphone());
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

	public void update(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement(
					"UPDATE JOININ SET 이름 = ?, 성별 = ?, 아이디 = ?, 비밀번호 = ?, 주소 = ?, 전화번호 = ?, 이메일 = ?, 취미 = ? WHERE 회원번호 = ?");
			pstmt.setString(1, member.getPname());
			pstmt.setString(2, member.getPgender());
			pstmt.setString(3, member.getPid());
			pstmt.setString(4, member.getPpwd());
			pstmt.setString(5, member.getPaddr());
			pstmt.setString(6, member.getPphone());
			pstmt.setString(7, member.getPemail());
			pstmt.setString(8, member.getPhobby());
			pstmt.setString(9, member.getIdx());
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

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// select 해서 반환되는 table 내용 담는 객체
		ArrayList<Member> al = new ArrayList<Member>();// rs내용을 바꿔서 arraylist에 담는 객체

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// ojdbc6.jar파일 추가되어있는지
			// DB연결하는 것
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement("select * from joinin order by 가입날짜 desc");
			// select -> executeQuery()
			// insert update delete ->executeUpdate();
			rs = pstmt.executeQuery();
			while (rs.next()) {// 그 다음 행이 있으면 true 없으면 false
//				System.out.println(i++);
				Member temp = new Member();
				temp.setIdx(rs.getString("회원번호"));
				temp.setPname(rs.getString("이름"));
				temp.setPid(rs.getString("아이디"));
				temp.setPpwd(rs.getString("비밀번호"));
				temp.setPgender(rs.getString("성별"));
				temp.setPaddr(rs.getString("주소"));
				temp.setPphone(rs.getString("전화번호"));
				temp.setPemail(rs.getString("이메일"));
				temp.setPhobby(rs.getString("취미"));
				System.out.println(temp);
				al.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {

			}
		}
		return al;
	}

	public void defualt() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// ojdbc6.jar파일 추가되어있는지
			// DB연결하는 것
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement("select * from joinin order by 가입날짜 desc");
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

	public void delete(String idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// ojdbc6.jar파일 추가되어있는지
			// DB연결하는 것
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement("delete from joinin where 회원번호=?");
			pstmt.setInt(1, Integer.parseInt(idx));
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

	public boolean checkLogin(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement("select * from joinin where 아이디=? and 비밀번호=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) { //로그인 성공...
				return true;
			} else {
				return false;
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
		return false;
	}
}
