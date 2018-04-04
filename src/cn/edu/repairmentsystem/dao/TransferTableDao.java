package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.AdminInfo;

public class TransferTableDao {
	public boolean insertfix(int admno,int repno){
		boolean result=true;
		Connection con=null;
		PreparedStatement st=null;
		con=DBUTIL.getConnection();
		try {
			int index=1;
			st=con.prepareStatement("insert into fix_record(fix_no,fix_allocatetime,fix_staffno,rep_no) values(0,?,?,?)");
			
			//分配时间
			java.sql.Date allocatetime = new java.sql.Date(System.currentTimeMillis());
			st.setDate(index++, allocatetime);
			
			//人工号
			st.setInt(index++, admno);
			//报修单号
			st.setInt(index++, repno);
			
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
	
	public ArrayList<AdminInfo> querytra(int r, int start, int size) {
		ArrayList<AdminInfo> result = new ArrayList<AdminInfo>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		con = DBUTIL.getConnection();
		try {
			// where条件动态拼接
			StringBuilder sql = new StringBuilder();
			sql.append(" select admin_info.adm_no as adm_no,admin_info.adm_name as adm_name from admin_info,fix_record where admin_info.adm_no=fix_record.fix_staffno and fix_record.rep_no=? ");

			sql.append(" limit ?,? ");
			st = con.prepareStatement(sql.toString());
			int index = 1;

			if (r!=0) {

				st.setInt(index++, r);
			}
			st.setInt(index++, start);
			st.setInt(index++, size);

			rs = st.executeQuery();

			while (rs.next()) {
				AdminInfo adm = new AdminInfo();
				adm.setAdm_no(rs.getInt("adm_no"));
				adm.setAdm_name(rs.getString("adm_name"));
				// 返回结果集
				result.add(adm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTIL.closeResource(rs, st, con);
		}

		return result;
	}

	public int querytraTotalRows(int r) {
		int result = 0;

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		con = DBUTIL.getConnection();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" select count(*) where admin_info.adm_no=fix_record.fix_staffno and fix_record.rep_no=? ");
			// System.out.println(sql);
			st = con.prepareStatement(sql.toString());
			int index = 1;

			if (r!=0) {
				// 模糊查询加通配符
				st.setInt(index++, r);
				// System.out.println("sos");
			}
			// System.out.println(sql);
			rs = st.executeQuery();
			if (rs.next()) {
				// 从第一列取数据
				result = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTIL.closeResource(rs, st, con);
		}

		return result;
	}
}
