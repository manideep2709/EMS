package com.mani.employee;

public class Employee {

	private int emp_id;
	private String usr_name;
	private String usr_pass;
	private String address;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getUsr_name() {
		return usr_name;
	}

	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}

	public String getUsr_pass() {
		return usr_pass;
	}

	public void setUsr_pass(String usr_pass) {
		this.usr_pass = usr_pass;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", usr_name=" + usr_name + ", usr_pass=" + usr_pass + ", address="
				+ address + "]";
	}
	
	

}
