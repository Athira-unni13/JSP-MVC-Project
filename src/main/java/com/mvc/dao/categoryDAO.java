package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mvc.beans.categoryBean;

public class categoryDAO {
	/*
	 * @author : Athira Unnikrishnan
	 * 
	 * @date : 25/3/2025
	 * 
	 * @version : 1.0
	 * 
	 * @purpose : dao class for categoryBean
	 */

	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	static boolean flag = false;

	// --------------START------get connection---------------
	/*
	 * 
	 * 
	 */
//	public static Connection getDbConnection() throws SQLException {
//
//		try {
//			DBDAO.connect();
//			con = DBDAO.getDbCon();
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return con;
//	}

	// ------------------END-------------database connection---------

	// --------------START------insert details-------------------------

	public static boolean insertCategory(categoryBean categoryBean) throws SQLException {

		try {
			con = DBDAO.connect();
			pst = con.prepareStatement("insert into category(ca_name,ca_price)values(?,?)");
			pst.setString(1, categoryBean.getCaName());
			pst.setFloat(2, categoryBean.getPrice());
			pst.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	// --------------END------insert details-------------------------

	// --------------START-------------------getAllCategories----------------------------------------

	public static ArrayList<categoryBean> getAllCategories() throws SQLException,ClassNotFoundException {

		ArrayList<categoryBean> categorBeanList = new ArrayList<categoryBean>();
		con = DBDAO.connect();

		try {

			pst = con.prepareStatement("SELECT * FROM category");
			rs = pst.executeQuery();

			while (rs.next()) {
				categoryBean category = new categoryBean();
				category.setCaId(rs.getInt(1));
				category.setCaName(rs.getString(2));
				category.setPrice(rs.getFloat(3));
				categorBeanList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorBeanList;
	}

	// --------------END-----------------------------------------------
	// ---------------------------------fetchCategoryById--------------------------------------
	public static ArrayList<categoryBean> fetchCategoryById(categoryBean categoryBean) throws SQLException,ClassNotFoundException {
		ArrayList<categoryBean> categoryBeanList = new ArrayList<categoryBean>();

		con = DBDAO.connect();

		try {
			pst = con.prepareStatement("SELECT * FROM category where ca_id=? ");

			pst.setInt(1, categoryBean.getCaId());
			rs = pst.executeQuery();
			while (rs.next()) {
				categoryBean cat = new categoryBean();
				cat.setCaId(rs.getInt(1));
				cat.setCaName(rs.getString(2));
				cat.setPrice(rs.getFloat(3));

				categoryBeanList.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryBeanList;
	}
	// --------------END-------------------------------------------------------------
	// --------------START----------------------------------------------------------------

	public static boolean updateCategory(categoryBean categoryBean) throws Exception {
		con = DBDAO.connect();
		flag = false;
		try {
			pst = con.prepareStatement("update category set ca_name=?,ca_price=? where ca_id =?");
			pst.setString(1, categoryBean.getCaName());
			pst.setFloat(2, categoryBean.getPrice());
			pst.setInt(3, categoryBean.getCaId());
			pst.executeUpdate();
			flag = true;
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		return flag;
	}
	// ---------------------------------------end-------------------------------
	// ---------------------------------------START-------------------------------

	public static boolean deleteCategory(categoryBean categoryBean) throws Exception {
		con = DBDAO.connect();
		flag = false;
		try {
			// pst = con.prepareStatement("delete from category where ca_id =?");

			// pst.setInt(1, categoryBean.getCaId());

			pst = con.prepareStatement("delete from category where ca_id =" + categoryBean.getCaId() + "");

			pst.executeUpdate();
			flag = true;
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		return flag;
	}
	// ---------------------------------------end-------------------------------
}
