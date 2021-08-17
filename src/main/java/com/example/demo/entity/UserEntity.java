package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String userName ;
    private String emailId ;
    private String password ;
    private String avatar ;
    private boolean is_Delete;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isIs_Delete() {
		return is_Delete;
	}

	public void setIs_Delete(boolean is_Delete) {
		this.is_Delete = is_Delete;
	}

	public Roles getRole_id() {
		return role_id;
	}

	public void setRole_id(Roles role_id) {
		this.role_id = role_id;
	}
    
    
    
}
