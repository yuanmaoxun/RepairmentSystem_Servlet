package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.TablesInfo;

public class TablesInfoDao {
	
	//查询维修信息实现分页
public ArrayList<TablesInfo> queryUser(TablesInfo tables,int start,int size){
		
		ArrayList<TablesInfo> result = new ArrayList<TablesInfo>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con = DBUTIL.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			//要有好习惯写列名 append追加
			sql.append(" select f.fix_no, a.adm_name, dev_ptype,dev_brand,dev_model,f.fix_allocatetime,f.fix_money,f.fix_material from fix_record f,device_info d, admin_info a,repair_info r where fix_condition ='已维修' and f.fix_staffno = a.adm_no and f.rep_no = r.rep_no and d.dev_id = r.dev_id and 1=1 ");
			if(tables.getFix_no() != -1) {
				sql.append(" and f.fix_no = ? ");
			}
			if(!tables.getAdm_name().equals("")) {
				//用lke更好
				sql.append(" and a.adm_name like ?");
			}
			if(tables.getFix_allocatetime()!=null) {
				sql.append(" and f.fix_allocatetime = ? ");
			}
			sql.append(" limit ?,?");
			
			st = con.prepareStatement(sql.toString());
			int index = 1;
			
			if(tables.getFix_no() != -1) {
				st.setInt(index++, tables.getFix_no());
			}
			if(!tables.getAdm_name().equals("")) {
				st.setString(index++, "%"+tables.getAdm_name()+"%");
			}
			if(tables.getFix_allocatetime()!=null) {
				java.sql.Date date = new java.sql.Date(tables.getFix_allocatetime().getTime());
				st.setDate(index++, date);
			}
			st.setInt(index++, start);
			st.setInt(index++, size);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				TablesInfo t = new TablesInfo();
				t.setFix_no(rs.getInt("fix_no"));
				t.setFix_allocatetime(rs.getDate("fix_allocatetime"));
				t.setDev_ptype(rs.getString("dev_ptype"));
				t.setDev_brand(rs.getString("dev_brand"));
				t.setDev_model(rs.getString("dev_model"));
				t.setAdm_name(rs.getString("adm_name"));
				t.setFix_money(rs.getDouble("fix_money"));
				t.setFix_material(rs.getDouble("fix_material"));
				result.add(t);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			DBUTIL.closeResource(rs, st, con);
		}
		
		return result; 
	}
	//查询一共多少行 实现分页
	public int queryUserTotalRows(TablesInfo tables) {

		int result = 0;
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con = DBUTIL.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			//要有好习惯写列名 append追加
			sql.append(" select count(*) from fix_record f,device_info d, admin_info a,repair_info r where fix_condition ='已维修' and f.fix_staffno = a.adm_no and f.rep_no = r.rep_no and d.dev_id = r.dev_id and 1=1 ");
			if(tables.getFix_no() != -1) {
				sql.append(" and f.fix_no = ? ");
			}
			if(!tables.getAdm_name().equals("")) {
				//用lke更好
				sql.append(" and a.adm_name like ?");
			}
			if(tables.getFix_allocatetime()!=null) {
				sql.append(" and f.fix_allocatetime = ? ");
			}
			
			st = con.prepareStatement(sql.toString());
			int index = 1;
			
			if(tables.getFix_no() != -1) {
				st.setInt(index++, tables.getFix_no());
			}
			if(!tables.getAdm_name().equals("")) {
				st.setString(index++, "%"+tables.getAdm_name()+"%");
			}
			if(tables.getFix_allocatetime()!=null) {
				java.sql.Date date = new java.sql.Date(tables.getFix_allocatetime().getTime());
				st.setDate(index++, date);
			}
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			DBUTIL.closeResource(rs, st, con);
		}
		
		return result; 
	}
	
	//查询产品相关信息
	public TablesInfo queryMessage (int fixno) {
		TablesInfo tables = new TablesInfo();
		Connection con = null;
		PreparedStatement st =null;
		ResultSet rs =null;
		
		con = DBUTIL.getConnection();
		
		try {
			st = con.prepareStatement(" select d.* from fix_record f,device_info d, admin_info a,repair_info r where f.fix_staffno = a.adm_no and f.rep_no = r.rep_no and d.dev_id = r.dev_id and f.fix_no =? ");
			
			st.setInt(1, fixno);
			rs = st.executeQuery();
			
			while(rs.next()) {
				tables.setDev_ptype(rs.getString("dev_ptype"));
				tables.setDev_brand(rs.getString("dev_brand"));
				tables.setDev_model(rs.getString("dev_model"));
				tables.setDev_series(rs.getString("dev_series"));
				tables.setDev_command(rs.getString("dev_command"));
				tables.setDev_hdd(rs.getString("dev_hdd"));
				tables.setDev_rom(rs.getString("dev_rom"));
				tables.setDev_pc(rs.getString("dev_pc"));
				tables.setDev_adapt(rs.getString("dev_adapt"));
				tables.setDev_battery(rs.getString("dev_battery"));
				tables.setDev_drive(rs.getString("dev_drive"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUTIL.closeResource(rs, st, con);
		}
		return tables;
	}
	
	//查询打印信息
	public TablesInfo queryPrint(int num)  {
		
		TablesInfo tables = new TablesInfo();
		Connection con = null;
		PreparedStatement st =null;
		ResultSet rs =null;
		
		con = DBUTIL.getConnection();
		
		try {
			st = con.prepareStatement(" select  f.fix_money,f.fix_material,f.fix_no, a.adm_name,f.fix_allocatetime,dev_ptype,dev_brand,dev_model,c.cus_contact, c.cus_pro, c.cus_mobile, c.cus_id from customer_info c ,fix_record f,device_info d, admin_info a,repair_info r where f.fix_staffno = a.adm_no and f.rep_no = r.rep_no and d.dev_id = r.dev_id and c.cus_no=r.cus_no and f.fix_no =? ");
			
			st.setInt(1, num);
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				tables.setFix_no(rs.getInt("fix_no"));
				tables.setFix_allocatetime(rs.getDate("fix_allocatetime"));
				tables.setDev_ptype(rs.getString("dev_ptype"));
				tables.setDev_brand(rs.getString("dev_brand"));
				tables.setDev_model(rs.getString("dev_model"));
				tables.setFix_money(rs.getDouble("fix_money"));
				tables.setFix_material(rs.getDouble("fix_material"));
				tables.setAdm_name(rs.getString("adm_name"));
				tables.setCus_contact(rs.getString("cus_contact"));
				tables.setCus_pro(rs.getString("cus_pro"));
				tables.setCus_mobile(rs.getString("cus_mobile"));
				tables.setCus_id(rs.getString("cus_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUTIL.closeResource(rs, st, con);
		}
		return tables;
	}
	
	//查询结算信息实现分页
	public ArrayList<TablesInfo> queryAccount(TablesInfo tables,int start,int size){
			
			ArrayList<TablesInfo> result = new ArrayList<TablesInfo>();
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			
			con = DBUTIL.getConnection();
			
			try {
				StringBuilder sql = new StringBuilder();
				//要有好习惯写列名 append追加
				sql.append(" select i.acc_no,f.fix_allocatetime,f.fix_no,a.adm_name, acc_cal, acc_condition from fix_record f,device_info d, admin_info a,repair_info r, account_info i where i.fix_no=f.fix_no and f.fix_staffno = a.adm_no and f.rep_no = r.rep_no and d.dev_id = r.dev_id and 1=1 ");
				if(tables.getAcc_no() != -1) {
					sql.append(" and i.acc_no = ? ");
				}
				if(!tables.getAcc_condition().equals("请选择")) {
					sql.append(" and acc_condition =?");
				}
				if(tables.getFix_allocatetime()!=null) {
					sql.append(" and f.fix_allocatetime = ? ");
				}
				sql.append(" limit ?,?");
				
				st = con.prepareStatement(sql.toString());
				int index = 1;
				
				if(tables.getAcc_no() != -1) {
					st.setInt(index++, tables.getAcc_no());
				}
				if(!tables.getAcc_condition().equals("请选择")) {
					st.setString(index++, tables.getAcc_condition());
				}
				if(tables.getFix_allocatetime()!=null) {
					java.sql.Date date = new java.sql.Date(tables.getFix_allocatetime().getTime());
					st.setDate(index++, date);
				}
				st.setInt(index++, start);
				st.setInt(index++, size);
				
				rs = st.executeQuery();
				
				while(rs.next()) {
					TablesInfo t = new TablesInfo();
					t.setAcc_no(rs.getInt("acc_no"));
					t.setFix_allocatetime(rs.getDate("fix_allocatetime"));
					t.setFix_no(rs.getInt("fix_no"));
					t.setAdm_name(rs.getString("adm_name"));
					t.setAcc_cal(rs.getDouble("acc_cal"));
					t.setAcc_condition(rs.getString("acc_condition"));
					result.add(t);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				
				DBUTIL.closeResource(rs, st, con);
			}
			
			return result; 
		}
	
		//查询结算信息一共多少行 实现分页
		public int queryAccountTotalRows(TablesInfo tables) {

			int result = 0;
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			
			con = DBUTIL.getConnection();
			
			try {
				StringBuilder sql = new StringBuilder();
				//要有好习惯写列名 append追加
				sql.append(" select count(*) from fix_record f,device_info d, admin_info a,repair_info r, account_info i where i.fix_no=f.fix_no and f.fix_staffno = a.adm_no and f.rep_no = r.rep_no and d.dev_id = r.dev_id and 1=1 ");
				if(tables.getAcc_no() != -1) {
					sql.append(" and i.acc_no = ? ");
				}
				if(!tables.getAcc_condition().equals("请选择")) {
					sql.append(" and acc_condition =?");
				}
				if(tables.getFix_allocatetime()!=null) {
					sql.append(" and f.fix_allocatetime = ? ");
				}
				
				st = con.prepareStatement(sql.toString());
				int index = 1;
				
				if(tables.getAcc_no() != -1) {
					st.setInt(index++, tables.getAcc_no());
				}
				if(!tables.getAcc_condition().equals("请选择")) {
					st.setString(index++, tables.getAcc_condition());
				}
				if(tables.getFix_allocatetime()!=null) {
					java.sql.Date date = new java.sql.Date(tables.getFix_allocatetime().getTime());
					st.setDate(index++, date);
				}
				
				rs = st.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				
				DBUTIL.closeResource(rs, st, con);
			}
			
			return result; 
		}
}
