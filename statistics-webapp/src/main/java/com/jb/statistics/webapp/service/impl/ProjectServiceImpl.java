package com.jb.statistics.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jb.statistics.dao.logs.statis.entities.ProjectBean;
import com.jb.statistics.webapp.service.ProjectService;
import com.jb.statistics.webapp.view.entities.ProjectEntity;

@Service("projectService")
public class ProjectServiceImpl extends BaseServiceImpl implements ProjectService {

	public List<ProjectEntity> listProjects() {
		List<ProjectBean> list = this.countLogs.listProjects();

		List<ProjectEntity> ll = new ArrayList<ProjectEntity>();
		if (list != null) {
			for (ProjectBean b : list) {
				ProjectEntity pe = new ProjectEntity();
				BeanUtils.copyProperties(b, pe);
				;
				ll.add(pe);
			}
		}
		return ll;

	}

}
