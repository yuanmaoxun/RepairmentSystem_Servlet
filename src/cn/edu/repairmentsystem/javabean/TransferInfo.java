package cn.edu.repairmentsystem.javabean;

import java.util.Date;

public class TransferInfo {
	private int fix_no;
	private int fix_staffno;
	private Date fix_allocatetime;
	private String fix_check;
	private String fix_fix;
	private Date fix_checktime;
	private String fix_quantity;
	private double fix_money;
	private double fix_material;
	private String fix_attention;
	private String fix_condition;
	private String fix_level;
	private int rep_no;
	private String fix_job;
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
	public TransferInfo(int fix_no, int fix_staffno, Date fix_allocatetime,
			String fix_check, String fix_fix, Date fix_checktime,
			String fix_quantity, double fix_money, double fix_material,
			String fix_attention, String fix_condition, String fix_level,
			int rep_no, String fix_job, int dev_id, String dev_ptype,
			String dev_brand, String dev_model, String dev_series,
			String dev_command, String dev_hdd, String dev_rom, String dev_pc,
			String dev_adapt, String dev_battery, String dev_drive) {
		super();
		this.fix_no = fix_no;
		this.fix_staffno = fix_staffno;
		this.fix_allocatetime = fix_allocatetime;
		this.fix_check = fix_check;
		this.fix_fix = fix_fix;
		this.fix_checktime = fix_checktime;
		this.fix_quantity = fix_quantity;
		this.fix_money = fix_money;
		this.fix_material = fix_material;
		this.fix_attention = fix_attention;
		this.fix_condition = fix_condition;
		this.fix_level = fix_level;
		this.rep_no = rep_no;
		this.fix_job = fix_job;
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
	}
	public TransferInfo() {
		super();
		// TODO Auto-generated constructor stub
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
	public Date getFix_allocatetime() {
		return fix_allocatetime;
	}
	public void setFix_allocatetime(Date fix_allocatetime) {
		this.fix_allocatetime = fix_allocatetime;
	}
	public String getFix_check() {
		return fix_check;
	}
	public void setFix_check(String fix_check) {
		this.fix_check = fix_check;
	}
	public String getFix_fix() {
		return fix_fix;
	}
	public void setFix_fix(String fix_fix) {
		this.fix_fix = fix_fix;
	}
	public Date getFix_checktime() {
		return fix_checktime;
	}
	public void setFix_checktime(Date fix_checktime) {
		this.fix_checktime = fix_checktime;
	}
	public String getFix_quantity() {
		return fix_quantity;
	}
	public void setFix_quantity(String fix_quantity) {
		this.fix_quantity = fix_quantity;
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
	public String getFix_attention() {
		return fix_attention;
	}
	public void setFix_attention(String fix_attention) {
		this.fix_attention = fix_attention;
	}
	public String getFix_condition() {
		return fix_condition;
	}
	public void setFix_condition(String fix_condition) {
		this.fix_condition = fix_condition;
	}
	public String getFix_level() {
		return fix_level;
	}
	public void setFix_level(String fix_level) {
		this.fix_level = fix_level;
	}
	public int getRep_no() {
		return rep_no;
	}
	public void setRep_no(int rep_no) {
		this.rep_no = rep_no;
	}
	public String getFix_job() {
		return fix_job;
	}
	public void setFix_job(String fix_job) {
		this.fix_job = fix_job;
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
	
	
}
