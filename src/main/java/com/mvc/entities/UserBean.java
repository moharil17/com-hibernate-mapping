package com.mvc.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserBean {

	@Id
	@GeneratedValue
	private int user_id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_username")
	private String userUserName;

	@Column(name = "user_email")
	private String userEmail;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_roles_mapping", 
				joinColumns= {@JoinColumn(name="user_id")},
				inverseJoinColumns= {@JoinColumn(name="role_id")})
	private Set<UserRole> roles;
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserUserName() {
		return userUserName;
	}

	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "UserBean [user_id=" + user_id + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userUserName=" + userUserName + ", userEmail=" + userEmail + ", roles=" + roles + "]";
	}
	
	

}
