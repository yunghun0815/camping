package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
