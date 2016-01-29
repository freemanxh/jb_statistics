package com.jb.statistics.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jb.statistics.dao.logs.statis.entities.ProjectBean;
import com.jb.statistics.dao.logs.statis.entities.UserCountBean;
import com.jb.statistics.webapp.service.CountNewUserService;
import com.jb.statistics.webapp.view.NewUserView;
import com.jb.statistics.webapp.view.entities.UserCountEntity;

@Service("countNewUserService")
public class CountNewUserServiceImpl extends BaseServiceImpl implements CountNewUserService {

	public NewUserView buildNewUserView(String startDate, String endDate, String projectId) {

		Map<String, Integer> newUser = this.countLogs.countNewUesrs(startDate, endDate, projectId);
		Map<String, Integer> allUser = this.countLogs.countNewUesrs(null, null, projectId);
		Map<String, Integer> activeUser = this.countLogs.countActiveUsers(startDate, endDate, projectId);

		List<ProjectBean> projects = this.countLogs.listProjects();

		int sumActive = 0;
		int sumNew = 0;
		int sumAll = 0;
		List<UserCountBean> list = new ArrayList<UserCountBean>();
		for (ProjectBean pb : projects) {
			String pId = pb.getProjectId();

			if (projectId != null && !projectId.equals(pId)) {
				continue;
			}

			UserCountBean ucb = new UserCountBean();
			ucb.setProjectId(pId);
			Integer activeCount = activeUser.get(pId);
			int iActiveCount = activeCount == null ? 0 : activeCount;
			sumActive += iActiveCount;
			ucb.setActiveUsers(iActiveCount);
			Integer newCount = newUser.get(pId);
			int iNewCount = newCount == null ? 0 : newCount;
			sumNew += iNewCount;
			ucb.setNewUsers(iNewCount);
			Integer allCount = allUser.get(pId);
			int iAllCount = allCount == null ? 0 : allCount;
			ucb.setSumUser(iAllCount);
			sumAll += iAllCount;

			ucb.setProjectName(pb.getProjectName());
			list.add(ucb);
		}
		UserCountBean ucb = new UserCountBean();
		ucb.setProjectId("0");
		ucb.setActiveUsers(sumActive);
		ucb.setNewUsers(sumNew);
		ucb.setSumUser(sumAll);
		ucb.setProjectName("总计");
		list.add(ucb);

		NewUserView nuv = new NewUserView();
		UserCountEntity allUserCountEntity = new UserCountEntity();
		allUserCountEntity.setActiveUsers(sumActive);
		allUserCountEntity.setNewUsers(sumNew);
		allUserCountEntity.setSumUser(sumAll);
		allUserCountEntity.setProjectName("总计");

		nuv.setAllUserCountEntity(allUserCountEntity);

		List<UserCountEntity> ll = new ArrayList<UserCountEntity>();
		if (list != null) {
			for (UserCountBean ucBean : list) {
				if (ucBean != null) {
					UserCountEntity uce = new UserCountEntity();
					BeanUtils.copyProperties(ucBean, uce);
					ll.add(uce);
				}
			}
		}

		nuv.setListUserCountEntity(ll);

		return nuv;
	}
}
