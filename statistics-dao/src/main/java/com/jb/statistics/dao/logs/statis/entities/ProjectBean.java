package com.jb.statistics.dao.logs.statis.entities;

public class ProjectBean {
	private String projectId;
	private String projectName;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "ProjectBean [projectId=" + projectId + ", projectName=" + projectName + "]";
	}
	
	
	

}
