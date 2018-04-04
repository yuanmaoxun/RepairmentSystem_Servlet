package cn.edu.repairmentsystem.javabean;

public class  EquipmentInfo{
	
	private int equ_id;
	private String equ_name;
	private String equ_model;
	private int equ_num;
	private double equ_cost;
	private int equ_alternum;
	private String equ_condition;
	public EquipmentInfo() {
		
	}
	public EquipmentInfo(int equ_id, String equ_name, String equ_model,
			int equ_num, double equ_cost, int equ_alternum, String equ_condition) {
		super();
		this.equ_id = equ_id;
		this.equ_name = equ_name;
		this.equ_model = equ_model;
		this.equ_num = equ_num;
		this.equ_cost = equ_cost;
		this.equ_alternum = equ_alternum;
		this.equ_condition = equ_condition;
	}
	public int getEqu_id() {
		return equ_id;
	}
	public void setEqu_id(int equ_id) {
		this.equ_id = equ_id;
	}
	public String getEqu_name() {
		return equ_name;
	}
	public void setEqu_name(String equ_name) {
		this.equ_name = equ_name;
	}
	public String getEqu_model() {
		return equ_model;
	}
	public void setEqu_model(String equ_model) {
		this.equ_model = equ_model;
	}
	public int getEqu_num() {
		return equ_num;
	}
	public void setEqu_num(int equ_num) {
		this.equ_num = equ_num;
	}
	public double getEqu_cost() {
		return equ_cost;
	}
	public void setEqu_cost(double equ_cost) {
		this.equ_cost = equ_cost;
	}
	public int getEqu_alternum() {
		return equ_alternum;
	}
	public void setEqu_alternum(int equ_alternum) {
		this.equ_alternum = equ_alternum;
	}
	public String getEqu_condition() {
		return equ_condition;
	}
	public void setEqu_condition(String equ_condition) {
		this.equ_condition = equ_condition;
	}
	
	
}
