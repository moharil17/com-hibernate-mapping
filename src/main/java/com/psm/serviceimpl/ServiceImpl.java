package com.psm.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psm.daoapi.DaoApi;
import com.psm.daoimpl.DaoImpl;
import com.psm.entities.EnquiryBean;
import com.psm.entities.MenuItemsBean;
import com.psm.entities.StudentBean;
import com.psm.entities.UserBean;
import com.psm.serviceapi.ServiceApi;

@Service
public class ServiceImpl implements ServiceApi {

	@Autowired
	DaoApi dao;
	protected final static Log log = LogFactory.getLog(DaoImpl.class);

	public UserBean getUserByUsername(String username) {

		return dao.getUserByUsername(username);
	}

	public List<UserBean> users() {

		return dao.users();
	}

	public boolean addStudent(StudentBean bean) {

		return dao.addStudent(bean);
	}

	public List<MenuItemsBean> getUrlByRoles(List<String> role) {

		List<String> roleIDs = new ArrayList();
		Iterator i = role.iterator();
		
		while (i.hasNext()) {
			
			String roleString = i.next().toString();
		//	roleString = roleString.substring(4);
			roleString = roleString.substring(roleString.indexOf('_') + 1, roleString.length());
			roleIDs.add(roleString);
		}

		List<MenuItemsBean> listOfUrl = dao.getUrlByRoles(roleIDs);
		return listOfUrl;

	}

	public boolean saveEnquiryDetails(EnquiryBean bean) {

		return dao.saveEnquieryDetails(bean);
	}

	public List<String> getCitiesForState(int id) {
		
		return dao.getCitiesForState(id);
	}
	
	public List<String> getStates() {
		return dao.getStates();
	}
	
public String getLoggedInUserName(String loggedInUserName) {
		
		return dao.getLoggedInUserName(loggedInUserName);

	}

	public EnquiryBean searchEnquiryDetails(String searchKey,String searchValue,String getUser) {
		
		return dao.searchEnquiryDetails(searchKey,searchValue,getUser);
	}

	public boolean updateEnquiry(EnquiryBean bean) {
		
		return dao.updateEnquiry(bean);
	}
}
