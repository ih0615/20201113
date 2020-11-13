package abc.abc.abc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class practice
 */
@WebServlet("/practice")
public class practice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public practice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String gender = request.getParameter("gender");
		String remark = request.getParameter("remark");

		Connection conn = null;
		PreparedStatement pasmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
//			pasmt = conn.prepareStatement("insert into student (이름,학번,성별,비고) " + "values('" + name + "','" + code
//					+ "','" + gender + "','" + remark + "')");
			pasmt = conn.prepareStatement("insert into student " + "(이름,학번,성별,비고) " + "values " + "('" + name + "','"
					+ code + "','" + gender + "','" + remark + "')");
			pasmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("연결 실패");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pasmt != null) {
					pasmt.close();
				}
			} catch (Exception e) {

			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
