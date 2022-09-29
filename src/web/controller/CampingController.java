package web.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.CampingDao;
import web.vo.Camping;

@WebServlet("*.camping")
public class CampingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    CampingDao dao = new CampingDao(); //DAO 객체 생성
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf('/'));
		String view ="/index.jsp"; //
		if("/campingList.camping".equals(cmd)) {
			request.setAttribute("campList", dao.getCampingList());
			view = "/camping/campingList.jsp";
			
		} else if("/campingDetail.camping".equals(cmd)) {
			String campnoStr = request.getParameter("campno");
			int campno = Integer.parseInt(campnoStr);
			request.setAttribute("camp", dao.detailCamping(campno)); //" "-> form에 전달할 속성
			view = "/camping/campingDetail.jsp";
		} else if("/campingInsert.camping".equals(cmd)) {
			view="/camping/campingInsertForm.jsp";
		} else if("/campingUpdate.camping".equals(cmd)) {
			String campnoStr = request.getParameter("campno"); //원래 값을 받아와야 함
			int campno = Integer.parseInt(campnoStr);
			request.setAttribute("camp", dao.detailCamping(campno)); //상세조회에서 수정할 값을 찾아와야 해서 detailcamping 메서드 가져옴
			view="/camping/campingUpdate.jsp";
		} else if("/campingDelete.camping".equals(cmd)) {
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(view);
		disp.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf('/'));
		if("/campingInsert.camping".equals(cmd)) {
			String name = request.getParameter("name");
			String info= request.getParameter("info");
			String price= request.getParameter("price");
			String address= request.getParameter("address");
			String imgPath= request.getParameter("imgPath");
			String imgName= request.getParameter("imgName");
			
			Camping camp = new Camping();
			
			camp.setName(name);
			camp.setInfo(info);
			camp.setPrice(Integer.parseInt(price));
			camp.setAddress(address);
			camp.setImgPath(imgPath);
			camp.setImgName(imgName);
			
			dao.insertCamping(camp);
			response.sendRedirect("campingList.camping");
		} else if("/campingUpdate.camping".equals(cmd)) {
			String campingNo= request.getParameter("campingNo"); //" " ->JSP에 input 태그 name값 
			String name = request.getParameter("name");
			String info= request.getParameter("info");
			String price= request.getParameter("price");
			String address= request.getParameter("address");
			String imgPath= request.getParameter("imgPath");
			String imgName= request.getParameter("imgName");
			
			Camping camp = new Camping();
			
			camp.setCampingNo(Integer.parseInt(campingNo));
			camp.setName(name);
			camp.setInfo(info);
			camp.setPrice(Integer.parseInt(price));
			camp.setAddress(address);
			camp.setImgPath(imgPath);
			camp.setImgName(imgName);
			
			dao.updateCamping(camp);
			response.sendRedirect("campingList.camping");
		} else if("/campingDelete.camping".equals(cmd)) {
			String campno = request.getParameter("campno");
			dao.deleteCamping(Integer.parseInt(campno));
			response.sendRedirect("campingList.camping");
		}
		
	}

}
