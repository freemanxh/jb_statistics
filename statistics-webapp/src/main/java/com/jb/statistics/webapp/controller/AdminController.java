package com.jb.statistics.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jb.statistics.webapp.controller.forms.CountForm;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@RequestMapping(value = "/login.do")
	public String click(HttpServletRequest request, HttpServletResponse response, Model model, CountForm form) {

		return "admin/index";
	}
	
	@RequestMapping(value = "/index/left.do")
	public String left(HttpServletRequest request, HttpServletResponse response, Model model, CountForm form) {

		return "admin/left";
	}
	
	@RequestMapping(value = "/index/center.do")
	public String center(HttpServletRequest request, HttpServletResponse response, Model model, CountForm form) {

		return "admin/center";
	}

	
}
