package com.psm.daoapi;

import java.util.List;

import com.psm.entities.StudentBean;
import com.psm.entities.UserBean;

public interface DaoApi {

	public UserBean getUserByUsername(String username);
	public List<UserBean> users();
	public boolean addStudent(StudentBean bean);
}
