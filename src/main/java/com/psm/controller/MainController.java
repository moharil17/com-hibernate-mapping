package com.psm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.psm.daoapi.DaoApi;
import com.psm.entities.StudentBean;

@Controller
public class MainController {

	@Autowired
	DaoApi dao;
	
	@GetMapping("/homePage")
	public String getHomePage() {

		return "homePage";
	}
	
	@GetMapping("/enquiery")
	public String getenquieryPage() {
		users(12); 
		return "enquiery";
	}
	
	@GetMapping("/addstudent")
	public String viewAddStudent() {
		return "addstudent";
	}
  @PostMapping("/addStudent")
  public String addStudent(@ModelAttribute StudentBean bean)
  {
	  boolean b = dao.addStudent(bean);
	  if(b) {
		  return "success";
	  }
	  return "failure";
  }
  
  public void users(int i) {
	  System.out.println("I am called... "+i);
	 System.out.println("\n\n\n"+dao.users());
  }
  
  @GetMapping("/getNavigationMenuItems")
  public ResponseEntity fetchNavigationMenuItems() {
	  return new ResponseEntity<Object>(HttpStatus.OK);
  }

}


