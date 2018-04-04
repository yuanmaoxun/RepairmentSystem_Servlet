package cn.edu.repairmentsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.repairmentsystem.common.DBUTIL;
import cn.edu.repairmentsystem.javabean.AccountInfo;
	
	//��ѯ����ĵ���
	public class AccountInfoDao {
		public int queryAccid() {
			int result = 0;
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			con = DBUTIL.getConnection();
			try {
				st = con.prepareStatement( "select max(acc_no) from account_info " );
				
				rs = st.executeQuery();
				
				while(rs.next()) {
					result = rs.getInt("max(acc_no)");
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
		//��ѯά�޵ĵ����Ƿ����
			public boolean queryFixno(int num) {
				boolean result = true;
				Connection con=null;
				PreparedStatement st=null;
				ResultSet rs=null;
				con = DBUTIL.getConnection();
				try {
					st = con.prepareStatement( "select * from account_info where fix_no=? " );
					st.setInt(1, num);
					
					rs = st.executeQuery();
					
					if(rs.next())
						result = false;
					
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
		//����account��Ϣ
		public boolean addAccount(AccountInfo account) {
			
			boolean result = true;
			
			Connection con = null;
			PreparedStatement st =null;
			
			con = DBUTIL.getConnection();
			
			try {
				st = con.prepareStatement(" insert into account_info (acc_no,acc_cal,acc_condition,fix_no) values(?,?,?,?) ");
				st.setInt(1, account.getAcc_no());
				st.setDouble(2, account.getAcc_cal());
				st.setString(3, account.getAcc_condition());
				st.setInt(4, account.getFix_no());
				
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
		
		//�޸Ľɷ����
		public boolean updateCondition(int num) {
			boolean result = true;
			Connection con = null;
			PreparedStatement st =null;
			
			con = DBUTIL.getConnection();
			
			try {
				st = con.prepareStatement(" update account_info set acc_condition = '�ѽ���' where acc_no=? ");
                st.setInt(1, num);
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
