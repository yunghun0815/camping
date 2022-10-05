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

import web.dao.CampingDao;
import web.vo.Camping;

@WebServlet("*.camping")
public class CampingController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
    CampingDao dao = new CampingDao(); //DAO 媛앹껜  깮 꽦
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      String uri = request.getRequestURI();
      String cmd = uri.substring(uri.lastIndexOf('/'));
      String view ="/index.do"; //
      if("/campingList.camping".equals(cmd)) {
    	 String category = request.getParameter("category");
    	 if(category == null) {
    		 request.setAttribute("campList", dao.getCampingList());
    	 }else {
    		 request.setAttribute("category", category);
    		 request.setAttribute("campList", dao.getCampingCateList(category));
    	 }
         view = "/camping/campingList.jsp";
         
      } else if("/campingDetail.camping".equals(cmd)) {
         String campnoStr = request.getParameter("campno");
         int campno = Integer.parseInt(campnoStr);
         request.setAttribute("camp", dao.detailCamping(campno)); //" "-> form 뿉  쟾 떖 븷  냽 꽦
         view = "/camping/campingDetail.jsp";
      } else if("/campingInsert.camping".equals(cmd)) {
         view="/camping/campingInsertForm.jsp";
      } else if("/campingUpdate.camping".equals(cmd)) {
         String campnoStr = request.getParameter("campno"); // 썝 옒 媛믪쓣 諛쏆븘   빞  븿
         int campno = Integer.parseInt(campnoStr);
         request.setAttribute("camp", dao.detailCamping(campno)); // 긽 꽭議고쉶 뿉 꽌  닔 젙 븷 媛믪쓣 李얠븘   빞  빐 꽌 detailcamping 硫붿꽌 뱶 媛  졇 샂
         view="/camping/campingUpdate.jsp";
      } else if("/campingDelete.camping".equals(cmd)) {
      }
      
      RequestDispatcher disp = request.getRequestDispatcher(view);
      disp.forward(request, response);
      
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      String uri = request.getRequestURI();
      String cmd = uri.substring(uri.lastIndexOf('/'));
      
      if("/campingInsert.camping".equals(cmd)) {
         
         ServletContext application = request.getServletContext();
         String saveDirectory = application.getRealPath("/Uploads/camping");
         int maxPostSize = 1024*1000;
         String encoding = "UTF-8";
         
         try {
            MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
            String realName = mr.getFilesystemName("attachedFile");
            String ext = realName.substring(realName.indexOf('.'));
            String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
            String imgName = now + ext;
            
            File oldFile = new File(saveDirectory + File.separator + realName);
            File newFile = new File(saveDirectory + File.separator + imgName);
            oldFile.renameTo(newFile);
            
            String name = mr.getParameter("name");
            String info= mr.getParameter("info");
            String price= mr.getParameter("price");
            String address= mr.getParameter("address");
            String category = mr.getParameter("category");
            
            Camping camp = new Camping();
            
            camp.setName(name);
            camp.setInfo(info);
            camp.setPrice(Integer.parseInt(price));
            camp.setAddress(address);
            camp.setImgPath("Uploads/camping/");
            camp.setImgName(imgName);
            camp.setCategory(category);
            
            dao.insertCamping(camp);
            response.sendRedirect("campingList.camping");
            
         }catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "파일업로드 오류");
            request.getRequestDispatcher("camping/campingInsertForm.jsp").forward(request, response);
         }
         
      }else if("/campingUpdate.camping".equals(cmd)) {
         
         ServletContext application = request.getServletContext();
         String saveDirectory = application.getRealPath("/Uploads/camping");
         int maxPostSize = 1024*1000;
         String encoding = "UTF-8";
         
         try {
            MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
            String realName = mr.getFilesystemName("attachedFile");
            String ext = realName.substring(realName.indexOf("."));
            String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
            String imgName = now + ext;
            
            File oldFile = new File(saveDirectory + File.separator + realName);
            File newFile = new File(saveDirectory + File.separator + imgName);
            oldFile.renameTo(newFile);
            
            String campingNo= mr.getParameter("campingNo"); //" " ->JSP 뿉 input  깭洹  name媛  
            String name = mr.getParameter("name");
            String info= mr.getParameter("info");
            String price= mr.getParameter("price");
            String address= mr.getParameter("address");
            
            Camping camp = new Camping();
            
            camp.setCampingNo(Integer.parseInt(campingNo));
            camp.setName(name);
            camp.setInfo(info);
            camp.setPrice(Integer.parseInt(price));
            camp.setAddress(address);
            camp.setImgPath("Uploads/camping/");
            camp.setImgName(imgName);
            
            dao.updateCamping(camp);
            response.sendRedirect("campingList.camping");
         } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "파일업로드 실패");
            request.getRequestDispatcher("camping/campingInsertForm.jsp").forward(request, response);
         }
      } else if("/campingDelete.camping".equals(cmd)) {
         String campno = request.getParameter("campno");
         dao.deleteCamping(Integer.parseInt(campno));
         response.sendRedirect("campingList.camping");
      }
      
   }

}