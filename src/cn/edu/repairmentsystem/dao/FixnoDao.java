package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.TransferInfo;

public class FixnoDao {
	//自动生成数据功能
	public boolean insertfixno(int repno){
		boolean result=true;
		Connection con=null;
		PreparedStatement st=null;
		con=DBUTIL.getConnection();
		try {
			int index=1;
			st=con.prepareStatement("insert into fix_record(fix_allocatetime,fix_no,rep_no,fix_condition) values(?,0,?,?)");
			
			//分配时间
			java.sql.Date allocatetime = new java.sql.Date(System.currentTimeMillis());
			st.setDate(index++, allocatetime);
			//报修单号
			st.setInt(index++, repno);
			st.setString(index++, "未分配");
			//提交
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
	
	//查询功能
//	public ArrayList<TransferInfo> querytra(){
//		
//		ArrayList<TransferInfo> result=new ArrayList<TransferInfo>();
//	
//		Connection con=null;
//		PreparedStatement st=null;
//		ResultSet rs=null;
//		
//		con=DBUtil.getConnection();
//		try {
//			//where条件动态拼接
//			StringBuilder sql=new StringBuilder();
//			sql.append(" select fix_record.fix_allocatetime as fix_allocatetime,fix_record.fix_no as fix_no,fix_condition as fix_condition,device_info.dev_brand as dev_brand,device_info.dev_model as dev_model,device_info.dev_ptype as dev_ptype "); 
//			sql.append(" from fix_record,device_info,repair_info  ");
//			sql.append(" where fix_record.rep_no=repair_info.rep_no  ");
//			sql.append(" and device_info.dev_id=repair_info.dev_id and fix_record.fix_condition='未分配' ");
//			
//			st=con.prepareStatement(sql.toString());
//			
//			rs=st.executeQuery();
//			
//			while(rs.next()){	
//				TransferInfo tra=new TransferInfo();
//				tra.setFix_allocatetime(rs.getDate("fix_allocatetime"));
//				tra.setFix_no(rs.getInt("fix_no"));
//				tra.setDev_ptype(rs.getString("dev_ptype"));
//				tra.setDev_brand(rs.getString("dev_brand"));
//				tra.setDev_model(rs.getString("dev_model"));
//				tra.setFix_condition(rs.getString("fix_condition"));
//				result.add(tra);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally{
//			DBUtil.closeResource(rs, st, con);
//		}
//		
//		return result;
//	}
	
	public ArrayList<TransferInfo> querytra(int f,int start,int size){
		ArrayList<TransferInfo> result=new ArrayList<TransferInfo>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUTIL.getConnection();
		try {
			//where条件动态拼接
			StringBuilder sql=new StringBuilder();
			sql.append(" select fix_record.fix_allocatetime as fix_allocatetime,fix_record.fix_no as fix_no,fix_condition as fix_condition,device_info.dev_brand as dev_brand,device_info.dev_model as dev_model,device_info.dev_ptype as dev_ptype "); 
			sql.append(" from fix_record,device_info,repair_info  ");
			sql.append(" where  fix_record.rep_no=repair_info.rep_no  ");
			sql.append(" and device_info.dev_id=repair_info.dev_id and fix_record.fix_condition='未分配' and 1=1 ");
			
			if(f!=-1){
				sql.append(" and fix_record.fix_no=? ");
			}
			
			sql.append(" limit ?,? ");
			
			int index=1;
			
			st=con.prepareStatement(sql.toString());
			if(f!=-1){
				st.setInt(index++, f);
			}
			st.setInt(index++, start);
			st.setInt(index++, size);
			
			rs=st.executeQuery();
			
			while(rs.next()){	
				TransferInfo tra=new TransferInfo();
				tra.setFix_allocatetime(rs.getDate("fix_allocatetime"));
				tra.setFix_no(rs.getInt("fix_no"));
				tra.setDev_ptype(rs.getString("dev_ptype"));
				tra.setDev_brand(rs.getString("dev_brand"));
				tra.setDev_model(rs.getString("dev_model"));
				tra.setFix_condition(rs.getString("fix_condition"));
				result.add(tra);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUTIL.closeResource(rs, st, con);
		}
		
		return result;
	}
	
	public int querytraTotalRows(int f){
		int result=0;
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUTIL.getConnection();
		try {
			StringBuilder sql=new StringBuilder();
		
			sql.append(" select count(*) from fix_record,device_info,repair_info  ");
			sql.append(" where fix_record.rep_no=repair_info.rep_no  ");
			sql.append(" and device_info.dev_id=repair_info.dev_id and fix_record.fix_condition='未分配' and 1=1 ");
			
			if(f!=-1){
				sql.append(" and fix_record.fix_no=? ");
			}
			
			int index=1;
			
			st=con.prepareStatement(sql.toString());
			if(f!=-1){
				st.setInt(index++, f);
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
