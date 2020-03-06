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
import com.psm.entities.AdmissionBean;
import com.psm.entities.EnquiryBean;
import com.psm.entities.FeesDetails;
import com.psm.entities.MenuItemsBean;
import com.psm.entities.StudentBean;
import com.psm.entities.UserBean;
import com.psm.serviceapi.ServiceApi;

@Service
public class ServiceImpl implements ServiceApi {

	@Autowired
	DaoApi dao;
	protected final static Log log = LogFactory.getLog(ServiceImpl.class);

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
			// roleString = roleString.substring(4);
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

	public EnquiryBean searchEnquiryDetails(String searchKey, String searchValue) {

		return dao.searchEnquiryDetails(searchKey, searchValue);
	}

	public boolean updateEnquiry(EnquiryBean bean) {

		return dao.updateEnquiry(bean);
	}

	public String saveAdmission(AdmissionBean bean) {
		double feesInputFomUser = bean.getTotalFees();
		int standard = bean.getAdmssnToClass();

		double declearedFeesForStandrad = dao.fetchFeesForStandard(standard);
		boolean isvaliated = false;
		if (declearedFeesForStandrad > 0 && feesInputFomUser <= declearedFeesForStandrad) {
			// Calculate Discount

			int requestedDiscount = (int) (((declearedFeesForStandrad - feesInputFomUser) / declearedFeesForStandrad)
					* 100);
			String userName = bean.getUserName();
			List list = bean.getRoleList();

			List<Integer> roleIDs = new ArrayList();
			Iterator i = list.iterator();

			while (i.hasNext()) {

				String roleString = i.next().toString();
				// roleString = roleString.substring(4);
				roleString = roleString.substring(roleString.indexOf('_') + 1, roleString.length());
				int roleId = Integer.parseInt(roleString);
				roleIDs.add(roleId);
			}
			int roleId = roleIDs.get(0);

			int allowedDiscount = dao.getAllowedDiscount(userName, roleId);
			if (requestedDiscount <= allowedDiscount) {
				isvaliated = true;
			} else

				return "Discount Limit Crossed";

		} else {
			return "fess shoud be less than decleared Fees";
		}

		if (isvaliated) {
			dao.saveAdmission(bean);
			return "successfullySaved";
		}
		return "falied";
	}

	public String feePayment(FeesDetails feesDetailsBean) {

		double payingFee = feesDetailsBean.getPaidFees();
		int studentId = feesDetailsBean.getStudent_id();
		int standard = feesDetailsBean.getStandard();

		FeesDetails details = dao.getDeclaredFeeAndStandard(studentId, standard);

		double AlreadyPaidfee = details.getPaidFees();
		double standardFeeApplied = details.getTotalFees();

		double sumOfPayingFeeAndAlreadyPaid = payingFee + AlreadyPaidfee;

		if (sumOfPayingFeeAndAlreadyPaid <= standardFeeApplied) {
			feesDetailsBean.setPaidFees(sumOfPayingFeeAndAlreadyPaid);
			feesDetailsBean.setStudent_id(studentId);
			dao.saveFee(feesDetailsBean);
			return "Payment SuccessFull";
		} else if (sumOfPayingFeeAndAlreadyPaid > standardFeeApplied) {
			double remainingAmountToBePaid = standardFeeApplied - AlreadyPaidfee;
			String RemainingAmountToBePaid = Double.toString(remainingAmountToBePaid);
			return RemainingAmountToBePaid;
		}
		return "PaymentFailed";
	}
}