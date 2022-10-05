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

import web.vo.Item;

public class ItemDao {

	DataSource dataSource;
	public ItemDao() {
		try {
			Context initCtx = new InitialContext();
			dataSource = (DataSource) initCtx.lookup("java:comp/env/camping_myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	} //���� ����

	public List<Item> getItemList() {
		List<Item> itemList = new ArrayList<>();
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql ="select item_no, name, price, info, img_path,img_name "
					+ "from item";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Item item = new Item();
				item.setItemNo(rs.getInt("item_no"));
				item.setName(rs.getString("name"));
				item.setPrice(rs.getInt("price"));
				item.setInfo(rs.getString("info"));
				item.setImgPath(rs.getString("img_path"));
				item.setImgName(rs.getString("img_name"));

				itemList.add(item);
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			if(con != null) try { con.close(); } catch (Exception e) {
				e.printStackTrace();
			}
		}
		return itemList;
	} //��� ��ȸ

	public Item detailItem(int itemNo) {
		Connection con = null;
		Item item = new Item();

		try {
			con = dataSource.getConnection();
			String sql = "select item_no, name, price, info, img_path, img_name, category "
					+"from item "
					+"where item_no=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, itemNo);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				item.setItemNo(rs.getInt("item_no"));
				item.setName(rs.getString("name"));
				item.setPrice(rs.getInt("price"));
				item.setInfo(rs.getString("info"));
				item.setImgPath(rs.getString("img_path"));
				item.setImgName(rs.getString("img_name"));
				item.setCategory(rs.getString("category"));
			}else {
				item = null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			if(con != null) try { con.close(); } catch (Exception e) {
				e.printStackTrace();
			}
		}
		return item;
	}//���� ��ȸ
	public void insertItem(Item item) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "insert into item (item_no, name, price, info, img_path, img_name, category) "
					+ "values(item_no.nextval, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, item.getName());
			stmt.setInt(2, item.getPrice());
			stmt.setString(3, item.getInfo());
			stmt.setString(4, item.getImgPath());
			stmt.setString(5, item.getImgName());
			stmt.setString(6, item.getCategory());

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if (con != null) try { con.close(); } catch (Exception e) {
				e.printStackTrace();
			}
		}
	}//��� ���
	public void updateItem(Item item) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "update item set name=?, price=?, info=?, "
					+ "img_path=?, img_name=?, category=? "
					+ "where item_no=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, item.getName());
			stmt.setInt(2, item.getPrice());
			stmt.setString(3, item.getInfo());		
			stmt.setString(4, item.getImgPath());
			stmt.setString(5, item.getImgName());
			stmt.setString(6, item.getCategory());
			stmt.setInt(7, item.getItemNo());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if (con != null) try { con.close(); } catch (Exception e) {
				e.printStackTrace();
			}
		}
	}//��� ����
	public void deleteItem (int itemNo) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "delete from item where item_no=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, itemNo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if (con != null) try { con.close(); } catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public List<Item> getCategoryList(String category) {
		List<Item> categoryList = new ArrayList<>();
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select item_no, name, price, info, img_path, img_name, category "+ 
					"from item "+ 
					"where category =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, category);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Item item = new Item();
				item.setItemNo(rs.getInt("item_no"));
				item.setName(rs.getString("name"));
				item.setPrice(rs.getInt("price"));
				item.setInfo(rs.getString("info"));
				item.setImgPath(rs.getString("img_path"));
				item.setImgName(rs.getString("img_name"));
				item.setCategory(rs.getString("category"));

				categoryList.add(item);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if (con != null) try { con.close(); } catch (Exception e) {
				e.printStackTrace();
			}
		}
		return categoryList;
	}//ī�װ� �� ��ȸ
	public void exceptionUpdate(Item item) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "update item set name=?, "
					+ "price = ?, info=?, category=? "
					+ "where item_no=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, item.getName());
			stmt.setInt(2, item.getPrice());
			stmt.setString(3, item.getInfo());
			stmt.setString(4, item.getCategory());
			stmt.setInt(5, item.getItemNo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//���� ����
	
	
} //Ŭ����
