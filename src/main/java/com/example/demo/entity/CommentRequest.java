package com.example.demo.entity;

import java.util.Date;

public class CommentRequest {
	
	private Integer id ;
    private String comment ;
    private Date datecomment;
    private String email;
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private Integer user_id;
    private Integer motel_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDatecomment() {
		return datecomment;
	}
	public void setDatecomment(Date datecomment) {
		this.datecomment = datecomment;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getMotel_id() {
		return motel_id;
	}
	public void setMotel_id(Integer motel_id) {
		this.motel_id = motel_id;
	}
}
