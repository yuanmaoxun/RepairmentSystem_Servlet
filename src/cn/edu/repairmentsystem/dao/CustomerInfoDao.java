package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.repairmentsystem.javabean.CustomerInfo;

import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.CustomerInfo;

public class CustomerInfoDao {
	
	public boolean addCustomerInfo(CustomerInfo cus)
	{
		boolean result=true;
		
		Connection con=null;
		PreparedStatement st=null;
		
		con=DBUTIL.getConnection();
		
		try {
			
			st=con.prepareStatement
					(" insert into customer_info(cus_no,cus_id,cus_pro,cus_unit,cus_phone,cus_mobile,cus_addr,cus_code,cus_contact,cus_email) values (?,?,?,?,?,?,?,?,?,?)");
			st.setInt(1, cus.getCus_no());
			st.setString(2, cus.getCus_id());
			st.setString(3, cus.getCus_pro());
			st.setString(4, cus.getCus_unit());
			st.setString(5, cus.getCus_phone());
			st.setString(6, cus.getCus_mobile());
			st.setString(7, cus.getCus_addr());
			st.setString(8, cus.getCus_code());
			st.setString(9, cus.getCus_contact());
			st.setString(10, cus.getCus_email());

			
			int i=st.executeUpdate();
			if (i<1)
			{
				result=false;
			}
			
			
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
				
		return result;
	}
	
	public ArrayList<CustomerInfo> queryUser(CustomerInfo u)
	{
		
		ArrayList<CustomerInfo> result=new ArrayList<CustomerInfo>();
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUTIL.getConnection();
		try {
			
			StringBuilder sql=new StringBuilder();
			sql.append(" select * from customer_info where 1=1 ");//加上1=1这一个条件进行判断后动态链接
			
			if (!u.getCus_id().equals(""))
			{
				sql.append(" and cus_id= ? ");
			}
			
			
			
			st=con.prepareStatement(sql.toString());
			
			int index=1;
			
			if (!u.getCus_id().equals(""))
			{
				st.setString(index++, u.getCus_id());
			}
			
			
			
			rs=st.executeQuery();
			
			while (rs.next())
			{
				CustomerInfo cus=new CustomerInfo();
				cus.setCus_no(rs.getInt("cus_no"));
				cus.setCus_id(rs.getString("cus_id"));
				cus.setCus_pro(rs.getString("cus_pro"));
				cus.setCus_mobile(rs.getString("cus_mobile"));
				cus.setCus_contact(rs.getString("cus_contact"));
				
				result.add(cus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			DBUTIL.closeResource(rs, st, con);
		}
		return result;
	}
	
	
	public int  queryUserTotalRows(CustomerInfo u)
	{
		
		int  result=0;
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUTIL.getConnection();
		try {
			
			StringBuilder sql=new StringBuilder();
			sql.append(" select count(*) from customer_info where 1=1 ");
			
			if (!u.getCus_id().equals(""))
			{
				sql.append(" and cus_id= ? ");
			}
			
			
			
			st=con.prepareStatement(sql.toString());
			
			int index=1;
			
			if (!u.getCus_id().equals(""))
			{
				st.setString(index++, u.getCus_id());
			}
			
			
			
			rs=st.executeQuery();
			
			if (rs.next())
			{
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			DBUTIL.closeResource(rs, st, con);
		}
		return result;
	}
	//客户信息查询
		public ArrayList<CustomerInfo> querycus(CustomerInfo c,int start,int size){
			ArrayList<CustomerInfo> result=new ArrayList<CustomerInfo>();
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			
			con=DBUTIL.getConnection();
			try {
				//where条件动态拼接
				StringBuilder sql=new StringBuilder();
				sql.append(" select * from customer_info where 1=1 ");
				if(!c.getCus_contact().equals("")){
					sql.append(" and cus_contact like ?");
				}
				
				sql.append(" limit ?,? ");
				
				st=con.prepareStatement(sql.toString());
				int index=1;
				
				if(!c.getCus_contact().equals("")){
					//模糊查询加通配符
					st.setString(index++, "%"+c.getCus_contact()+"%");
				}
				st.setInt(index++, start);
				st.setInt(index++, size);
				rs=st.executeQuery();
				
				while(rs.next()){
					CustomerInfo cus=new CustomerInfo();
					cus.setCus_no(rs.getInt("cus_no"));
					cus.setCus_contact(rs.getString("cus_contact"));
					String cardid=rs.getString("cus_id");
				
					cus.setCus_id(cardid.substring(0,6)+"********"+cardid.substring(14));
					cus.setCus_pro(rs.getString("cus_pro"));
					cus.setCus_mobile(rs.getString("cus_mobile"));				
					//返回结果集
					result.add(cus);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				DBUTIL.closeResource(rs, st, con);
			}
			
			return result;
		}
		
		public int querycusTotalRows(CustomerInfo c){
			int result=0;
			
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			
			con=DBUTIL.getConnection();
			try {
				StringBuilder sql=new StringBuilder();
				sql.append(" select count(*) from customer_info where 1=1 ");
				if(!c.getCus_contact().equals("")){
					sql.append(" and cus_contact like ? ");
				}
				//System.out.println(sql);
				st=con.prepareStatement(sql.toString());
				int index=1;
				
				if(!c.getCus_contact().equals("")){
					//模糊查询加通配符
					st.setString(index++, "%"+c.getCus_contact()+"%");
					//System.out.println("sos");
				}
				//System.out.println(sql);
				rs=st.executeQuery();
				if(rs.next()){
					//从第一列取数据
					result=rs.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				DBUTIL.closeResource(rs, st, con);
			}
			
			return result;
		}
}
