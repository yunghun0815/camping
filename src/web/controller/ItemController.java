package web.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import web.dao.ItemDao;
import web.vo.Item;
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
			String category = request.getParameter("category");
			if(category == null ) {
				request.setAttribute("itemList", itemDao.getItemList());
			}else {
				request.setAttribute("itemList",itemDao.getCategoryList(category));
			}
			view = "/item/itemList.jsp";
		}//�옣鍮꾩“�쉶 由ъ뒪�듃
		else if("/itemDetail.item".equals(cmd)) {
			String itemNoStr = request.getParameter("itemNo");
			int itemNo = Integer.parseInt(itemNoStr);
			request.setAttribute("item", itemDao.detailItem(itemNo));
			view = "/item/itemDetail.jsp";
		}//�옣鍮� �긽�꽭 議고쉶
		else if("/itemInsert.item".equals(cmd)) {
			view = "/item/itemInsertForm.jsp";
		}//�옣鍮� �벑濡�
		else if("/itemUpdate.item".equals(cmd)) {
			String itemNoStr = request.getParameter("itemNo");
			int itemNo = Integer.parseInt(itemNoStr);
			request.setAttribute("item", itemDao.detailItem(itemNo));
			view = "/item/itemUpdateForm.jsp";
		}//�옣鍮� �닔�젙


		RequestDispatcher disp = request.getRequestDispatcher(view);
		disp.forward(request, response);

	}//doget硫붿냼�뱶

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
			int maxPostSize = 3 * 1024 * 1024;
			String encoding = "UTF-8";

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
			String realName = mr.getFilesystemName("attachedFile"); //�쁽�옱 �뙆�씪 �씠由�
			String ext = realName.substring(realName.lastIndexOf(".")); // �뙆�씪 �솗�옣�옄
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String imgName = now + ext; //�뾽濡쒕뱶�씪�떆.�솗�옣�옄

			// Uploads/20220929_13530701.jpg
			File oldFile = new File(saveDirectory + File.separator + realName);
			File newFile = new File(saveDirectory + File.separator + imgName);
			oldFile.renameTo(newFile);

			String name = mr.getParameter("name");
			int price = Integer.parseInt(mr.getParameter("price"));
			String info = mr.getParameter("info");
			String category = mr.getParameter("category");
			Item item = new Item();

			item.setName(name);
			item.setPrice(price);
			item.setInfo(info);
			item.setImgPath("Uploads/item/");
			item.setImgName(imgName);
			item.setCategory(category);

			itemDao.insertItem(item);
			response.sendRedirect("itemList.item");

		}//�옣鍮� �벑濡�
		else if("/itemUpdate.item".equals(cmd)) {

			ServletContext application = request.getServletContext();
			String saveDirectory = application.getRealPath("/Uploads/item");
			int maxPostSize = 3 * 1024 * 1024;
			String encoding = "UTF-8";

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
			String realName = mr.getFilesystemName("attacheFile");

			if(realName == null || realName == "") {

				String name = mr.getParameter("name");
				int price = Integer.parseInt(mr.getParameter("price"));
				String info = mr.getParameter("info");
				String category = mr.getParameter("category");
				int itemNo = Integer.parseInt(mr.getParameter("itemNo"));
				
				Item item = new Item();
				item.setItemNo(itemNo);
				item.setName(name);
				item.setPrice(price);
				item.setInfo(info);
				item.setCategory(category);
				itemDao.exceptionUpdate(item);

			}else {
				String ext = realName.substring(realName.lastIndexOf("."));
				String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
				String imgName = now + ext;

				File oldFile = new File(saveDirectory + File.separator + realName); //원래 파일이름
				File newFile = new File(saveDirectory + File.separator + imgName); //새로운 파일이름
				oldFile.renameTo(newFile);

				int itemNo = Integer.parseInt(mr.getParameter("itemNo"));
				String name = mr.getParameter("name");
				int price = Integer.parseInt(mr.getParameter("price"));
				String info = mr.getParameter("info");
				String category = mr.getParameter("category");

				Item item = new Item();

				item.setItemNo(itemNo);
				item.setName(name);
				item.setPrice(price);
				item.setInfo(info);
				item.setImgPath("Uploads/item/");
				item.setImgName(imgName);
				item.setCategory(category);

				itemDao.updateItem(item);
			}
			response.sendRedirect("itemList.item");

		}//�옣鍮� �닔�젙
		else if("/itemDelete.item".equals(cmd)) {
			String itemNoStr = request.getParameter("itemNo");
			int itemNo = Integer.parseInt(itemNoStr);
			itemDao.deleteItem(itemNo);
			response.sendRedirect("itemList.item");
		}//�옣鍮� �궘�젣

	}//doPost硫붿냼�뱶

}//�겢�옒�뒪
