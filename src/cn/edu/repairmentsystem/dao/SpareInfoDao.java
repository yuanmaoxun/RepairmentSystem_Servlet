package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.SpareInfo;

public class SpareInfoDao {
	public boolean addSpareInfo(SpareInfo spare) {
		
		boolean result = true;
		
		Connection con = null;
		PreparedStatement st =null;
		
		con = DBUTIL.getConnection();
		
		try {
			st = con.prepareStatement(" insert into spare_info(equ_id,spa_num,fix_no) values(?,?,?) ");
			
			st.setInt(1, spare.getEqu_id());
			st.setInt(2, spare.getSpa_num());
			st.setInt(3, spare.getFix_no());
			
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
