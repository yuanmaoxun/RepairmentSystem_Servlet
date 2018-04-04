package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.AdminInfo;

public class AdminInfoDao {

	public boolean login (AdminInfo u)
	{
		boolean result=false;//¼Ù¶¨Ê§°Ü
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUTIL.getConnection();
		
		try {
			st=con.prepareStatement(" select count(*) as c from admin_info where adm_name=?  and adm_pwd=?");
			st.setString(1,u.getAdm_name());
			st.setString(2,u.getAdm_pwd());
			
			rs=st.executeQuery();
			if (rs.next())
			{
				int i=rs.getInt("c");
				
				if (i==1)
				{
					result=true;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUTIL.closeResource(rs, st, con);
		}
		
		return result;
	}
	public String selecttype(AdminInfo u) {
		String type = null;
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		con=DBUTIL.getConnection();
		try {
			st=con.prepareStatement(" select adm_type from admin_info where adm_name=?  and adm_pwd=?");
			st.setString(1,u.getAdm_name());
			st.setString(2,u.getAdm_pwd());
			
			rs=st.executeQuery();
			if (rs.next())
			{
				type = rs.getString("adm_type");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUTIL.closeResource(rs, st, con);
		}
		
		return type;
	}

}
