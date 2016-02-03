package com.jb.statistics.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jb.statistics.webapp.controller.forms.CountForm;
import com.jb.statistics.webapp.service.ProjectService;
import com.jb.statistics.webapp.view.ClickFunctionsView;
import com.jb.statistics.webapp.view.ClickView;
import com.jb.statistics.webapp.view.JsonModelAndView;
import com.jb.statistics.webapp.view.NewUserView;
import com.jb.statistics.webapp.view.entities.ClickEntity;
import com.jb.statistics.webapp.view.entities.ClickFunctionEntity;
import com.jb.statistics.webapp.view.entities.UserCountEntity;
import com.jb.statistics.webapp.view.result.ClickFunctionsResult;
import com.jb.statistics.webapp.view.result.ClickResult;
import com.jb.statistics.webapp.view.result.NewUsersResult;
import com.jb.statistics.webapp.view.result.jsonentities.ClickFunctionsJsonEntity;
import com.jb.statistics.webapp.view.result.jsonentities.ClickJsonEntity;
import com.jb.statistics.webapp.view.result.jsonentities.NewUserJsonEntity;
import com.jb.statistics.webapp.view.result.jsonentities.NewUserResultView;

@Controller
@RequestMapping(value = "/userlogsjson")
public class CountUserLogJsonController extends CountUserLogController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/clickJson.do", method = RequestMethod.POST)
	public ModelAndView clickJson(HttpServletRequest request, HttpServletResponse response, Model model, @RequestBody CountForm form) {
		validateParams(form);

		ClickView v = this.countClickService.buildClickView(form.getStartDate(), form.getEndDate(), form.getProjectId());
		ClickResult cr = new ClickResult();
		if (v != null) {
			List<ClickEntity> list = v.getList();
			List<ClickJsonEntity> result = new ArrayList<ClickJsonEntity>();
			if (list != null) {
				for (ClickEntity ce : list) {
					if (ce != null) {
						ClickJsonEntity cje = new ClickJsonEntity();
						cje.setData(String.valueOf(ce.getTimes()));
						cje.setTime(ce.getTimeSeg());
						result.add(cje);
					}
				}
			}
			cr.setResult(result);
		}

		return new JsonModelAndView(cr);
	}

	@RequestMapping(value = "/clickFunctionsJson.do", method = RequestMethod.POST)
	public ModelAndView clickFunctionsJson(HttpServletRequest request, HttpServletResponse response, Model model, @RequestBody CountForm form) {

		validateParams(form);

		ClickFunctionsView v = this.countClickFunctionsService.buildClickFuncitonsView(form.getStartDate(), form.getEndDate(), form.getProjectId());
		ClickFunctionsResult cfr = new ClickFunctionsResult();

		if (v != null) {
			List<ClickFunctionEntity> list = v.getFunctionList();
			List<ClickFunctionsJsonEntity> result = new ArrayList<ClickFunctionsJsonEntity>();

			if (list != null) {
				for (ClickFunctionEntity ce : list) {
					if (ce != null) {
						ClickFunctionsJsonEntity cje = new ClickFunctionsJsonEntity();
						cje.setName(ce.getFunctionName());
						cje.setValue(String.valueOf(ce.getTimes()));
						cje.setPercent(ce.getPercent());
						result.add(cje);
					}
				}
			}
			cfr.setResult(result);
		}

		return new JsonModelAndView(cfr);
	}

	@RequestMapping(value = "/newUsersJson.do", method = RequestMethod.POST)
	public ModelAndView newUserJson(HttpServletRequest request, HttpServletResponse response, Model model, @RequestBody CountForm form) {

		validateParams(form);

		NewUserView v = this.countNewUserService.buildNewUserView(form.getStartDate(), form.getEndDate(), form.getProjectId());

		NewUsersResult nur = new NewUsersResult();

		NewUserResultView nurv = new NewUserResultView();

		NewUserJsonEntity nuje = new NewUserJsonEntity();

		if (v != null) {
			UserCountEntity uace = v.getAllUserCountEntity();
			if (uace != null) {
				nuje.setName(uace.getProjectName());
				nuje.setActive(String.valueOf(uace.getActiveUsers()));
				nuje.setNewUser(String.valueOf(uace.getNewUsers()));
				nuje.setUsers(String.valueOf(uace.getSumUser()));
				nurv.setAllEntities(nuje);
			}

			List<UserCountEntity> list = v.getListUserCountEntity();
			List<NewUserJsonEntity> ll = new ArrayList<NewUserJsonEntity>();
			if (list != null) {
				for (UserCountEntity uce : list) {
					if (uce != null) {
						NewUserJsonEntity nuje2 = new NewUserJsonEntity();
						nuje2.setName(uce.getProjectName());
						nuje2.setActive(String.valueOf(uce.getActiveUsers()));
						nuje2.setNewUser(String.valueOf(uce.getNewUsers()));
						nuje2.setUsers(String.valueOf(uce.getSumUser()));
						ll.add(nuje2);
					}
				}
			}
			nurv.setDetail(ll);
		}

		nur.setResult(nurv);
		return new JsonModelAndView(nur);

	}

//	public static String cutTailZero(String s) {
//		if (s != null && s.contains(".")) {
//			s = s.trim();
//			if (!s.endsWith(".0")) {
//				while (s.endsWith("0") && !s.endsWith(".0")) {
//					s = s.substring(0, s.length() - 1);
//				}
//				return s;
//			}
//		}
//		return s;
//	}
//
//	public static void main(String[] args) {
//		System.out.println(cutTailZero("8.00"));
//	}

}
