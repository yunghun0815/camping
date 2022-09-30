package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import web.service.WeatherService;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/index.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sky = null;
		String t1h = null;
		String weather = null;
		String weatherLink = null;
		try {
			WeatherService service = new WeatherService();
			String api = service.todayWeather();
		
			JSONObject obj = service.stringToJsonObject(api);
			JSONObject responseData = (JSONObject) obj.get("response");
			JSONObject body = (JSONObject) responseData.get("body");
			JSONObject items = (JSONObject) body.get("items");
			JSONArray item = (JSONArray) items.get("item");
		
			
			for(int i=0; i<item.size(); i++) {
				JSONObject itemObj = (JSONObject)item.get(i);
				if(itemObj.get("category").equals("T1H")) { //기온
					t1h = itemObj.get("fcstValue").toString();
					break;
				}
			}
			for(int i=0; i<item.size(); i++) {
				JSONObject itemObj = (JSONObject)item.get(i);
				if(itemObj.get("category").equals("SKY")) { //기상
					sky = itemObj.get("fcstValue").toString();
					break;
				}
			}
			if(sky.equals("1")) {
	            weather = "맑음";
	            weatherLink = "images/weather/sun.png";
	        }else if(sky.equals("2")) {
	            weather = "비 ";
	            weatherLink = "images/weather/rain.png";
	        }else if(sky.equals("3")) {
	            weather = "구름 많음";
	            weatherLink = "images/weather/cloud.png";
	        }else if(sky.equals("4")) {
	            weather = "흐림 ";
	            weatherLink = "images/weather/cloudy.png";
	        }
			request.setAttribute("temperature", t1h); //기온
			request.setAttribute("weatherLink", weatherLink);
			request.setAttribute("weather", weather);
//			String sky = JsonPath.parse(obj).read("$.response.body.items.item.[?(@.fcstTime=='1500')].[?(@.category=='SKY')].fcstValue").toString(); //기상
//			String T1H = JsonPath.parse(obj).read("$.response.body.items.item.[?(@.fcstTime=='1500')].[?(@.category=='T1H')].fcstValue").toString(); //기온
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
