package com.mvc.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.daoapi.DaoApi;
import com.mvc.entities.UserBean;

@Transactional
@Repository
public class DaoImpl implements DaoApi {

	@Autowired
	SessionFactory sessionFactory;

	public List<UserBean> users() {
		List list = sessionFactory.getCurrentSession().createQuery("from UserBean").list();
		return list;
	}
	
	
}
