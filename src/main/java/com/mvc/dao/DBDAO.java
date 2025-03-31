package com.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDAO {
	
	private static Connection conn= null;

	private static final String dbDriver = "com.mysql.cj.jdbc.Driver";
	private static final String dbURL="jdbc:mysql://localhost:3306/luminar_jsp";
	private static final String userName= "root";
	private static final String passWord= "AdminAthi123";


	// --------------START----------database connection ------------
	/**
	 *
	 * @author: Athira
	 * @Date:
	 * @version : 1.0
	 * @purpose : database connection
	 * @param : Nothing
	 * @throws : Exception in case of missing driver class
	 * @return: void
	 */
	private DBDAO() {}

	public static Connection connect() throws ClassNotFoundException, SQLException {
		
		try {
			if(conn == null) {
				synchronized(DBDAO.class) {
					if(conn == null) {
						Class.forName(dbDriver);
						conn = DriverManager.getConnection(dbURL, userName, passWord);
					}
				}
			}
			
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		return conn;
	}
	// --------------END----------database connection ------------
	
	// --------------START----------close connection ------------

	/**
	 *
	 * @author : Athira
	 * @date :
	 * @version: 1.0
	 * @purpose: Close connection
	 * @param : Nothing
	 * @throws :Exception in case of closing connection
	 * @return : Nothing
	 */

	public static void dbClose() throws SQLException {
		conn.close();
	}

	// ------------------END-------------closing connection---------

}
