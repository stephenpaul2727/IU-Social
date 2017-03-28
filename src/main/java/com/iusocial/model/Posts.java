package com.iusocial.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity (name="posts")
public class Posts implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator="post_id_seq")
	@SequenceGenerator(name="post_id_seq",sequenceName="post_id_seq",allocationSize=1)
	private int id;
	@Column(name ="userofpost")
	 private String userofpost;
	@Column(name = "text")
	 private String text;
	@Column(name ="link")
	 private boolean link;
	@Column(name ="likes")
	 private int likes;
	@Column(name="name")
	 private String name;

	public Posts(){
		}

	public Posts(String userofpost, String text,boolean link, int likes, String name){
		this.userofpost = userofpost;
		this.text = text;
		this.link = link;
		this.likes = likes;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserofpost() {
		return userofpost;
	}

	public void setUserofpost(String userofpost) {
		this.userofpost = userofpost;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isLink() {
		return link;
	}

	public void setLink(boolean link) {
		this.link = link;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	}