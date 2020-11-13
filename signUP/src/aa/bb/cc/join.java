package aa.bb.cc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aa.bb.cc.DB.DBManager;
import aa.bb.cc.bean.Member;

@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public join() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String pname = request.getParameter("name");
		String pgender = request.getParameter("gender");
		String pid = request.getParameter("id");
		String ppwd = request.getParameter("pwd");
		String pcpwd = request.getParameter("cpwd");
		String paddr = request.getParameter("addr");
		String ptel = request.getParameter("tel");
		String pemail = request.getParameter("email");
		String[] hobby = request.getParameterValues("hobby");
		String phobby = "";
		if(hobby==null) {
			phobby = "취미가 없습니다.";
		}
		else {
		for(int i =0; i<hobby.length;i++) {
			phobby+=hobby[i];
		}
		}
		DBManager dbm = new DBManager();
		dbm.insert(new Member("",pname,pgender,pid,ppwd,pcpwd,paddr,ptel,pemail,phobby));
		
		request.setAttribute("phobby", phobby);
		RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
