package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import cn.edu.repairmentsystem.common.DBUTIL;

public class FixAllocationDao {
	public boolean updatefixallocate(int fixno,int admno){
		boolean result=true;
		Connection con=null;
		PreparedStatement st=null;
		con=DBUTIL.getConnection();
		try {
			int index=1;
			st=con.prepareStatement("update fix_record set fix_condition='“—∑÷≈‰',fix_staffno=? where fix_no=?");
			
			st.setInt(index++, admno);
			st.setInt(index++, fixno);
			
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
}
