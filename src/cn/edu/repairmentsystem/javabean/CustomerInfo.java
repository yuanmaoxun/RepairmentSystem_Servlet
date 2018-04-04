package cn.edu.repairmentsystem.javabean;
public class CustomerInfo {
	
	private int cus_no;
	private String cus_id;
	private String cus_pro;
	private String cus_unit;
	private String cus_phone;
	private String cus_mobile;
	private String cus_addr;
	private String cus_code;
	private String cus_contact;
	
	private String cus_email;
	
	
	public CustomerInfo(int cus_no, String cus_id, String cus_pro,
			String cus_unit, String cus_phone, String cus_mobile,
			String cus_addr, String cus_code, String cus_contact,
			String cus_email) {
		super();
		this.cus_no = cus_no;
		this.cus_id = cus_id;
		this.cus_pro = cus_pro;
		this.cus_unit = cus_unit;
		this.cus_phone = cus_phone;
		this.cus_mobile = cus_mobile;
		this.cus_addr = cus_addr;
		this.cus_code = cus_code;
		this.cus_contact = cus_contact;
		this.cus_email = cus_email;
	}
	
	
	public CustomerInfo() {
		
	}


	public int getCus_no() {
		return cus_no;
	}
	public void setCus_no(int cus_no) {
		this.cus_no = cus_no;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_pro() {
		return cus_pro;
	}
	public void setCus_pro(String cus_pro) {
		this.cus_pro = cus_pro;
	}
	public String getCus_unit() {
		return cus_unit;
	}
	public void setCus_unit(String cus_unit) {
		this.cus_unit = cus_unit;
	}
	public String getCus_phone() {
		return cus_phone;
	}
	public void setCus_phone(String cus_phone) {
		this.cus_phone = cus_phone;
	}
	public String getCus_mobile() {
		return cus_mobile;
	}
	public void setCus_mobile(String cus_mobile) {
		this.cus_mobile = cus_mobile;
	}
	public String getCus_addr() {
		return cus_addr;
	}
	public void setCus_addr(String cus_addr) {
		this.cus_addr = cus_addr;
	}
	public String getCus_code() {
		return cus_code;
	}
	public void setCus_code(String cus_code) {
		this.cus_code = cus_code;
	}
	public String getCus_contact() {
		return cus_contact;
	}
	public void setCus_contact(String cus_contact) {
		this.cus_contact = cus_contact;
	}
	public String getCus_email() {
		return cus_email;
	}
	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}
	
}
