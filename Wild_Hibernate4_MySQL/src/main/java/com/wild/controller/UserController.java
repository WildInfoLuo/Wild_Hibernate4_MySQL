package com.wild.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wild.entity.User;
import com.wild.service.UserManagerService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserManagerService managerService;

	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request) {
		request.setAttribute("userList", managerService.getAllUser());
		return "index";
	}

	@RequestMapping("/getUser")
	public String getUser(String id, HttpServletRequest request) {
		request.setAttribute("user", managerService.getUser(id));
		return "editUser";
	}

	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "addUser";
	}

	@RequestMapping("/addUser")
	public String addUser(User user, HttpServletRequest request) {
		 managerService.addUser(user);
		return "redirect:/user/getAllUser";
	}

	@RequestMapping("/delUser")
	public void delUser(String id, HttpServletResponse response) {

		String result = "{\"result\":\"error\"}";

		if (managerService.delUser(id)) {
			result = "{\"result\":\"success\"}";
		}

		response.setContentType("application/json");

		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/updateUser")
	public String updateUser(User user, HttpServletRequest request) {

		if (managerService.updateUser(user)) {
			user = managerService.getUser(user.getId());
			request.setAttribute("user", user);
			return "redirect:/user/getAllUser";
		} else {
			return "error";
		}
	}
}
