package cn.edu.repairmentsystem.javabean;

public class AccountInfo {
	
	private int acc_no;
	private double acc_cal;
	private int fix_no;
	private String acc_condition;
	public AccountInfo() {
		
	}
	public AccountInfo(int acc_no, double acc_cal, int fix_no,
			String acc_condition) {
		super();
		this.acc_no = acc_no;
		this.acc_cal = acc_cal;
		this.fix_no = fix_no;
		this.acc_condition = acc_condition;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public double getAcc_cal() {
		return acc_cal;
	}
	public void setAcc_cal(double acc_cal) {
		this.acc_cal = acc_cal;
	}
	public int getFix_no() {
		return fix_no;
	}
	public void setFix_no(int fix_no) {
		this.fix_no = fix_no;
	}
	public String getAcc_condition() {
		return acc_condition;
	}
	public void setAcc_condition(String acc_condition) {
		this.acc_condition = acc_condition;
	}
	
	
}
