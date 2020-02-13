package com.psm.serviceapi;

import java.util.List;

import com.psm.entities.EnquiryBean;
import com.psm.entities.MenuItemsBean;
import com.psm.entities.StudentBean;
import com.psm.entities.UserBean;

public interface ServiceApi {

	public UserBean getUserByUsername(String username);

	public List<UserBean> users();

	public boolean addStudent(StudentBean bean);

	public List<MenuItemsBean> getUrlByRoles(List<String> roleId);

	public boolean saveEnquiryDetails(EnquiryBean bean);
	
	public List<String> getCityNames(int id);
	
	public List<String> getStateNames();
}
