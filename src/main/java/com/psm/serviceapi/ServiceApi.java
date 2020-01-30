package com.psm.serviceapi;

import java.util.List;

import com.psm.entities.StudentBean;
import com.psm.entities.UserBean;

public interface ServiceApi {

	public UserBean getUserByUsername(String username);
	public List<UserBean> users();
	public boolean addStudent(StudentBean bean);
}
