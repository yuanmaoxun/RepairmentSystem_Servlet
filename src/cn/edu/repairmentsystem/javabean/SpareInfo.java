package cn.edu.repairmentsystem.javabean;

public class SpareInfo {
	
	private int spa_id;
	private int spa_num;
	private int equ_id;
	private int fix_no;
	
	public SpareInfo(int spa_id, int spa_num, int equ_id, int fix_no) {
		super();
		this.spa_id = spa_id;
		this.spa_num = spa_num;
		this.equ_id = equ_id;
		this.fix_no = fix_no;
	}
	public SpareInfo() {
		
	}
	public int getSpa_id() {
		return spa_id;
	}
	public void setSpa_id(int spa_id) {
		this.spa_id = spa_id;
	}
	public int getSpa_num() {
		return spa_num;
	}
	public void setSpa_num(int spa_num) {
		this.spa_num = spa_num;
	}
	public int getEqu_id() {
		return equ_id;
	}
	public void setEqu_id(int equ_id) {
		this.equ_id = equ_id;
	}
	public int getFix_no() {
		return fix_no;
	}
	public void setFix_no(int fix_no) {
		this.fix_no = fix_no;
	}
	
	
}
