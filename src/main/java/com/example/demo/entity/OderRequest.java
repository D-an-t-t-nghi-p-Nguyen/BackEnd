package com.example.demo.entity;

import java.util.Date;

public class OderRequest {

	private Integer id;
	private String number;
	private String amount;
	private Date dateBooking;
	private String dateGo;	
	private String email;
	private Integer user_id;
    private Integer motel_id;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getDateBooking() {
		return dateBooking;
	}
	public void setDateBooking(Date dateBooking) {
		this.dateBooking = dateBooking;
	}
	
	public String getDateGo() {
		return dateGo;
	}
	public void setDateGo(String dateGo) {
		this.dateGo = dateGo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
