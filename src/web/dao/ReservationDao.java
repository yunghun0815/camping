package web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import web.vo.Member;
import web.vo.Reservation;

public class ReservationDao {

	DataSource dataSource;
	Connection con = null;
	
	public ReservationDao() {
		try {
			Context initCtx = new InitialContext();
			dataSource = (DataSource)initCtx.lookup("java:comp/env/camping_myoracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertReservation(Reservation reservation) {
		try {
			con = dataSource.getConnection();
			String sql = "insert into reservation values(reservation_no.nextval, ?, ?, ?, ?)";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, reservation.getCampingNo());
			psmt.setString(2, reservation.getMemberId());
			psmt.setDate(3, reservation.getReservationDate());
			psmt.setInt(4, reservation.getPersonnel());
			psmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {try{con.close();}catch(Exception e){}}
		}
	}

	public List<Date> getCampingNoReservation(int campingNo) {
		List<Date> list = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			String sql = "select r.reservation_Date from reservation r join camping c on "
					+ "r.camping_no = c.camping_no where r.camping_no = ?";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, campingNo);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Date date = rs.getDate(1);
				list.add(date);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {try{con.close();}catch(Exception e){}}
		}
		return list;
	}

	public List<Map<String, String>> detailReservation(String id) {
		List<Map<String, String>> list = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			String sql = "select r.reservation_no, r.reservation_date, c.name, c.price, c.address, c.img_path, r.personnel, "
					+ "c.img_name from reservation r join camping c on r.camping_no = c.camping_no where r.member_id = ?";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("reservationNo", String.valueOf(rs.getInt(1)));
				map.put("reservationDate", rs.getDate(2).toString());
				map.put("name", rs.getString(3));
				map.put("price",String.valueOf(rs.getInt(4)));
				map.put("address", rs.getString(5));
				map.put("imgPath",rs.getString(6));
				map.put("personnel", String.valueOf(rs.getInt(7)));
				map.put("imgName", rs.getString(8));
				
				list.add(map);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {try{con.close();}catch(Exception e){}}
		}		
		return list;
	}

	public void deleteReservation(int reservationNo) {
		try {
			con = dataSource.getConnection();
			String sql = "delete from reservation where reservation_no = ?";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, reservationNo);
			psmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {try{con.close();}catch(Exception e){}}
		}		
	}

}
