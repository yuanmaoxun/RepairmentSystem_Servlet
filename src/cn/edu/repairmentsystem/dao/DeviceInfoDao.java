package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.DeviceInfo;
import cn.edu.repairmentsystem.javabean.RepairInfo;

public class DeviceInfoDao {
	//机器序列号信息查询
	public DeviceInfo querydev(DeviceInfo d){
		DeviceInfo dev=new DeviceInfo();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUTIL.getConnection();
		try {
			//where条件动态拼接
			StringBuilder sql=new StringBuilder();
			sql.append(" select * from device_info where dev_series=? ");
			
			st=con.prepareStatement(sql.toString());
			int index=1;
			
			if(!d.getDev_series().equals("")){
				//查询语句
				st.setString(index++, d.getDev_series());
			}
			rs=st.executeQuery();
			
			if(rs.next()){	
				dev.setDev_id(rs.getInt("dev_id"));
				dev.setDev_ptype(rs.getString("dev_ptype"));
				dev.setDev_brand(rs.getString("dev_brand"));
				dev.setDev_model(rs.getString("dev_model"));
				dev.setDev_series(rs.getString("dev_series"));
				dev.setDev_command(rs.getString("dev_command"));
				dev.setDev_hdd(rs.getString("dev_hdd"));
				dev.setDev_rom(rs.getString("dev_rom"));
				dev.setDev_pc(rs.getString("dev_pc"));
				dev.setDev_adapt(rs.getString("dev_adapt"));
				dev.setDev_battery(rs.getString("dev_battery"));
				dev.setDev_drive(rs.getString("dev_drive"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBUTIL.closeResource(rs, st, con);
		}
		
		return dev;
	}
	
	public boolean insertdev(DeviceInfo d){
		boolean result=true;
		Connection con=null;
		PreparedStatement st=null;
		con=DBUTIL.getConnection();
		try {
			int index=1;
			st=con.prepareStatement("insert into device_info values(0,?,?,?,?,?,?,?,?,?,?,?)");
			st.setString(index++, d.getDev_ptype());
			st.setString(index++, d.getDev_brand());
			st.setString(index++, d.getDev_model());
			st.setString(index++, d.getDev_series());
			st.setString(index++, d.getDev_command());
			st.setString(index++, d.getDev_hdd());
			st.setString(index++, d.getDev_rom());
			st.setString(index++, d.getDev_pc());
			st.setString(index++, d.getDev_adapt());
			st.setString(index++, d.getDev_battery());
			st.setString(index++, d.getDev_drive());
			
			st.executeUpdate();
			
		}catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		finally{
			DBUTIL.closeResource( st, con);
		}
		return result;
	}
	
	public boolean insertrep(RepairInfo r){
		boolean result=true;
		Connection con=null;
		PreparedStatement st=null;
		con=DBUTIL.getConnection();
		try {
			int index=1;
			st=con.prepareStatement("insert into repair_info values(0,?,?,?,?,?,?,?,?,?,?,?,?)");
			//当前时间
			java.sql.Date start = new java.sql.Date(System.currentTimeMillis());
			st.setDate(index++, start);
			//估价double
			st.setDouble(index++, r.getRep_estimate());
			//时间类型date
			java.sql.Date d=new java.sql.Date(r.getRep_end().getTime());
			st.setDate(index++, d);
			//报修状态
			st.setString(index++, r.getRep_condition());
			//缺少零件
		    st.setString(index++, r.getRep_spare());
			//故障现象
			st.setString(index++, r.getRep_app());
			//故障类型
			st.setString(index++, r.getRep_fault());
			//客户编号
			int cus=r.getCus_no();
			st.setInt(index++, cus);
			//设备id
			int dev=r.getDev_id();
			st.setInt(index++, dev);
			//检查
			st.setString(index++, r.getRep_check());
			st.setString(index++, r.getRep_others());
			st.setString(index++, r.getRep_data());			
			st.executeUpdate();
			
		}catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		finally{
			DBUTIL.closeResource( st, con);
		}
		return result;
	}
	
	public DeviceInfo querydevid(DeviceInfo d){
		DeviceInfo dev=new DeviceInfo();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUTIL.getConnection();
		try {
			//where条件动态拼接
			StringBuilder sql=new StringBuilder();
			sql.append(" select * from device_info where dev_series=? ");
			
			st=con.prepareStatement(sql.toString());
			int index=1;
			
			if(!d.getDev_series().equals("")){
				//查询语句
				st.setString(index++, d.getDev_series());
			}
			rs=st.executeQuery();
			
			if(rs.next()){	
				dev.setDev_id(rs.getInt("dev_id"));
				dev.setDev_ptype(rs.getString("dev_ptype"));
				dev.setDev_brand(rs.getString("dev_brand"));
				dev.setDev_model(rs.getString("dev_model"));
				dev.setDev_series(rs.getString("dev_series"));
				dev.setDev_command(rs.getString("dev_command"));
				dev.setDev_hdd(rs.getString("dev_hdd"));
				dev.setDev_rom(rs.getString("dev_rom"));
				dev.setDev_pc(rs.getString("dev_pc"));
				dev.setDev_adapt(rs.getString("dev_adapt"));
				dev.setDev_battery(rs.getString("dev_battery"));
				dev.setDev_drive(rs.getString("dev_drive"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBUTIL.closeResource(rs, st, con);
		}
		
		return dev;
	}
	
	public RepairInfo queryrepno(){
		RepairInfo rep=new RepairInfo();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUTIL.getConnection();
		try {
			//where条件动态拼接
			StringBuilder sql=new StringBuilder();
			sql.append(" select max(rep_no) as rep_no from repair_info");
			
			st=con.prepareStatement(sql.toString());
			rs=st.executeQuery();
			
			if(rs.next()){	
				rep.setRep_no(rs.getInt("rep_no"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBUTIL.closeResource(rs, st, con);
		}
		
		return rep;
	}
}