package com.psm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.psm.daoapi.DaoApi;

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
	
}
