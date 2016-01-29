package com.jb.statistics.webapp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jb.statistics.webapp.controller.forms.CountForm;
import com.jb.statistics.webapp.service.CountClickFunctionsService;
import com.jb.statistics.webapp.service.CountClickService;
import com.jb.statistics.webapp.service.CountNewUserService;
import com.jb.statistics.webapp.service.ProjectService;
import com.jb.statistics.webapp.view.ClickFunctionsView;
import com.jb.statistics.webapp.view.ClickView;
import com.jb.statistics.webapp.view.NewUserView;
import com.jb.statistics.webapp.view.entities.ProjectEntity;

@Controller
@RequestMapping(value = "/userlogs")
public class CountUserLogController {

	@Autowired
	private CountClickService countClickService;

	@Autowired
	private CountClickFunctionsService countClickFunctionsService;

	@Autowired
	private CountNewUserService countNewUserService;

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/click.do")
	public String click(HttpServletRequest request, HttpServletResponse response, Model model, CountForm form) {
		if (StringUtils.isBlank(form.getStartDate()) || StringUtils.isBlank(form.getEndDate()) || StringUtils.isBlank(form.getProjectId())) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_YEAR, -1);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String startDate = df.format(new Date(c.getTimeInMillis()));
			c.add(Calendar.DAY_OF_YEAR, 1);
			String endDate = df.format(new Date(c.getTimeInMillis()));
			form.setStartDate(startDate);
			form.setEndDate(endDate);
		}

		// } else {

		if ("0".equals(form.getProjectId())) {
			form.setProjectId(null);
		}

		ClickView v = this.countClickService.buildClickView(form.getStartDate(), form.getEndDate(), form.getProjectId());
		model.addAttribute("view", v);
		this.setModel(form, model);
		List<ProjectEntity> list = this.projectService.listProjects();
		model.addAttribute("projects", list);
		return "admin/click/index";
	}

	@RequestMapping(value = "/clickFunctions.do")
	public String clickFunctions(HttpServletRequest request, HttpServletResponse response, Model model, CountForm form) {
		
		if (StringUtils.isBlank(form.getStartDate()) || StringUtils.isBlank(form.getEndDate()) || StringUtils.isBlank(form.getProjectId())) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_YEAR, -1);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String startDate = df.format(new Date(c.getTimeInMillis()));
			c.add(Calendar.DAY_OF_YEAR, 1);
			String endDate = df.format(new Date(c.getTimeInMillis()));
			form.setStartDate(startDate);
			form.setEndDate(endDate);
		}
		
		if ("0".equals(form.getProjectId())) {
			form.setProjectId(null);
		}
		ClickFunctionsView v = this.countClickFunctionsService.buildClickFuncitonsView(form.getStartDate(), form.getEndDate(), form.getProjectId());
		model.addAttribute("view", v);
		this.setModel(form, model);

		List<ProjectEntity> list = this.projectService.listProjects();
		model.addAttribute("projects", list);
		return "admin/clickfunctions/index";
	}

	@RequestMapping(value = "/newUsers.do")
	public String newUser(HttpServletRequest request, HttpServletResponse response, Model model, CountForm form) {
		
		if (StringUtils.isBlank(form.getStartDate()) || StringUtils.isBlank(form.getEndDate()) || StringUtils.isBlank(form.getProjectId())) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_YEAR, -1);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String startDate = df.format(new Date(c.getTimeInMillis()));
			c.add(Calendar.DAY_OF_YEAR, 1);
			String endDate = df.format(new Date(c.getTimeInMillis()));
			form.setStartDate(startDate);
			form.setEndDate(endDate);
		}
		
		if ("0".equals(form.getProjectId())) {
			form.setProjectId(null);
		}
		NewUserView v = this.countNewUserService.buildNewUserView(form.getStartDate(), form.getEndDate(), form.getProjectId());
		model.addAttribute("view", v);
		this.setModel(form, model);

		List<ProjectEntity> list = this.projectService.listProjects();
		model.addAttribute("projects", list);
		return "admin/newUsers/index";
	}

	private void setModel(CountForm form, Model model) {
		model.addAttribute("startDate", form.getStartDate());
		model.addAttribute("endDate", form.getEndDate());
		String projectId = form.getProjectId() == null ? "0" : form.getProjectId();
		model.addAttribute("projectId", projectId);
	}

}
