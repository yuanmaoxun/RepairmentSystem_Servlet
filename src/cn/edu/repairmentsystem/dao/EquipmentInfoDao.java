package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.EquipmentInfo;

public class EquipmentInfoDao {
	
	//添加设备信息
	public boolean addEquipmentInfo(EquipmentInfo equip) {
		
		boolean result = true;
		
		Connection con = null;
		PreparedStatement st =null;
		
		con = DBUTIL.getConnection();
		
		try {
			st = con.prepareStatement("insert into equipment_info(equ_name,equ_model,equ_cost,equ_alternum,equ_num,equ_condition) values(?,?,?,?,?,?)");
			
			st.setString(1, equip.getEqu_name());
			st.setString(2, equip.getEqu_model());
			st.setDouble(3, equip.getEqu_cost());
			st.setInt(4,equip.getEqu_alternum());
			st.setInt(5,equip.getEqu_num());
			st.setString(6,equip.getEqu_condition());
			
			int res = st.executeUpdate();
			if(res<1){
				result = false;
			}
			
		} catch (SQLException e) {
			
			result = false;
			
			e.printStackTrace();
		}
		finally {
			DBUTIL.closeResource(st, con);
		}
		return result;
	}
	
	//查询所有设备名称
	public ArrayList<EquipmentInfo> queryEquname() {
		
		ArrayList<EquipmentInfo> result = new ArrayList<EquipmentInfo>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con = DBUTIL.getConnection();
		
		try {
			
			st = con.prepareStatement(" select distinct(equ_name) from equipment_info ");
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				EquipmentInfo equ = new EquipmentInfo();
				equ.setEqu_name(rs.getString("equ_name"));
				result.add(equ);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			DBUTIL.closeResource(rs, st, con);
		}
		return result;
	}
	
	//查询备件ID
	public int queryEquid(String equname, String equmodel) {
		int result = 0;
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		con = DBUTIL.getConnection();
		try {
			st = con.prepareStatement( "select equ_id from equipment_info where equ_name = ? and equ_model = ? " );
			st.setString(1, equname);
			st.setString(2, equmodel);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("equ_id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUTIL.closeResource(rs, st, con);
		}
		//System.out.println(result);
		return result;
	}
	
	//修改备件数量
	public void updateEqunum(int num,int id) {
		
		Connection con = null;
		PreparedStatement st =null;
		ResultSet rs = null;
		
		con = DBUTIL.getConnection();
		
		try {
			st = con.prepareStatement(" update equipment_info set equ_num =equ_num+? where equ_id =?");
			st.setInt(1, num);
			st.setInt(2, id);
			
			st.executeUpdate();
			
			st = con.prepareStatement(" select equ_num,equ_alternum from equipment_info where equ_id = ?");
			st.setInt(1, num);
			rs = st.executeQuery();
			
			int equnum = 0;
			int equalternum = 0;
			String condition = null;
			while(rs.next()) {
				equnum = rs.getInt("equ_num");
				equalternum = rs.getInt("equ_alternum");
			}
			if(equnum > equalternum) {
				condition = "正常";
			}
			else if(equnum == equalternum) {
				condition = "临界";
			}
			else if(equnum < equalternum && equnum > 0) {
				condition = "警戒";
			}
			else if(equnum == 0) {
				condition = "缺货";
			}
			st = con.prepareStatement(" update equipment_info set equ_condition =? where equ_id =?");
			st.setString(1, condition);
			st.setInt(2, id);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUTIL.closeResource(rs,st, con);
		}
	}
	//查询一共多少行
public int queryUserTotalRows(EquipmentInfo equip){
		
		int result = 0;
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con = DBUTIL.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			//要有好习惯写列名 append追加
			sql.append(" select count(*) from equipment_info where 1=1 ");
			if(!equip.getEqu_name().equals("")) {
				sql.append(" and equ_name = ? ");
			}
			if(!equip.getEqu_model().equals("")) {
				//用lke更好
				sql.append(" and equ_model like ?");
			}
			if(!equip.getEqu_condition().equals("请选择")) {
				sql.append(" and equ_condition = ? ");
			}
			
			st = con.prepareStatement(sql.toString());
			int index = 1;
			
			if(!equip.getEqu_name().equals("")) {
				st.setString(index++, equip.getEqu_name());
			}
			if(!equip.getEqu_model().equals("")) {
				st.setString(index++, "%"+equip.getEqu_model()+"%");
			}
			if(!equip.getEqu_condition().equals("请选择")) {
				st.setString(index++, equip.getEqu_condition());
			}
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			
			DBUTIL.closeResource(rs, st, con);
		}
		return result; 
	}
	//对于select需要用集合存数据 
	//将数据封装到javabean中 在将Javabean放入集合中
	public ArrayList<EquipmentInfo> queryUser(EquipmentInfo equip,int start,int size){
		
		ArrayList<EquipmentInfo> result = new ArrayList<EquipmentInfo>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con = DBUTIL.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			//要有好习惯写列名 append追加
			sql.append(" select * from equipment_info where 1=1 ");
			if(!equip.getEqu_name().equals("")) {
				sql.append(" and equ_name = ? ");
			}
			if(!equip.getEqu_model().equals("")) {
				//用lke更好
				sql.append(" and equ_model like ?");
			}
			if(!equip.getEqu_condition().equals("请选择")) {
				sql.append(" and equ_condition = ? ");
			}
			sql.append(" limit ?,?");
			
			st = con.prepareStatement(sql.toString());
			int index = 1;
			
			if(!equip.getEqu_name().equals("")) {
				st.setString(index++, equip.getEqu_name());
			}
			if(!equip.getEqu_model().equals("")) {
				st.setString(index++, "%"+equip.getEqu_model()+"%");
			}
			if(!equip.getEqu_condition().equals("请选择")) {
				st.setString(index++, equip.getEqu_condition());
			}
			st.setInt(index++, start);
			st.setInt(index++, size);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				EquipmentInfo e = new EquipmentInfo();
				e.setEqu_id(rs.getInt("equ_id"));
				e.setEqu_name(rs.getString("equ_name"));
				e.setEqu_model(rs.getString("equ_model"));
				e.setEqu_cost(rs.getDouble("equ_cost"));
				e.setEqu_num(rs.getInt("equ_num"));
				e.setEqu_alternum(rs.getInt("equ_alternum"));
				e.setEqu_condition(rs.getString("equ_condition"));
				result.add(e);
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
	
	
	//更新备件信息表
	public boolean updateStorage(EquipmentInfo equip) {
		boolean result = true;
		
		Connection con = null;
		PreparedStatement st =null;
		
		con = DBUTIL.getConnection();
		
		try {
			
			st = con.prepareStatement(" update equipment_info set equ_name = ?,equ_model=?,equ_cost=?,equ_num=?,equ_alternum=?,equ_condition=? where equ_id = ? ");
			
			st.setString(1, equip.getEqu_name());
			st.setString(2, equip.getEqu_model());
			st.setDouble(3, equip.getEqu_cost());
			st.setInt(4, equip.getEqu_num());
			st.setInt(5, equip.getEqu_alternum());
			int num = equip.getEqu_num();
			int alternum = equip.getEqu_alternum();
			String condition = null;
			if(num > alternum) {
				condition = "正常";
			}
			else if(num == alternum) {
				condition = "临界";
			}
			else if(num < alternum && num > 0) {
				condition = "警戒";
			}
			else if(num == 0) {
				condition = "缺货";
			}
			st.setString(6,condition);
			st.setInt(7, equip.getEqu_id());
			int rs= st.executeUpdate();
			
			if(rs<1)
				result = false;
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		finally {
			
			DBUTIL.closeResource( st, con);
		}
		return result;
	}
	//查询要修改的备件信息
public EquipmentInfo queryStorage(EquipmentInfo equip) {
		
	EquipmentInfo e = new EquipmentInfo();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con = DBUTIL.getConnection();
		
		try {
			
			st = con.prepareStatement(" select * from equipment_info where equ_id = ? ");
			
			st.setInt(1, equip.getEqu_id());
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				e.setEqu_id(rs.getInt("equ_id"));
				e.setEqu_name(rs.getString("equ_name"));
				e.setEqu_model(rs.getString("equ_model"));
				e.setEqu_cost(rs.getDouble("equ_cost"));
				e.setEqu_num(rs.getInt("equ_num"));
				e.setEqu_alternum(rs.getInt("equ_alternum"));
				e.setEqu_condition(rs.getString("equ_condition"));
			
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			
			DBUTIL.closeResource(rs, st, con);
		}
		return e;
	}
	
}
