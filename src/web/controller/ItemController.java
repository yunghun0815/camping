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


import web.dao.ItemDao;
import web.vo.Item;

@WebServlet("*.item")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemController() {
		super();
		// TODO Auto-generated constructor stub
	}

	ItemDao itemDao = new ItemDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf('/'));
		String view = "index.jsp";

		if("/itemList.item".equals(cmd)) {
			System.out.println("�����ü ��ȸ�� ��û�մϴ�.");
			request.setAttribute("itemList", itemDao.getItemList());
			System.out.println(itemDao.getItemList());
			view = "/item/itemList.jsp";
		}//�����ȸ ����Ʈ
		else if("/itemDetail.item".equals(cmd)) {
			System.out.println("���� ��ȸ�� ��û�մϴ�.");
			String itemNoStr = request.getParameter("itemNo");
			int itemNo = Integer.parseInt(itemNoStr);
			request.setAttribute("item", itemDao.detailItem(itemNo));
			view = "/item/itemDetail.jsp";
		}//��� �� ��ȸ
		else if("/itemInsert.item".equals(cmd)) {
			System.out.println("��� ����� ��û�մϴ�.");
			view = "/item/itemInsertForm.jsp";
		}//��� ���
		else if("/itemUpdate.item".equals(cmd)) {
			System.out.println("���������� ��û�մϴ�.");
			String itemNoStr = request.getParameter("itemNo");
			int itemNo = Integer.parseInt(itemNoStr);
			request.setAttribute("item", itemDao.detailItem(itemNo));
			view = "/item/itemUpdateForm.jsp";
		}//��� ����


		RequestDispatcher disp = request.getRequestDispatcher(view);
		disp.forward(request, response);

	}//doget�޼ҵ�


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext application=null;
		
		String uri=request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf('/'));
		String view = "index.jsp";
		if("/itemInsert.item".equals(cmd)) {
			
		
			
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String info = request.getParameter("info");
			String imgPath = request.getParameter("imgPath");
			String imgName = request.getParameter("imgName");

			Item item = new Item();

			item.setName(name);
			item.setPrice(price);
			item.setInfo(info);
			item.setImgPath(imgPath);
			item.setImgName(imgName);
			System.out.println(item);
			itemDao.insertItem(item);
			response.sendRedirect("itemList.item");
		}//��� ���
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
		}//��� ����
		else if("/itemDelete.item".equals(cmd)) {
			String itemNoStr = request.getParameter("itemNo");
			int itemNo = Integer.parseInt(itemNoStr);
			itemDao.deleteItem(itemNo);
			response.sendRedirect("itemList.item");
		}//��� ����

	}//doPost�޼ҵ�

}//Ŭ����
