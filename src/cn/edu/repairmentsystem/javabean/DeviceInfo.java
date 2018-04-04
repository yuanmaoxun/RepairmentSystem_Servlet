package cn.edu.repairmentsystem.javabean;

public class DeviceInfo {

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
	
	public DeviceInfo() {
		
	}

	public DeviceInfo(int dev_id, String dev_ptype, String dev_brand,
			String dev_model, String dev_series, String dev_command,
			String dev_hdd, String dev_rom, String dev_pc, String dev_adapt,
			String dev_battery, String dev_drive) {
		super();
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
