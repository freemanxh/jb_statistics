package com.jb.statistics.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jb.statistics.webapp.controller.forms.CountForm;
import com.jb.statistics.webapp.service.ProjectService;
import com.jb.statistics.webapp.view.entities.ProjectEntity;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/login.do")
	public String click(HttpServletRequest request, HttpServletResponse response, Model model, CountForm form) {
		List<ProjectEntity> list = this.projectService.listProjects();
		model.addAttribute("projects", list);
		return "admin/index";
	}

	@RequestMapping(value = "/index/left.do")
	public String left(HttpServletRequest request, HttpServletResponse response, Model model, CountForm form) {
		return "admin/left";
	}

	@RequestMapping(value = "/index/center.do")
	public String center(HttpServletRequest request, HttpServletResponse response, Model model, CountForm form) {
		List<ProjectEntity> list = this.projectService.listProjects();
		model.addAttribute("projects", list);
		return "admin/center";
	}

}
