package web.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.ReservationDao;
import web.vo.Reservation;

@WebServlet("*.res")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = "index.do";
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String path = uri.substring(lastIndex);
		ReservationDao dao = new ReservationDao();
		
		if("/reservationInsert.res".equals(path)) {
			request.setAttribute("reservationDate", request.getParameter("reservationDate"));
			request.setAttribute("campingNo", request.getParameter("campingNo"));
			view = "/reservation/reservationInsertForm.jsp";
		}else if("/reservationList.res".equals(path)) {
			int campingNo = 1;
			List<Date> list = dao.getCampingNoReservation(campingNo);
			request.setAttribute("campingName", "KCC");
			request.setAttribute("dateList", list);
			view = "/reservation/reservationList.jsp";
		}else if("/reservationDetail.res".equals(path)) {
			String id = request.getParameter("memberId");
			System.out.println(id);
			if(id == null || id.isEmpty()) {
				view = "login.member";
			}else {
				List<Map<String, String>> list = dao.detailReservation(id);
				request.setAttribute("list", list);
				view = "/reservation/reservationDetail.jsp";
			}
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "index.do";
		String uri = request.getRequestURI();
		ReservationDao dao = new ReservationDao();
		int lastIndex = uri.lastIndexOf("/");
		String path = uri.substring(lastIndex);
		if("/reservationInsert.res".equals(path)) {
			Reservation reservation = new Reservation();
			reservation.setMemberId(request.getParameter("memberId"));
			reservation.setReservationDate(Date.valueOf(request.getParameter("reservationDate")));
			reservation.setCampingNo(Integer.parseInt(request.getParameter("campingNo")));
			reservation.setPersonnel(Integer.parseInt(request.getParameter("personnel")));
			dao.insertReservation(reservation);
			view = "reservationList.res";
		}else if("/reservationDelete.res".equals(path)) {
			int reservationNo = Integer.parseInt(request.getParameter("reservationNo"));
			String memberId = request.getParameter("memberId");
			dao.deleteReservation(reservationNo);
			view = "reservationDetail.res?memberId="+memberId;
		}
		response.sendRedirect(view);
	}

}
