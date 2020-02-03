package com.psm.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@GeneratedValue
	@Column(name="role_id")
	private int roleId;

	@Column(name = "role_name")
	private String roleName;

/*	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="roles_menu_items_mappings", 
				joinColumns= {@JoinColumn(name="role_id")},
				inverseJoinColumns= {@JoinColumn(name="menu_id")})
	private Set<MenuItemsBean> menuItems;*/

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
}
