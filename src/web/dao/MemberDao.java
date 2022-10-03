package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.vo.Member;

public class MemberDao {
	private DataSource dataSource;
	Connection con = null;
	//DB연결
	public MemberDao() {
		try {
			Context initCtx = new InitialContext();
			dataSource = (DataSource)initCtx.lookup("java:comp/env/camping_myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	} 
	
	public void signup(Member member) {
		try {
			con = dataSource.getConnection();
			String sql = "insert into member values(?, ?, ?, ?)";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPw());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getPhoneNumber());
			psmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {try{con.close();}catch(Exception e){}}
		}
		
	}
	
	public String login(String id, String pw) {
		String name = null;
		try {
			con = dataSource.getConnection();
			String sql = "select name from member where id = ? and pw = ?";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				name = rs.getString(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {try{con.close();}catch(Exception e){}}
		}
		
		return name;
	}
	public String login2(String id, String pw) {
		String name = null;
		try {
			con = dataSource.getConnection();
			String sql = "select pw from member where id = ?";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				name = rs.getString(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {try{con.close();}catch(Exception e){}}
		}
		
		return name;
	}

	public int idCheck(String id) {
		int count = 0;
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from member where id = ?";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {try{con.close();}catch(Exception e){}}
		}
		return count;
	}
}
