package com.iusocial.model; 


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity (name ="users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator="user_id_seq")
	@SequenceGenerator(name="user_id_seq",sequenceName="user_id_seq",allocationSize=1)
	private int id;
	@Column(name ="fname")
	 private String fname;
	@Column(name = "lname")
	 private String lname;
	@Column(name ="email")
	 private String email;
	@Column(name ="pass")
	 private String password;
	@Column(name ="phone")
	 private String phone;
	 
	
	public User()
	{
		
	}
	 public User(String fname,String lname,String email,String password, String phone)
	 {
		 super();
		 this.fname = fname;
		 this.lname = lname;
		 this.email = email;
		 this.phone=phone;
		 this.password = password;
		 
	 }

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	 
	 
}
