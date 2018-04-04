package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.RepairInfo;

public class RepairInfoDao {
	//报修编号信息查询
		public ArrayList<RepairInfo> queryrep(RepairInfo r,int start,int size){
			ArrayList<RepairInfo> result=new ArrayList<RepairInfo>();
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			
			con=DBUTIL.getConnection();
			try {
				//where条件动态拼接
				StringBuilder sql=new StringBuilder();
				sql.append("select repair_info.rep_no from repair_info,fix_record where repair_info.rep_no=fix_record.rep_no ");
				if(r.getRep_no()!=-1){
					sql.append(" and repair_info.rep_no=? ");
				}
				
				sql.append(" limit ?,? ");
				st=con.prepareStatement(sql.toString());
				int index=1;
				
				if(r.getRep_no()!=-1){
					
					st.setInt(index++,r.getRep_no());
				}
				st.setInt(index++, start);
				st.setInt(index++, size);
				
				rs=st.executeQuery();
				
				while(rs.next()){
					RepairInfo rep=new RepairInfo();
					rep.setRep_no(rs.getInt("rep_no"));				
					//返回结果集
					result.add(rep);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				DBUTIL.closeResource(rs, st, con);
			}
			
			return result;
		}
		
		public int queryrepTotalRows(RepairInfo r){
			int result=0;
			
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			
			con=DBUTIL.getConnection();
			try {
				StringBuilder sql=new StringBuilder();
				sql.append("select count(repair_info.rep_no) from repair_info,fix_record where repair_info.rep_no=fix_record.rep_no ");
				if(r.getRep_no()!=-1){
					sql.append(" and repair_info.rep_no = ? ");
				}
				//System.out.println(sql);
				st=con.prepareStatement(sql.toString());
				int index=1;
				
				if(r.getRep_no()!=-1){
					//模糊查询加通配符
					st.setInt(index++, r.getRep_no());
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
