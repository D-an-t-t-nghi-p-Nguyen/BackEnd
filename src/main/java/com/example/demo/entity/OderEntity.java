package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "oder")
public class OderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String number;
	private String amount;
	private Date dateBooking;
	private String dateGo;	    
	@ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_id;
    @ManyToOne
    @JoinColumn(name = "motel_id")
    private BlogEntity motel_id ;
    private boolean is_Delete;
    
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
	public UserEntity getUser_id() {
		return user_id;
	}
	public void setUser_id(UserEntity user_id) {
		this.user_id = user_id;
	}
	public BlogEntity getMotel_id() {
		return motel_id;
	}
	public void setMotel_id(BlogEntity motel_id) {
		this.motel_id = motel_id;
	}
	public boolean isIs_Delete() {
		return is_Delete;
	}
	public void setIs_Delete(boolean is_Delete) {
		this.is_Delete = is_Delete;
	}
    
    
}
