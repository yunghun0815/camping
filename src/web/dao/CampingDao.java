package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.vo.Camping;

public class CampingDao {
	DataSource dataSource;
	//DB연결
	public CampingDao() {
		try {
			Context initCtx = new InitialContext();
			dataSource = (DataSource)initCtx.lookup("java:comp/env/camping_myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Camping> getCampingList() {
		List<Camping> campList = new ArrayList<>();
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from camping";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt .executeQuery();
			while(rs.next()) {
				Camping camp = new Camping();
				camp.setCampingNo(rs.getInt("camping_no"));
				camp.setName(rs.getString("name"));
				camp.setInfo(rs.getString("info"));
				camp.setPrice(rs.getInt("price"));
				camp.setAddress(rs.getString("address"));
				camp.setImgPath(rs.getString("img_path"));
				camp.setImgName(rs.getString("img_name")); //" " -> 테이블 컬럼명
				
				campList.add(camp);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		return campList;
		
	}
	
	public Camping detailCamping(int campno) { //() 안에는 서블릿에서 받아올 값이 있을때 적음
		Camping camp = new Camping();
		Connection con =null;
		try {
			con =dataSource.getConnection();
			String sql ="select camping_no, name, info, price, "
					+ "address, img_path, img_name "
					+ "from camping where camping_no =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, campno); //첫번째 ?에 name값을 집어넣겠다
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				camp.setCampingNo(rs.getInt("camping_no"));
				camp.setName(rs.getString("name"));
				camp.setInfo(rs.getString("info"));
				camp.setPrice(rs.getInt("price"));
				camp.setAddress(rs.getString("address"));
				camp.setImgPath(rs.getString("img_path"));
				camp.setImgName(rs.getString("img_name"));
			}else {
				camp=null;
			} 
		}catch(Exception e) {
				throw new RuntimeException(e);
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		return camp;
	}
	
	public void insertCamping(Camping camp) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "insert into camping (camping_no, name, info, price, "
					+ "address, img_path, img_name, category )"
					+ "values (camping_no.nextval, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, camp.getName());
			stmt.setString(2, camp.getInfo());
			stmt.setInt(3, camp.getPrice());
			stmt.setString(4, camp.getAddress());
			stmt.setString(5, camp.getImgPath());
			stmt.setString(6, camp.getImgName());
			stmt.setString(7, camp.getCategory());
			stmt.executeUpdate();
			System.out.println("데이터 입력됨");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
	}
	
	public void updateCamping(Camping camp) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "update camping set name=? , info=? , price=?, "
					+ "address=? , img_path=? , img_name=? "
					+ "where camping_no=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, camp.getName());
			stmt.setString(2, camp.getInfo());
			stmt.setInt(3, camp.getPrice());
			stmt.setString(4, camp.getAddress());
			stmt.setString(5, camp.getImgPath());
			stmt.setString(6, camp.getImgName());
			stmt.setInt(7, camp.getCampingNo());
			stmt.executeUpdate();
			System.out.println("데이터 입력됨");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
	}
	
	public void deleteCamping(int campno) {
		Connection con =null;
		try {
			System.out.println("삭제 시작");
			con= dataSource.getConnection();
			String sql = "delete from camping where camping_no =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, campno);
			stmt.executeUpdate();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		
	}

	public List<Camping> getCampingCateList(String category) {
		List<Camping> campList = new ArrayList<>();
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from camping where category = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, category);
			ResultSet rs = stmt .executeQuery();
			while(rs.next()) {
				Camping camp = new Camping();
				camp.setCampingNo(rs.getInt("camping_no"));
				camp.setName(rs.getString("name"));
				camp.setInfo(rs.getString("info"));
				camp.setPrice(rs.getInt("price"));
				camp.setAddress(rs.getString("address"));
				camp.setImgPath(rs.getString("img_path"));
				camp.setImgName(rs.getString("img_name")); //" " -> 테이블 컬럼명
				camp.setCategory(rs.getString("category"));
				
				campList.add(camp);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		return campList;
	}
}