package com.psm.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psm.daoapi.DaoApi;
import com.psm.entities.StudentBean;
import com.psm.entities.UserBean;
import com.psm.serviceimpl.CustomUserDetailsService;

@Transactional
@Repository
public class DaoImpl implements DaoApi {

	@Autowired
	SessionFactory sessionFactory;

	protected final static Log log = LogFactory.getLog(DaoImpl.class);
	
	public UserBean getUserByUsername(String username) {
		
		if (username == null) {
			return null;
		}
		
		List<UserBean> list = new ArrayList<UserBean>();
		log.info("Username in dao "+username);
		list = sessionFactory.getCurrentSession().createQuery("from UserBean where userUserName=:username")
				.setParameter("username", username).list();

		log.info(11);
		if(list.size() > 0) {
			log.info(22);
			log.info(list.get(0).getRoles().iterator().next().getMenuItems().iterator().next());
			return list.get(0);
		}
		///return null;
		return new UserBean();
	}
	
	public List<UserBean> users() {
		@SuppressWarnings("unchecked")
		Query q = sessionFactory.getCurrentSession().createQuery("from UserBean where user_id=:id");
		q.setInteger("id", 1);
		List<UserBean> l = q.list();
		return l;
	}

	public boolean addStudent(StudentBean bean) {

		try {
			sessionFactory.getCurrentSession().persist(bean);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
