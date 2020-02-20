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

import com.psm.entities.CityBean;
import com.psm.entities.EnquiryBean;
import com.psm.entities.MenuItemsBean;
import com.psm.entities.StateBean;
import com.psm.serviceapi.ServiceApi;

@Controller
@SuppressWarnings("unchecked")
public class MainController {

	protected final static Log log = LogFactory.getLog(MainController.class);

	@Autowired
	ServiceApi service;

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

		List<String> list = (List)getSecurityContextAuth().getAuthorities(); //loggedUserInfo()

		//Sending logged in user's roles to DAO and gets back respective Menu Items
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

	@GetMapping("searchEnquiry/{searchKey}/{searchValue}")
	public @ResponseBody EnquiryBean searchEnquieryDetails(@PathVariable String searchKey, @PathVariable String searchValue) {
		
		EnquiryBean bean = service.searchEnquiryDetails(searchKey, searchValue);
		return bean;
	}

	public boolean updateEnquiry() {
		EnquiryBean bean = new EnquiryBean();
		Date todayDateTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String todayDateTimeString = sdf.format(todayDateTime);
		bean.setEnquiryDate(todayDateTimeString);
		bean.setEnquiry_id(68);
		bean.setAdmssnToClass(2);
		bean.setCity("bhilai");
		bean.setEmailId("renu@gmail.com");
        
		bean.setFirstName("radha");
		bean.setGender("female");
		bean.setLastName("moharil");
		bean.setMobileNo("7083913648");
		bean.setPrevYrMarks(80);
		// bean.setState("chhattisgarh");
		// bean.setUserName("");
		bean.setZip("85768476");
		bean.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		log.info(bean);
		boolean isUpdated = service.updateEnquiry(bean);
		return true;
	}

	private Authentication getSecurityContextAuth() {
		
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@ExceptionHandler
	public String exceptionHandlerMethod(HttpServletRequest req, Exception e) {
		log.info("Requsest ==> " + req.getRequestURI() +" "+ e);
		e.printStackTrace();

		return "homePage";
	}

}
