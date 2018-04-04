package cn.edu.repairmentsystem.javabean;

import java.util.Date;

public class RepairInfo {
	private int rep_no;
	private Date rep_start;
	private double rep_estimate;
	private Date rep_end;
	private String  rep_condition;
	private String rep_spare;
	private String rep_app;
	private String rep_fault;
	private int cus_no ;
	private int  dev_id;
	private String rep_check;
	private String rep_others;
	private String rep_data;
	public RepairInfo(int rep_no, Date rep_start, double rep_estimate,
			Date rep_end, String rep_condition, String rep_spare,
			String rep_app, String rep_fault, int cus_no, int dev_id,
			String rep_check, String rep_others, String rep_data) {
		super();
		this.rep_no = rep_no;
		this.rep_start = rep_start;
		this.rep_estimate = rep_estimate;
		this.rep_end = rep_end;
		this.rep_condition = rep_condition;
		this.rep_spare = rep_spare;
		this.rep_app = rep_app;
		this.rep_fault = rep_fault;
		this.cus_no = cus_no;
		this.dev_id = dev_id;
		this.rep_check = rep_check;
		this.rep_others = rep_others;
		this.rep_data = rep_data;
	}
	public RepairInfo() {

	}
	public int getRep_no() {
		return rep_no;
	}
	public void setRep_no(int rep_no) {
		this.rep_no = rep_no;
	}
	public Date getRep_start() {
		return rep_start;
	}
	public void setRep_start(Date rep_start) {
		this.rep_start = rep_start;
	}
	public double getRep_estimate() {
		return rep_estimate;
	}
	public void setRep_estimate(double rep_estimate) {
		this.rep_estimate = rep_estimate;
	}
	public Date getRep_end() {
		return rep_end;
	}
	public void setRep_end(Date rep_end) {
		this.rep_end = rep_end;
	}
	public String getRep_condition() {
		return rep_condition;
	}
	public void setRep_condition(String rep_condition) {
		this.rep_condition = rep_condition;
	}
	public String getRep_spare() {
		return rep_spare;
	}
	public void setRep_spare(String rep_spare) {
		this.rep_spare = rep_spare;
	}
	public String getRep_app() {
		return rep_app;
	}
	public void setRep_app(String rep_app) {
		this.rep_app = rep_app;
	}
	public String getRep_fault() {
		return rep_fault;
	}
	public void setRep_fault(String rep_fault) {
		this.rep_fault = rep_fault;
	}
	public int getCus_no() {
		return cus_no;
	}
	public void setCus_no(int cus_no) {
		this.cus_no = cus_no;
	}
	public int getDev_id() {
		return dev_id;
	}
	public void setDev_id(int dev_id) {
		this.dev_id = dev_id;
	}
	public String getRep_check() {
		return rep_check;
	}
	public void setRep_check(String rep_check) {
		this.rep_check = rep_check;
	}
	public String getRep_others() {
		return rep_others;
	}
	public void setRep_others(String rep_others) {
		this.rep_others = rep_others;
	}
	public String getRep_data() {
		return rep_data;
	}
	public void setRep_data(String rep_data) {
		this.rep_data = rep_data;
	}
	
	
}
