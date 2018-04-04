package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.StorageInfo;

public class StorageInfoDao {
		
		//添加设库存流水信息
		public boolean addStorageInfo(StorageInfo storage) {
			
			boolean result = true;
			
			Connection con = null;
			PreparedStatement st =null;
			
			con = DBUTIL.getConnection();
			
			try {
				st = con.prepareStatement(" insert into storage_info(sto_changenum,sto_time,sto_type,equ_id) values(?,?,?,?)");
				
				st.setInt(1, storage.getSto_changenum());
				
				//转换date类型
				java.sql.Date date = new java.sql.Date(storage.getSto_time().getTime());				
				st.setDate(2,date);
				
				st.setString(3, storage.getSto_type());
				st.setInt(4,storage.getEqu_id());
				
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
