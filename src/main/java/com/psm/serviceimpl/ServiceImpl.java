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

		List<String> list = new ArrayList();
		Iterator i = role.iterator();
		while (i.hasNext()) {
			String str = i.next().toString();
			list.add(str);
		}

		log.info("dd : " + list);

		Iterator it = list.iterator();
		List list1 = new ArrayList();
		while (it.hasNext()) {
			String str = (String) it.next();
			String str1[] = str.split("_");
			for (int k = 0; k < str1.length; k++) {
				if (k == 1) {
					list1.add(str1[k]);
				}
			}
		}
		log.info(list1);
		List<MenuItemsBean> listOfUrl = dao.getUrlByRoles(list1);
		return listOfUrl;

	}

	public boolean saveEnquiryDetails(EnquiryBean bean) {

		return dao.saveEnquieryDetails(bean);
	}
}
