package com.psm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psm.daoapi.DaoApi;
import com.psm.entities.AdmissionBean;
import com.psm.entities.CityBean;
import com.psm.entities.EnquiryBean;
import com.psm.entities.FeesDetails;
import com.psm.entities.MenuItemsBean;
import com.psm.entities.StateBean;
import com.psm.entities.table;
import com.psm.serviceapi.ServiceApi;

@Controller
@SuppressWarnings("unchecked")
public class MainController {

	protected final static Log log = LogFactory.getLog(MainController.class);

	@Autowired
	ServiceApi service;

	@Autowired
	DaoApi dao;

	@GetMapping("/homePage")
	public String getHomePage() {

		return "homePage";
	}

	@GetMapping("/loginPage")
	public String getLoginPage() {

		return "loginPage";
	}

	@GetMapping("/enquiery")
	public String getEnquieryPage() {

		return "enquiery";
	}

	// save enquiery form using ajax
	@PostMapping("/createNewEnquiery")
	public ResponseEntity<String> saveEnquiryeDetails(@ModelAttribute EnquiryBean bean) {

		Date todayDateTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String todayDateTimeString = sdf.format(todayDateTime);
		bean.setEnquiryDate(todayDateTimeString);

		// to save role id
		bean.setUserName(getSecurityContextAuth().getName());

		boolean isSaved = service.saveEnquiryDetails(bean);
		if (isSaved)
			return new ResponseEntity<String>("Enquiry saved successfully", HttpStatus.CREATED);

		return new ResponseEntity<String>("Saving failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// fetch cities on stateID
	@GetMapping("/getCityList/{stateId}")
	public @ResponseBody List<CityBean> getCitiesForState(@PathVariable int stateId) {

		List list = service.getCitiesForState(stateId);
		return list;
	}

	@GetMapping("/getStateListinfo")
	public @ResponseBody List<StateBean> getStates() {
		// to send cityList to view
		List list = service.getStates();
		return list;
	}

	@GetMapping("/getNavigationMenuItems")
	public @ResponseBody List<MenuItemsBean> fetchNavigationMenuItems() {

		List<String> list = (List) getSecurityContextAuth().getAuthorities(); // loggedUserInfo()

		// Sending logged in user's roles to DAO and gets back respective Menu Items
		List<MenuItemsBean> list1 = service.getUrlByRoles(list);
		return list1;
	}

	// fetch logged-in user's roles from spring security context
	private List<String> loggedInUserRoles() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<String> list = (List) authentication.getAuthorities();

		return list;
	}

	// Display name in nav bar
	@GetMapping("/getLoggedInUserName")
	public @ResponseBody String displayLoggedInUserName() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// we will get userUserName...
		String loggedInUserName = authentication.getName();
		String loggedInUserNameToDisplay = service.getLoggedInUserName(loggedInUserName);
		return loggedInUserNameToDisplay;
	}

	/**
	 * searchEnquieryDetails:
	 * 
	 * Good request:
	 * "http://localhost:8080/com-hibernate-mapping/searchEnquiry/enquiryId/95" But
	 * if user clicks search w/t entering search value, request will come like -
	 * "http://localhost:8080/com-hibernate-mapping/searchEnquiry/enquiryId/" So we
	 * have to handle this also. hence taken two URL patterns in request mapping
	 * 
	 */
	@GetMapping(value = { "searchEnquiry/{searchKey}/{searchValue}", "searchEnquiry/{searchKey}" })
	public ResponseEntity<EnquiryBean> searchEnquieryDetails(@PathVariable String searchKey,
			@PathVariable(required = false) String searchValue) {

		if (searchValue == null)
			return new ResponseEntity("Enter search value", HttpStatus.BAD_REQUEST);
		if ("enquiryId".equals(searchKey) && searchValue.length() > 5)
			return new ResponseEntity("Enquiery ID length violated", HttpStatus.NOT_ACCEPTABLE);

		EnquiryBean bean = service.searchEnquiryDetails(searchKey, searchValue);

		if (bean != null)
			return new ResponseEntity(bean, HttpStatus.OK);
		return new ResponseEntity("No results found", HttpStatus.NOT_IMPLEMENTED);
	}

	@PostMapping("/saveAdmission")
	public ResponseEntity<String> saveAdmission(@ModelAttribute AdmissionBean bean) {
		String userName = getSecurityContextAuth().getName();
		List listOfRole = (List) getSecurityContextAuth().getAuthorities();
		bean.setUserName(userName);
		bean.setRoleList(listOfRole);
		String result = service.saveAdmission(bean);
		log.info(result);
		if (result == "successfullySaved") {

			return new ResponseEntity<String>("Saved Successfully", HttpStatus.CREATED);
		} else if (result == "fess shoud be less than decleared Fees") {
			return new ResponseEntity<String>("please Enter Valid Fees", HttpStatus.BAD_REQUEST);
		} else if (result == "Discount Limit Crossed") {
			return new ResponseEntity<String>("Discount Not Allowed", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Error Saving Admission", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/payment")
	public ResponseEntity<String> feePayment(@ModelAttribute FeesDetails feeDetailBean) {

		String result = service.feePayment(feeDetailBean);

		if (result.equals("Payment SuccessFull"))
			return new ResponseEntity<String>("payment successfull", HttpStatus.OK);

		else if (result.equals("PaymentFailed"))
			return new ResponseEntity<String>("payment fail", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<String>("This much Fees Remaning to be Paid " + result, HttpStatus.OK);
	}

	private Authentication getSecurityContextAuth() {

		return SecurityContextHolder.getContext().getAuthentication();
	}

	@ExceptionHandler
	public String exceptionHandlerMethod(HttpServletRequest req, Exception e) {
		log.info("Requsest ==> " + req.getRequestURI() + " " + e);
		e.printStackTrace();

		return "homePage";
	}
}