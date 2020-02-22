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

import com.psm.daoapi.DaoApi;
import com.psm.entities.EnquiryBean;
import com.psm.entities.MenuItemsBean;
import com.psm.entities.StudentBean;
import com.psm.entities.UserBean;

@Transactional
@Repository
@SuppressWarnings("unchecked")
public class DaoImpl implements DaoApi {

	@Autowired
	SessionFactory sessionFactory;

	protected final static Log log = LogFactory.getLog(DaoImpl.class);

	@SuppressWarnings("unchecked")
	public UserBean getUserByUsername(String username) {

		if (username == null) {
			return null;
		}

		List<UserBean> list = new ArrayList<UserBean>();

		list = sessionFactory.getCurrentSession().createQuery("from UserBean where userUserName=:username")
				.setParameter("username", username).list();

		if (list.size() > 0) {
			return list.get(0);
		}
		/// return null;
		return new UserBean();
	}

	public List<UserBean> users() {
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

	public List<MenuItemsBean> getUrlByRoles(List<String> roleId) {

		try {
			String hql = "SELECT DISTINCT mi.menu_url, mi.menu_name from menu_items mi\r\n"
					+ "JOIN roles_menu_items_mappings umi \r\n" + "on mi.menu_id = umi.menu_id\r\n"
					+ "WHERE umi.role_id in (:roleId)";

			@SuppressWarnings("unchecked")
			List<Object[]> list = sessionFactory.getCurrentSession().createSQLQuery(hql)
					.setParameterList("roleId", roleId).list();

			List<MenuItemsBean> returnList = new ArrayList();
			for (Object[] obj : list) {
				MenuItemsBean bean = new MenuItemsBean();
				bean.setMenuUrl(obj[0].toString());
				bean.setMenuName(obj[1].toString());
				returnList.add(bean);

			}
			return returnList;

		} catch (Exception e) {
			log.info(e);
		}
		return null;
	}

	public boolean saveEnquieryDetails(EnquiryBean bean) {
		try {
			String loggedUserName = bean.getUserName();

			Query query = sessionFactory.getCurrentSession()
					.createQuery("select u.user_id from UserBean u where u.userUserName=:loggedUserName");
			query.setParameter("loggedUserName", loggedUserName);
			int loggedUserId = (Integer) query.uniqueResult();

			bean.setCreated_by(loggedUserId);
			// save enquiry
			sessionFactory.getCurrentSession().save(bean);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<String> getCitiesForState(int id) {
		try {
		List<String> list = sessionFactory.getCurrentSession().createQuery("from CityBean where state_id=:id").setParameter("id", id).list();
		return list;
	}
		catch (Exception e) {
			return null;
		}
	}

	public List<String> getStates() {
		try {
			List<String> list = sessionFactory.getCurrentSession().createQuery("from StateBean").list();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public String getLoggedInUserName(String loggedInUserName) {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("select userName from UserBean  where userUserName=:loggedInUserName")
				.setParameter("loggedInUserName", loggedInUserName);
		String UserName = (String) query.uniqueResult();
		return UserName;
	}

	public EnquiryBean searchEnquiryDetails(String searchKey, String searchValue) {
		
		Query query;
		if ("mobileNo".equals(searchKey)) {
			query = sessionFactory.getCurrentSession().createQuery("from EnquiryBean where mobileNo=:searchValue")
					.setParameter("searchValue", searchValue);

		} else { // earch by enquiryID
			Integer searchEnquiryId = Integer.parseInt(searchValue);
			query = sessionFactory.getCurrentSession()
					.createQuery("from EnquiryBean where enquiry_id=:searchEnquiryId")
					.setParameter("searchEnquiryId", searchEnquiryId);
		}

		EnquiryBean getDetails = (EnquiryBean) query.uniqueResult();
		
		if(getDetails == null)
				return null;
		
		// code to fetch enquiry createdBy user's name
		int createdById = getDetails.getCreated_by();

		query = sessionFactory.getCurrentSession()
				.createQuery("select userName from UserBean where user_id=:createdById")
				.setParameter("createdById", createdById);
		String createdByUserName = (String) query.uniqueResult();
		
		getDetails.setUserName(createdByUserName);

		return getDetails;
	}

	public boolean updateEnquiry(EnquiryBean bean) {
		try {
			sessionFactory.getCurrentSession().update(bean);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
