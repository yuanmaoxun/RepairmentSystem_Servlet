package cn.edu.repairmentsystem.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUTIL {
	
	private static String driverClass = null;
	private static String dbURL = null;
	private static String userName = null;
	private static String userPwd = null;
	
	static {
		//��ȡ�����ļ�
		Properties p = new Properties();
		try {
			p.load(DBUTIL.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driverClass = p.getProperty("driver");
		dbURL = p.getProperty("url");
		userName = p.getProperty("username");
		userPwd = p.getProperty("password");
		
		//������������
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ȡ���ݿ����ӵķ���
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(dbURL,userName,userPwd);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	//�ͷ���Դ
	public static void closeResource(ResultSet rs,Statement st,Connection con) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeResource(Statement st,Connection con) {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
