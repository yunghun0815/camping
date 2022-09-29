package web.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import web.dao.ItemDao;
import web.vo.Item;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("*.item")
public class ItemController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemController() {
		super();
		// TODO Auto-generated constructor stub
	}

	ItemDao itemDao = new ItemDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf('/'));
		String view = "index.jsp";

		if("/itemList.item".equals(cmd)) {
			System.out.println("장비전체 조회를 요청합니다.");
			request.setAttribute("itemList", itemDao.getItemList());
			System.out.println(itemDao.getItemList());
			view = "/item/itemList.jsp";
		}//장비조회 리스트
		else if("/itemDetail.item".equals(cmd)) {
			System.out.println("장비상세 조회를 요청합니다.");
			String itemNoStr = request.getParameter("itemNo");
			int itemNo = Integer.parseInt(itemNoStr);
			request.setAttribute("item", itemDao.detailItem(itemNo));
			view = "/item/itemDetail.jsp";
		}//장비 상세 조회
		else if("/itemInsert.item".equals(cmd)) {
			System.out.println("장비 등록을 요청합니다.");
			view = "/item/itemInsertForm.jsp";
		}//장비 등록
		else if("/itemUpdate.item".equals(cmd)) {
			System.out.println("수정정보를 요청합니다.");
			String itemNoStr = request.getParameter("itemNo");
			int itemNo = Integer.parseInt(itemNoStr);
			request.setAttribute("item", itemDao.detailItem(itemNo));
			view = "/item/itemUpdateForm.jsp";
		}//장비 수정


		RequestDispatcher disp = request.getRequestDispatcher(view);
		disp.forward(request, response);

	}//doget메소드

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf('/'));
		String view = "index.jsp";
		if("/itemInsert.item".equals(cmd)) {
			
			ServletContext application = request.getServletContext();
			String saveDirectory = application.getRealPath("/Uploads/item");
			int maxPostSize = 1024*1000;
			String encoding = "UTF-8";
			
			try {
				MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
				String realName = mr.getFilesystemName("attachedFile"); //현재 파일 이름
				String ext = realName.substring(realName.lastIndexOf(".")); // 파일 확장자
				String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
				String imgName = now + ext; //업로드일시.확장자
				
				System.out.println(application.getRealPath("/Uploads/item"));
				System.out.println(imgName);
		// Uploads/20220929_13530701.jpg
				File oldFile = new File(saveDirectory + File.separator + realName);
				File newFile = new File(saveDirectory + File.separator + imgName);
				oldFile.renameTo(newFile);
				
				String name = mr.getParameter("name");
				System.out.println("이름 : "+name);
				int price = Integer.parseInt(mr.getParameter("price"));
				System.out.println("가격"+price);
				String info = mr.getParameter("info");
				System.out.println(info);
				Item item = new Item();
				
				item.setName(name);
				item.setPrice(price);
				item.setInfo(info);
				item.setImgPath("Uploads/item/");
				item.setImgName(imgName);
				
				itemDao.insertItem(item);
				response.sendRedirect("itemList.item");
			}catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "파일업로드 오류");
				request.getRequestDispatcher("item/itemInsertForm.jsp").forward(request, response);
			}
		}//장비 등록
		else if("/itemUpdate.item".equals(cmd)) {
			int itemNo = Integer.parseInt(request.getParameter("itemNo"));
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String info = request.getParameter("info");
			String imgPath = request.getParameter("imgPath");
			String imgName = request.getParameter("imgName");

			Item item = new Item();

			item.setItemNo(itemNo);
			item.setName(name);
			item.setPrice(price);
			item.setInfo(info);
			item.setImgPath(imgPath);
			item.setImgName(imgName);

			itemDao.updateItem(item);
			System.out.println(imgName);
			response.sendRedirect("itemList.item");
		}//장비 수정
		else if("/itemDelete.item".equals(cmd)) {
			String itemNoStr = request.getParameter("itemNo");
			int itemNo = Integer.parseInt(itemNoStr);
			itemDao.deleteItem(itemNo);
			response.sendRedirect("itemList.item");
		}//장비 삭제

	}//doPost메소드

}//클래스
