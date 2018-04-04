package cn.edu.repairmentsystem.javabean;

import java.util.Date;

public class TablesInfo {
	
	private int fix_no;
	private int fix_staffno;
	private String adm_name;
	private Date fix_allocatetime;
	private double fix_money;
	private double fix_material;
	private int dev_id;
	private String dev_ptype;
	private String dev_brand;
	private String dev_model;
	private String dev_series;
	private String dev_command;
	private String dev_hdd;
	private String dev_rom ;
	private String dev_pc;
	private String dev_adapt;
	private String dev_battery;
	private String dev_drive;
	private String cus_pro;
	private String cus_mobile;
	private String cus_id;
	private String cus_contact;
	private int acc_no;
	private double acc_cal;
	private String acc_condition;
	private int equ_id;
	private int spa_num;
	
	public TablesInfo() {
		
	}

	public TablesInfo(int fix_no, int fix_staffno, String adm_name,
			Date fix_allocatetime, double fix_money, double fix_material,
			int dev_id, String dev_ptype, String dev_brand, String dev_model,
			String dev_series, String dev_command, String dev_hdd,
			String dev_rom, String dev_pc, String dev_adapt,
			String dev_battery, String dev_drive, String cus_pro,
			String cus_mobile, String cus_id, String cus_contact, int acc_no,
			double acc_cal, String acc_condition, int equ_id, int spa_num) {
		super();
		this.fix_no = fix_no;
		this.fix_staffno = fix_staffno;
		this.adm_name = adm_name;
		this.fix_allocatetime = fix_allocatetime;
		this.fix_money = fix_money;
		this.fix_material = fix_material;
		this.dev_id = dev_id;
		this.dev_ptype = dev_ptype;
		this.dev_brand = dev_brand;
		this.dev_model = dev_model;
		this.dev_series = dev_series;
		this.dev_command = dev_command;
		this.dev_hdd = dev_hdd;
		this.dev_rom = dev_rom;
		this.dev_pc = dev_pc;
		this.dev_adapt = dev_adapt;
		this.dev_battery = dev_battery;
		this.dev_drive = dev_drive;
		this.cus_pro = cus_pro;
		this.cus_mobile = cus_mobile;
		this.cus_id = cus_id;
		this.cus_contact = cus_contact;
		this.acc_no = acc_no;
		this.acc_cal = acc_cal;
		this.acc_condition = acc_condition;
		this.equ_id = equ_id;
		this.spa_num = spa_num;
	}

	public int getFix_no() {
		return fix_no;
	}

	public void setFix_no(int fix_no) {
		this.fix_no = fix_no;
	}

	public int getFix_staffno() {
		return fix_staffno;
	}

	public void setFix_staffno(int fix_staffno) {
		this.fix_staffno = fix_staffno;
	}

	public String getAdm_name() {
		return adm_name;
	}

	public void setAdm_name(String adm_name) {
		this.adm_name = adm_name;
	}

	public Date getFix_allocatetime() {
		return fix_allocatetime;
	}

	public void setFix_allocatetime(Date fix_allocatetime) {
		this.fix_allocatetime = fix_allocatetime;
	}

	public double getFix_money() {
		return fix_money;
	}

	public void setFix_money(double fix_money) {
		this.fix_money = fix_money;
	}

	public double getFix_material() {
		return fix_material;
	}

	public void setFix_material(double fix_material) {
		this.fix_material = fix_material;
	}

	public int getDev_id() {
		return dev_id;
	}

	public void setDev_id(int dev_id) {
		this.dev_id = dev_id;
	}

	public String getDev_ptype() {
		return dev_ptype;
	}

	public void setDev_ptype(String dev_ptype) {
		this.dev_ptype = dev_ptype;
	}

	public String getDev_brand() {
		return dev_brand;
	}

	public void setDev_brand(String dev_brand) {
		this.dev_brand = dev_brand;
	}

	public String getDev_model() {
		return dev_model;
	}

	public void setDev_model(String dev_model) {
		this.dev_model = dev_model;
	}

	public String getDev_series() {
		return dev_series;
	}

	public void setDev_series(String dev_series) {
		this.dev_series = dev_series;
	}

	public String getDev_command() {
		return dev_command;
	}

	public void setDev_command(String dev_command) {
		this.dev_command = dev_command;
	}

	public String getDev_hdd() {
		return dev_hdd;
	}

	public void setDev_hdd(String dev_hdd) {
		this.dev_hdd = dev_hdd;
	}

	public String getDev_rom() {
		return dev_rom;
	}

	public void setDev_rom(String dev_rom) {
		this.dev_rom = dev_rom;
	}

	public String getDev_pc() {
		return dev_pc;
	}

	public void setDev_pc(String dev_pc) {
		this.dev_pc = dev_pc;
	}

	public String getDev_adapt() {
		return dev_adapt;
	}

	public void setDev_adapt(String dev_adapt) {
		this.dev_adapt = dev_adapt;
	}

	public String getDev_battery() {
		return dev_battery;
	}

	public void setDev_battery(String dev_battery) {
		this.dev_battery = dev_battery;
	}

	public String getDev_drive() {
		return dev_drive;
	}

	public void setDev_drive(String dev_drive) {
		this.dev_drive = dev_drive;
	}

	public String getCus_pro() {
		return cus_pro;
	}

	public void setCus_pro(String cus_pro) {
		this.cus_pro = cus_pro;
	}

	public String getCus_mobile() {
		return cus_mobile;
	}

	public void setCus_mobile(String cus_mobile) {
		this.cus_mobile = cus_mobile;
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_contact() {
		return cus_contact;
	}

	public void setCus_contact(String cus_contact) {
		this.cus_contact = cus_contact;
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

	public String getAcc_condition() {
		return acc_condition;
	}

	public void setAcc_condition(String acc_condition) {
		this.acc_condition = acc_condition;
	}

	public int getEqu_id() {
		return equ_id;
	}

	public void setEqu_id(int equ_id) {
		this.equ_id = equ_id;
	}

	public int getSpa_num() {
		return spa_num;
	}

	public void setSpa_num(int spa_num) {
		this.spa_num = spa_num;
	}

	
	
	
	
}
