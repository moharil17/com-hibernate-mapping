package com.psm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		  System.out.println("akjfhsdfh");
		  return "success";
	  }
	  return "failure";
  }
	
	
}


