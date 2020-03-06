package com.psm.daoapi;

import java.util.List;

import com.psm.entities.AdmissionBean;
import com.psm.entities.EnquiryBean;
import com.psm.entities.FeesDetails;
import com.psm.entities.MenuItemsBean;
import com.psm.entities.StudentBean;
import com.psm.entities.UserBean;
import com.psm.entities.table;

public interface DaoApi {

	public UserBean getUserByUsername(String username);

	public List<UserBean> users();

	public boolean addStudent(StudentBean bean);

	public List<MenuItemsBean> getUrlByRoles(List<String> roleId);

	public boolean saveEnquieryDetails(EnquiryBean bean);

	public List<String> getCitiesForState(int id);

	public List<String> getStates();

	public String getLoggedInUserName(String loggedInUserName);

	public EnquiryBean searchEnquiryDetails(String searchKey, String searchValue);

	public boolean updateEnquiry(EnquiryBean bean);

	public boolean saveAdmission(AdmissionBean bean);

	public double fetchFeesForStandard(int standard);

	public int getAllowedDiscount(String userName, int roleId);

	public FeesDetails getDeclaredFeeAndStandard(int StudentId, int standard);

	public boolean saveFee(FeesDetails bean);
}