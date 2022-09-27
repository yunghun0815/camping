package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.MemberDao;
import web.vo.Member;
@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDao dao = new MemberDao();
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/index.jsp";
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String path = uri.substring(lastIndex);
		if("/signup.member".equals(path)) {
			view = "/member/signup.jsp";
		}else if("/login.member".equals(path)) {
			view = "/member/login.jsp";
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/index.jsp";
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String path = uri.substring(lastIndex);
		
		if("/signup.member".equals(path)) {
			Member member = new Member();
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			member.setPhoneNumber(request.getParameter("phoneNumber"));
			dao.signup(member);
			view = "login.member";
		}
		response.sendRedirect(view);
	}

}
