package cn.edu.repairmentsystem.javabean;

import java.util.Date;

public class StorageInfo {
	
	private int sto_no;
	private int  sto_changenum;
	private Date sto_time;
	private String sto_type;
	private int equ_id;
	
	public StorageInfo(int sto_no, int sto_changenum, Date sto_time,
			String sto_type, int equ_id) {
		super();
		this.sto_no = sto_no;
		this.sto_changenum = sto_changenum;
		this.sto_time = sto_time;
		this.sto_type = sto_type;
		this.equ_id = equ_id;
	}

	public StorageInfo() {
		
	}

	public int getSto_no() {
		return sto_no;
	}

	public void setSto_no(int sto_no) {
		this.sto_no = sto_no;
	}

	public int getSto_changenum() {
		return sto_changenum;
	}

	public void setSto_changenum(int sto_changenum) {
		this.sto_changenum = sto_changenum;
	}

	public Date getSto_time() {
		return sto_time;
	}

	public void setSto_time(Date sto_time) {
		this.sto_time = sto_time;
	}

	public String getSto_type() {
		return sto_type;
	}

	public void setSto_type(String sto_type) {
		this.sto_type = sto_type;
	}

	public int getEqu_id() {
		return equ_id;
	}

	public void setEqu_id(int equ_id) {
		this.equ_id = equ_id;
	}
	
}
