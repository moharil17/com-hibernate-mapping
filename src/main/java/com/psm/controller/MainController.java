package com.psm.controller;

import java.util.Calendar;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psm.daoapi.DaoApi;

import com.psm.entities.EnquiryBean;
import com.psm.entities.MenuItemsBean;
import com.psm.entities.StudentBean;

import com.psm.serviceapi.ServiceApi;

@Controller
@SuppressWarnings("unchecked")
public class MainController {

	protected final static Log log = LogFactory.getLog(MainController.class);

	@Autowired
	DaoApi dao;
	@Autowired
	ServiceApi service;

	@GetMapping("/homePage")
	public String getHomePage() {

		getEnquieryPage();
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
	@PostMapping("/enquiery")
	public ResponseEntity<String> enquiryeDetails(@ModelAttribute EnquiryBean bean) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		bean.setDate(date);
		// to save role id
		bean.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());

		log.info(bean.getCity());

		boolean b = service.saveEnquiryDetails(bean);
		if (b) {
			return new ResponseEntity<String>("Enquiry saved successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Saving failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/addstudent")
	public String viewAddStudent() {
		return "addstudent";
	}

	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute StudentBean bean) {
		boolean b = dao.addStudent(bean);
		if (b) {
			return "success";
		}
		return "failure";
	}

	// role based navigation menu using ajax call
	@GetMapping("/getNavigationMenuItems")
	public @ResponseBody List<MenuItemsBean> fetchNavigationMenuItems() {

		List<String> list = loggedUserInfo();

		List<MenuItemsBean> list1 = service.getUrlByRoles(list);
		log.info(("inside controller :  " + list1));
		MenuItemsBean m = new MenuItemsBean();
		m.setMenuName("user");
		m.setMenuUrl("user");
		return list1;
	}

	// fetch logged in user using spring security
	public List<String> loggedUserInfo() {
		Authentication authentication;
		authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		log.info(userName);
		authentication.getCredentials();
		
		List<String> list = (List) authentication.getAuthorities();

		System.out.println(list);
		return list;
	}

	@ExceptionHandler
	public String exceptionHandlerMethod(HttpServletRequest req, Exception e) {
		log.info("Requsest " + req.getRequestURI() + e);

		return "homePage";
	}

}