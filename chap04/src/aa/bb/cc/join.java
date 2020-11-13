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
		request.setCharacterEncoding("UTF-8");//요청한 파라메타(name,gender,id...) UTF-8형식으로
		response.setContentType("text/html;charset=UTF-8");//응답하는(웹페이지에서 출력 되는) UTF-8
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
		
		//데이터 저장
		DBManager dm = new DBManager();
		dm.insert(new Member("",pname, pgender, pid, ppwd, pcpwd, paddr, pphone, pemail, phos));
		
		RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
