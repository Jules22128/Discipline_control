package com.Disciplinecontrol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Models {
	
	@Id 
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	private String sex;
	private String classes;
	private String province;
	private String pnumber;
	private String profilepicture;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getProfilepicture() {
		return profilepicture;
	}
	public void setProfilepicture(String profilepicture) {
		this.profilepicture = profilepicture;
	}
	

}
