package com.jb.statistics.dao.logs.statis;

import java.util.List;
import java.util.Map;

import com.jb.statistics.dao.logs.statis.entities.ClickBean;
import com.jb.statistics.dao.logs.statis.entities.ClickFunctionBean;
import com.jb.statistics.dao.logs.statis.entities.ProjectBean;
import com.jb.statistics.dao.logs.statis.entities.UserCountBean;

public interface CountLogs {

	List<ProjectBean> listProjects();

	List<ClickFunctionBean> countByDayByProject(String startDate, String endDate, String projectId);

	List<ClickBean> countByHour(String startDate, String endDate, String projectId, int type, int subType);

	Map<String, Integer> countNewUesrs(String startDate, String endDate, String projectId);

	Map<String, Integer> countActiveUsers(String startDate, String endDate, String projectId);

}
