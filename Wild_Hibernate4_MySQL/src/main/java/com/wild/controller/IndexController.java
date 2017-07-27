package com.wild.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wild.entity.ShareData;
import com.wild.service.ShareDataService;

@Controller
@RequestMapping("/user")
public class IndexController {
	@Autowired
	private ShareDataService shareDataService;
	
	@RequestMapping(value = "/logins", method = RequestMethod.POST)
	public String testInDb(Model model) {
		System.out.println("你好啊");
		ShareData shareData = new ShareData();
		shareData.setShareCode("00023");
		shareData.setShareName("坚持");
		shareData.setShareType("SZ");
		Serializable result = shareDataService.insertData(shareData);
		model.addAttribute("result", result);
		return "/index";
	}
	
	
	
}
