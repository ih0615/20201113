package aa.bb.cc;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aa.bb.cc.DB.DBManager;
import aa.bb.cc.bean.Member;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Update() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBManager dbm = new DBManager();
		String idx = request.getParameter("idx");
		Member member = dbm.selectOne(idx);
		
		request.setAttribute("member", member);
		
		RequestDispatcher rd  = request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String idx = request.getParameter("idx");
		String pname = request.getParameter("name");
		String pgender = request.getParameter("gender");
		String pid = request.getParameter("id");
		String ppwd = request.getParameter("pwd");
		String pcpwd = request.getParameter("cpwd");
		String paddr = request.getParameter("addr");
		String pphone = request.getParameter("phone");
		String pemail = request.getParameter("email");
		String[] phobby = request.getParameterValues("hobby");
		String phos = "";
		if(phobby!=null) {
		for(String temp : phobby) {
			phos+=temp;
		}
		}
		else {
			phos = "취미가 없습니다.";
		}
		
		DBManager dm = new DBManager();
		
		dm.update(new Member(idx,pname, pgender, pid, ppwd, pcpwd, paddr, pphone, pemail, phos));
		
		RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}

}
