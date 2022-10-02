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


   ItemDao itemDao = new ItemDao();
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      String uri = request.getRequestURI();
      String cmd = uri.substring(uri.lastIndexOf('/'));
      String view = "index.do";

      if("/itemList.item".equals(cmd)) {
         request.setAttribute("itemList", itemDao.getItemList());
         System.out.println(itemDao.getItemList());
         view = "/item/itemList.jsp";
      }// 옣鍮꾩“ 쉶 由ъ뒪 듃
      else if("/itemDetail.item".equals(cmd)) {
         System.out.println(" 옣鍮꾩긽 꽭 議고쉶瑜   슂泥  빀 땲 떎.");
         String itemNoStr = request.getParameter("itemNo");
         int itemNo = Integer.parseInt(itemNoStr);
         request.setAttribute("item", itemDao.detailItem(itemNo));
         view = "/item/itemDetail.jsp";
      }// 옣鍮   긽 꽭 議고쉶
      else if("/itemInsert.item".equals(cmd)) {
         System.out.println(" 옣鍮   벑濡앹쓣  슂泥  빀 땲 떎.");
         view = "/item/itemInsertForm.jsp";
      }// 옣鍮   벑濡 
      else if("/itemUpdate.item".equals(cmd)) {
         System.out.println(" 닔 젙 젙蹂대    슂泥  빀 땲 떎.");
         String itemNoStr = request.getParameter("itemNo");
         int itemNo = Integer.parseInt(itemNoStr);
         request.setAttribute("item", itemDao.detailItem(itemNo));
         view = "/item/itemUpdateForm.jsp";
      }// 옣鍮   닔 젙


      RequestDispatcher disp = request.getRequestDispatcher(view);
      disp.forward(request, response);

   }//doget硫붿냼 뱶

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      String uri=request.getRequestURI();
      String cmd = uri.substring(uri.lastIndexOf('/'));
      String view = "index.do";
      if("/itemInsert.item".equals(cmd)) {
         
         ServletContext application = request.getServletContext();
         String saveDirectory = application.getRealPath("/Uploads/item");
         int maxPostSize = 1024*1000;
         String encoding = "UTF-8";
         
         try {

            
            MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
            String realName = mr.getFilesystemName("attachedFile"); // 쁽 옱  뙆 씪  씠由 
            String ext = realName.substring(realName.lastIndexOf(".")); //  뙆 씪  솗 옣 옄
            String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
            String imgName = now + ext; // 뾽濡쒕뱶 씪 떆. 솗 옣 옄
            
            System.out.println(application.getRealPath("/Uploads/item"));
            System.out.println(imgName);
      // Uploads/20220929_13530701.jpg
            File oldFile = new File(saveDirectory + File.separator + realName);
            File newFile = new File(saveDirectory + File.separator + imgName);
            oldFile.renameTo(newFile);
            
            String name = mr.getParameter("name");
            int price = Integer.parseInt(mr.getParameter("price"));
            String info = mr.getParameter("info");
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
            request.setAttribute("errorMessage", " 뙆 씪 뾽濡쒕뱶  삤瑜 ");
            request.getRequestDispatcher("item/itemInsertForm.jsp").forward(request, response);
         }
      
         

      }// 옣鍮   벑濡 
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
      }// 옣鍮   닔 젙
      else if("/itemDelete.item".equals(cmd)) {
         String itemNoStr = request.getParameter("itemNo");
         int itemNo = Integer.parseInt(itemNoStr);
         itemDao.deleteItem(itemNo);
         response.sendRedirect("itemList.item");
      }// 옣鍮   궘 젣

   }//doPost硫붿냼 뱶

}// 겢 옒 뒪