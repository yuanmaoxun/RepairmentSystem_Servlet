package cn.edu.repairmentsystem.javabean;

public class AdminInfo {
	
	private int adm_no;
	private String adm_name;
	private String adm_pwd;
	private String adm_type;
	
	
	public AdminInfo(int adm_no, String adm_name, String adm_pwd,
			String adm_type) {
		super();
		this.adm_no = adm_no;
		this.adm_name = adm_name;
		this.adm_pwd = adm_pwd;
		this.adm_type = adm_type;
	}


	public AdminInfo() {
	
	}
	
	
	public int getAdm_no() {
		return adm_no;
	}
	public void setAdm_no(int adm_no) {
		this.adm_no = adm_no;
	}
	public String getAdm_name() {
		return adm_name;
	}
	public void setAdm_name(String adm_name) {
		this.adm_name = adm_name;
	}
	public String getAdm_pwd() {
		return adm_pwd;
	}
	public void setAdm_pwd(String adm_pwd) {
		this.adm_pwd = adm_pwd;
	}
	public String getAdm_type() {
		return adm_type;
	}
	public void setAdm_type(String adm_type) {
		this.adm_type = adm_type;
	}
}
