package com.iusocial.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity (name = "userinfo")
public class Userinfo implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator="userinfo_id_seq")
	@SequenceGenerator(name="userinfo_id_seq",sequenceName="userinfo_id_seq",allocationSize=1)
	private int u_id;
	@Column(name ="u_email")
	 private String u_email;
	@Column(name = "u_degree")
	 private String u_degree;
	@Column(name ="u_school")
	 private String u_school;
	@Column(name ="u_gender")
	 private String u_gender;
	@Column(name ="u_major")
	 private String u_major;
	@Column(name ="u_photo")
	 private String u_photo;
	@Column(name ="u_friends")
	 private String[] u_friends;
	@Column(name ="u_groups")
	 private String[] u_groups;
	@Column(name = "u_newfriends")
	 private String[] u_newfriends;
	
	public Userinfo(){
		
	}
	
	public Userinfo(String email, String degree, String school, String gender, String major, String photo, String[] friends, String[] groups, String[] newfriends){
		super();
		u_email = email;
		u_degree = degree;
		u_school = school;
		u_gender = gender;
		u_major = major;
		u_photo = photo;
		u_friends = friends;
		u_groups= groups;
		u_newfriends = newfriends;
		
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_degree() {
		return u_degree;
	}

	public void setU_degree(String u_degree) {
		this.u_degree = u_degree;
	}

	public String getU_school() {
		return u_school;
	}

	public void setU_school(String u_school) {
		this.u_school = u_school;
	}

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public String getU_major() {
		return u_major;
	}

	public void setU_major(String u_major) {
		this.u_major = u_major;
	}

	public String getU_photo() {
		return u_photo;
	}

	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}

	public String[] getU_friends() {
		return u_friends;
	}

	public void setU_friends(String[] u_friends) {
		this.u_friends = u_friends;
	}

	public String[] getU_groups() {
		return u_groups;
	}

	public void setU_groups(String[] u_groups) {
		this.u_groups = u_groups;
	}

	public String[] getU_newfriends() {
		return u_newfriends;
	}

	public void setU_newfriends(String[] u_newfriends) {
		this.u_newfriends = u_newfriends;
	}
	
	
	
	
	
	

}
