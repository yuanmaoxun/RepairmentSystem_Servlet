package cn.edu.repairmentsystem.javabean;

import java.util.Date;

public class FixRecord {
	
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
	public FixRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FixRecord(int fix_no, int fix_staffno, Date fix_allocatetime,
			String fix_check, String fix_fix, Date fix_checktime,
			String fix_quantity, double fix_money, double fix_material,
			String fix_attention, String fix_condition, String fix_level,
			int rep_no, String fix_job) {
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
	
	
	
}
