package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mvc.daoapi.DaoApi;

@Controller
public class MainController {

	@Autowired
	DaoApi dao;
	
	@GetMapping("/users")
	public String getUsers() {
		List list =dao.users();
		System.out.println(list);
		return "users";
	}
	
}
