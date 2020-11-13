package aa.bb.cc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aa.bb.cc.DB.DBManager;
import aa.bb.cc.mm.Member;


@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public join() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		
		String pname = request.getParameter("name");
		String pgender = request.getParameter("gender");
		String pid = request.getParameter("id");
		String ppw = request.getParameter("pw");
		String ppwr = request.getParameter("pwr");
		String ptel = request.getParameter("tel");
		String padr = request.getParameter("adr");
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
		DBManager dbm = new DBManager();
		dbm.insert(new Member(pname, pgender, pid, ppw, ppwr, padr, ptel, pemail, phos));
		RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
