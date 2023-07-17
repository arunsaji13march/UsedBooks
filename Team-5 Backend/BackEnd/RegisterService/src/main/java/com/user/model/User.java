package com.user.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="User")
public class User {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userFirstName;
	private String userLastName;
	private String userDob;
	private String userGender;
	@Column(nullable=false)
	private String userEmail;
	@Value("${role:user}")
	@Enumerated(value = EnumType.STRING)
	private Role role = Role.user;
	private String userPassword;
	private String userMobile;
	private String userAddress;
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	
	
	
	
	public User(int userId, String userFirstName, String userLastName, String userDob, String userGender,
			String userEmail, Role role, String userPassword, String userMobile, String userAddress,
			LocalDateTime createdAt) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userDob = userDob;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.role = role;
		this.userPassword = userPassword;
		this.userMobile = userMobile;
		this.userAddress = userAddress;
		this.createdAt = createdAt;
	}





	public User() {
		super();
	}





	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	
	public String getUserLastName() {
		return userLastName;
	}





	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}





	public String getUserDob() {
		return userDob;
	}
	public void setUserDob(String userDob) {
		this.userDob = userDob;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}





	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userDob=" + userDob + ", userGender=" + userGender + ", userEmail=" + userEmail + ", role=" + role
				+ ", userPassword=" + userPassword + ", userMobile=" + userMobile + ", userAddress=" + userAddress
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	




	
	

}
