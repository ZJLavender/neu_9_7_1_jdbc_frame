package com.neu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static final String driver;
	private static final String url;
	private static final String user;
	private static final String pwd;
	/*
	 * 静态块，自在类加载的时候执行一次
	 */
	static{
		driver=ReadProperties.getInstance()
				.getProperty("driver");
		url=ReadProperties.getInstance()
				.getProperty("url");
		user=ReadProperties.getInstance()
				.getProperty("user");
		pwd=ReadProperties.getInstance()
				.getProperty("pwd");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 负责连接数据库
	 * @return 连接的对象
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		Connection conn=DriverManager
				.getConnection(url, user, pwd);
		
		return conn;
	}
	/**
	 * 关闭数据库资源，有小到大，由里到外
	 * @param conn
	 * @param stmt
	 * @param rst
	 */
	public static void close(
			Connection conn,
			Statement stmt,
			ResultSet rst){
		if(rst!=null){
			try {
				rst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				rst= null;
			}
		}
		if(stmt !=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				stmt=null;
			}
		}
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn=null;
			}
		}
	}
	
	
}






