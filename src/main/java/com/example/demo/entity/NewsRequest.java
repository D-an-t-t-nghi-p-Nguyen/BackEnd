package com.example.demo.entity;

import java.util.Date;

public class NewsRequest {

	private Integer id;
	private String name;
	private Date dateSubmit;
	private String content1;
	private String content2;
	private String image;
	private Boolean is_Delete;
	private Integer user_id ;
	private String email;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateSubmit() {
		return dateSubmit;
	}
	public void setDateSubmit(Date dateSubmit) {
		this.dateSubmit = dateSubmit;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getIs_Delete() {
		return is_Delete;
	}
	public void setIs_Delete(Boolean is_Delete) {
		this.is_Delete = is_Delete;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
