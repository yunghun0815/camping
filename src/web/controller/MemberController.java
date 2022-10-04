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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String view = "index.do";
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String path = uri.substring(lastIndex);
		
		if("/signup.member".equals(path)) { //회원가입 페이지
			view = "/member/signup.jsp";
		}else if("/login.member".equals(path)) { //로그인 페이지
			if(session.getAttribute("loginCheck") != null) {
				session.removeAttribute("loginCheck");
				request.setAttribute("loginCheck", "fail");
			}
			view = "/member/login.jsp";
		}else if("/logout.member".equals(path)) { //로그아웃 처리
			session.invalidate();
			view = "index.do";
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
		String view = "index.do";
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
		}else if("/login.member".equals(path)){ //로그인 post 처리
			String id = request.getParameter("id"); // 파라미터값 id
			String pw = request.getParameter("pw"); // 파라미터값 pw
			String name = dao.login(id, pw); //로그인 메소드 실행
			dao.login2(id, pw);
			
			if(name != null) {  //이름이 있으면 session에 추가 
				//로그인 성공시 세션에 추가 후 인덱스페이지로
				session.removeAttribute("loginCheck");
				session.setAttribute("name", name);
				if(id.equals("admin")) {
					session.setAttribute("role", "admin");
				}else {
					session.setAttribute("role", "user");
				}
				session.setAttribute("id", id); // -> ${id}  == jyh 
				view = "index.do";
			}else { //이름이 없으면 로그인페이지로 이동
				session.setAttribute("loginCheck", "fail");
				System.out.println("로그인실패");
				view = "login.member";
			}
		}else if("/logout.member".equals(path)) { //로그아웃 처리
			session.invalidate();
			view = "index.do";
		}
		response.sendRedirect(view);
	}

}
