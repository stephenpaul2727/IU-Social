package com.iusocial.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity (name = "groups")
public class Pages implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator="groups_id_seq")
	@SequenceGenerator(name="groups_id_seq",sequenceName="groups_id_seq",allocationSize=1)
	private int group_id;
	@Column(name ="group_name")
	 private String group_name;
	@Column(name = "group_photo")
	 private String group_photo;
	@Column(name ="group_admin")
	 private String group_admin;
	@Column(name ="group_about")
	 private String group_about;

	public Pages(){
		
	}
	public Pages(String group_name, String group_photo, String group_admin, String group_about){
		this.group_name = group_name;
		this.group_photo = group_photo;
		this.group_admin= group_admin;
		this.group_about= group_about;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getGroup_photo() {
		return group_photo;
	}
	public void setGroup_photo(String group_photo) {
		this.group_photo = group_photo;
	}
	public String getGroup_admin() {
		return group_admin;
	}
	public void setGroup_admin(String group_admin) {
		this.group_admin = group_admin;
	}
	public String getGroup_about() {
		return group_about;
	}
	public void setGroup_about(String group_about) {
		this.group_about = group_about;
	}
	
	
}