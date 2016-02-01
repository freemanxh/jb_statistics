package com.jb.statistics.webapp.controller.forms;

public class CountForm {
	// @NotBlank
	private String startDate;
	// @NotBlank
	private String endDate;
	// @NotBlank
	private String projectId;

	private String pid;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getProjectId() {
		return projectId == null ? "0".equals(pid) ? null : pid : projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
