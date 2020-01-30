package com.psm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psm.daoapi.DaoApi;
import com.psm.entities.StudentBean;
import com.psm.entities.UserBean;
import com.psm.serviceapi.ServiceApi;

@Service
public class ServiceImpl implements ServiceApi{

	@Autowired
	DaoApi dao;
	public UserBean getUserByUsername(String username) {
		
		return dao.getUserByUsername(username);
	}

	public List<UserBean> users() {
		
		return dao.users();
	}

	public boolean addStudent(StudentBean bean) {
		
		return dao.addStudent(bean);
	}
	
	

}
