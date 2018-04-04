package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.AdminInfo;
import cn.edu.repairmentsystem.javabean.DeviceInfo;
import cn.edu.repairmentsystem.javabean.RepairInfo;

public class RepInfoDao {
	// ���ޱ����Ϣ��ѯ
	public ArrayList<RepairInfo> queryrep(RepairInfo r, int start, int size) {
		ArrayList<RepairInfo> result = new ArrayList<RepairInfo>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		con = DBUTIL.getConnection();
		try {
			// where������̬ƴ��
			StringBuilder sql = new StringBuilder();
			sql.append("select repair_info.rep_no from repair_info,fix_record where repair_info.rep_no=fix_record.rep_no ");
			if (r.getRep_no() != -1) {
				sql.append(" and repair_info.rep_no=? ");
			}

			sql.append(" limit ?,? ");
			st = con.prepareStatement(sql.toString());
			int index = 1;

			if (r.getRep_no() != -1) {

				st.setInt(index++, r.getRep_no());
			}
			st.setInt(index++, start);
			st.setInt(index++, size);

			rs = st.executeQuery();

			while (rs.next()) {
				RepairInfo rep = new RepairInfo();
				rep.setRep_no(rs.getInt("rep_no"));
				// ���ؽ����
				result.add(rep);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTIL.closeResource(rs, st, con);
		}

		return result;
	}

	public int queryrepTotalRows(RepairInfo r) {
		int result = 0;

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		con = DBUTIL.getConnection();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select count(repair_info.rep_no) from repair_info,fix_record where repair_info.rep_no=fix_record.rep_no ");
			if (r.getRep_no() != -1) {
				sql.append(" and repair_info.rep_no = ? ");
			}
			// System.out.println(sql);
			st = con.prepareStatement(sql.toString());
			int index = 1;

			if (r.getRep_no() != -1) {
				// ģ����ѯ��ͨ���
				st.setInt(index++, r.getRep_no());
				// System.out.println("sos");
			}
			// System.out.println(sql);
			rs = st.executeQuery();
			if (rs.next()) {
				// �ӵ�һ��ȡ����
				result = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTIL.closeResource(rs, st, con);
		}

		return result;
	}
	
	public DeviceInfo queryfix(int r){
		DeviceInfo dev=new DeviceInfo();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUTIL.getConnection();
		try {
			//where������̬ƴ��
			StringBuilder sql=new StringBuilder();
			sql.append(" select device_info.dev_ptype as dev_ptype from repair_info,device_info where repair_info.dev_id=device_info.dev_id and rep_no=? ");
			
			st=con.prepareStatement(sql.toString());
			int index=1;
			
			if(r!=0){
				//��ѯ���
				st.setInt(index++, r);
			}
			rs=st.executeQuery();
			
			if(rs.next()){	
				dev.setDev_ptype(rs.getString("dev_ptype"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBUTIL.closeResource(rs, st, con);
		}
		
		return dev;
	}
	
	public ArrayList<AdminInfo> queryfix(int start, int size) {
		ArrayList<AdminInfo> result = new ArrayList<AdminInfo>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		con = DBUTIL.getConnection();
		try {
			// where������̬ƴ��
			StringBuilder sql = new StringBuilder();
			sql.append(" select admin_info.adm_no as adm_no,admin_info.adm_name as adm_name from admin_info where adm_type='ά����Ա' ");

			sql.append(" limit ?,? ");
			st = con.prepareStatement(sql.toString());
			int index = 1;

			st.setInt(index++, start);
			st.setInt(index++, size);

			rs = st.executeQuery();

			while (rs.next()) {
				AdminInfo adm = new AdminInfo();
				adm.setAdm_no(rs.getInt("adm_no"));
				adm.setAdm_name(rs.getString("adm_name"));
				// ���ؽ����
				result.add(adm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTIL.closeResource(rs, st, con);
		}

		return result;
	}

	public int queryfixTotalRows() {
		int result = 0;

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		con = DBUTIL.getConnection();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" select count(*) from admin_info where adm_type='ά����Ա' ");
			st = con.prepareStatement(sql.toString());
			//int index = 1;
			// System.out.println(sql);
			rs = st.executeQuery();
			if (rs.next()) {
				// �ӵ�һ��ȡ����
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
