package web.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WeatherService {
	private final String serviceKey = "D40xyORzPi6E84EcRxNvPOzMSyLHBqf%2Ft86yjsLmURByMInhZK0%2F1aN8Pjy5P9Yx%2BusFiaI2W7CUV4bOkuoomA%3D%3D";
	String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";
	String pageNo = "1";//페이지 번호
	String numOfRows = "1000";//행 수
	String dataType = "JSON"; //타입 xml or json
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH");
	SimpleDateFormat sdf3 = new SimpleDateFormat("mm");
	
	String baseDate = sdf.format(date);
	
	int hour = Integer.parseInt(sdf2.format(date));
	int min = Integer.parseInt(sdf3.format(date));
	String nx = "37"; //서울
	String ny = "127";
	
	
	
	public String todayWeather() {
		if(min < 40) {
			hour --;
		}
		try {
	        StringBuilder urlBuilder = new StringBuilder(apiUrl);
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey);
	        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); //경도
	        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8")); //위도
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); //경도
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); //위도
	        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate, "UTF-8")); /* 조회하고싶은 날짜*/
	        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(hour+"00", "UTF-8")); /* 조회하고싶은 기준시간 */
	        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode(dataType, "UTF-8"));	/* 타입 */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			
			if (responseCode == 200) { 
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { 
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			return response.toString();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public JSONArray stringToJsonArray(String data) throws ParseException {
		
        JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray)parser.parse(data);
		
		return jsonArray;
	}
	
	//String to JsonObject
	public JSONObject stringToJsonObject(String data) throws ParseException {
		
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(data);
		
		return jsonObject;
	}
}
