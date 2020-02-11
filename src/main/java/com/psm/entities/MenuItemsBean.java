package com.psm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu_items")
public class MenuItemsBean {

	@Id
	@GeneratedValue
	private int menu_id;
	
	@Column(name="menu_name")
	private String menuName;
	
	@Column(name="menu_url")
	private String menuUrl;

	
	public MenuItemsBean() {
		
	}
	public MenuItemsBean(String menuName, String menuUrl) {
		super();
		this.menuName = menuName;
		this.menuUrl = menuUrl;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	@Override
	public String toString() {
		return "MenuItemsBean [menu_id=" + menu_id + ", menuName=" + menuName + ", menuUrl=" + menuUrl + "]";
	}
	
	
}
