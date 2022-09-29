package web.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.MemberDao;
import web.vo.Member;
@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDao dao = new MemberDao();
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String view = "/index.jsp";
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String path = uri.substring(lastIndex);
		
		if("/signup.member".equals(path)) { //회원가입 페이지
			view = "/member/signup.jsp";
		}else if("/login.member".equals(path)) { //로그인 페이지
			view = "/member/login.jsp";
		}else if("/logout.member".equals(path)) { //로그아웃 처리
			session.removeAttribute("name");
			view = "/index.jsp";
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/index.jsp";
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String path = uri.substring(lastIndex);
		HttpSession session = request.getSession();
		if("/signup.member".equals(path)) { //회원가입 처리
			Member member = new Member();
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			member.setPhoneNumber(request.getParameter("phoneNumber"));
			dao.signup(member);
			view = "login.member";
		}else if("/login.member".equals(path)){
			Member member = new Member();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = dao.login(id, pw);
			if(name != null) { 
				//로그인 성공시 세션에 추가 후 인덱스페이지로
				session.removeAttribute("loginCheck");
				session.setAttribute("name", name);
				session.setAttribute("id", id);
				view = "/CampingSite/index.jsp";
			}else { 
				//실패시 다시 로그인 페이지로
				session.setAttribute("loginCheck", "fail");
				System.out.println("로그인실패");
				view = "login.member";
			}
		}else if("/logout.member".equals(path)) { //로그아웃 처리
			session.invalidate();
			view = "/CampingSite/index.jsp";
		}
		response.sendRedirect(view);
	}

}
