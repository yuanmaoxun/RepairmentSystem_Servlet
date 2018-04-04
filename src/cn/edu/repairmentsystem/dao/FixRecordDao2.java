package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.FixRecord;


public class FixRecordDao2 {
		//查询维修信息实现分页
		public ArrayList<FixRecord> queryFix(FixRecord fix,int start,int size){
				
				ArrayList<FixRecord> result = new ArrayList<FixRecord>();
				Connection con=null;
				PreparedStatement st=null;
				ResultSet rs=null;
				
				con = DBUTIL.getConnection();
				
				try {
					StringBuilder sql = new StringBuilder();
					//要有好习惯写列名 append追加
					sql.append(" select rep_no,fix_no,fix_allocatetime,fix_condition,fix_staffno from fix_record where 1=1 ");
					if(fix.getFix_staffno() != -1) {
						sql.append(" and fix_staffno = ? ");
					}
					if(!fix.getFix_condition().equals("请选择")) {
						sql.append(" and fix_condition =?");
					}
					if(fix.getFix_allocatetime()!=null) {
						sql.append(" and f.fix_allocatetime = ? ");
					}
					sql.append(" limit ?,?");
					
					st = con.prepareStatement(sql.toString());
					int index = 1;
					
					if(fix.getFix_staffno() != -1) {
						st.setInt(index++, fix.getFix_staffno());
					}
					if(!fix.getFix_condition().equals("请选择")) {
						st.setString(index++, fix.getFix_condition());
					}
					if(fix.getFix_allocatetime()!=null) {
						java.sql.Date date = new java.sql.Date(fix.getFix_allocatetime().getTime());
						st.setDate(index++, date);
					}
					st.setInt(index++, start);
					st.setInt(index++, size);
					
					rs = st.executeQuery();
					
					while(rs.next()) {
						FixRecord f = new FixRecord();
						f.setFix_no(rs.getInt("fix_no"));
						f.setRep_no(rs.getInt("rep_no"));
						f.setFix_allocatetime(rs.getDate("fix_allocatetime"));
						f.setFix_staffno(rs.getInt("fix_staffno"));
						f.setFix_condition(rs.getString("fix_condition"));
						result.add(f);
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
		//查询维修信息一共多少行 实现分页
		public int queryFixTotalRows(FixRecord fix){
			
			int result = 0;
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			
			con = DBUTIL.getConnection();
			
			try {
				StringBuilder sql = new StringBuilder();
				//要有好习惯写列名 append追加
				sql.append(" select count(*) from fix_record where 1=1 ");
				if(fix.getFix_staffno() != -1) {
					sql.append(" and fix_staffno = ? ");
				}
				if(!fix.getFix_condition().equals("请选择")) {
					sql.append(" and fix_condition =?");
				}
				if(fix.getFix_allocatetime()!=null) {
					sql.append(" and f.fix_allocatetime = ? ");
				}
				
				st = con.prepareStatement(sql.toString());
				int index = 1;
				
				if(fix.getFix_staffno() != -1) {
					st.setInt(index++, fix.getFix_staffno());
				}
				if(!fix.getFix_condition().equals("请选择")) {
					st.setString(index++, fix.getFix_condition());
				}
				if(fix.getFix_allocatetime()!=null) {
					java.sql.Date date = new java.sql.Date(fix.getFix_allocatetime().getTime());
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
		//查询维修单号，报修单号，分配时间
		public FixRecord queryMessage (int fixno) {
			FixRecord fix = new FixRecord();
			Connection con = null;
			PreparedStatement st =null;
			ResultSet rs =null;
			
			con = DBUTIL.getConnection();
			
			try {
				st = con.prepareStatement(" select fix_staffno,fix_no,rep_no,fix_allocatetime from fix_record where fix_no = ? ");
				
				st.setInt(1, fixno);
				rs = st.executeQuery();
				
				while(rs.next()) {
					fix.setFix_no(rs.getInt("fix_no"));
					fix.setFix_allocatetime(rs.getDate("fix_allocatetime"));
					fix.setRep_no(rs.getInt("rep_no"));
					fix.setFix_staffno(rs.getInt("fix_staffno"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				DBUTIL.closeResource(rs, st, con);
			}
			return fix;
		}
		
		//添加维修记录
		public boolean addFixRecord(FixRecord fix) {
			
			boolean result = true;
			
			Connection con = null;
			PreparedStatement st =null;
			
			con = DBUTIL.getConnection();
			int num = fix.getFix_no();
			
			try {
				st = con.prepareStatement(" update fix_record set fix_check=?,fix_fix=?,fix_checktime=?,fix_quantity=?,fix_money=?,fix_material=?,fix_attention=?,fix_condition=?,fix_level=? where fix_no=? ");
				
				st.setString(1, fix.getFix_check());
				st.setString(2, fix.getFix_fix());
				java.sql.Date date = new java.sql.Date(fix.getFix_checktime().getTime());
				st.setDate(3, date);
				st.setString(4, fix.getFix_quantity());
				st.setDouble(5, fix.getFix_money());
				st.setDouble(6, fix.getFix_material());
				st.setString(7, fix.getFix_attention());
				st.setString(8, fix.getFix_condition());
				st.setString(9, fix.getFix_level());
				st.setInt(10, num);
				
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
}
