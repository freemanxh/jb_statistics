package com.jb.statistics.webapp.controller.forms;

import org.hibernate.validator.constraints.NotBlank;


public class CountForm {
//	@NotBlank
	private String startDate;
//	@NotBlank
	private String endDate;
//	@NotBlank
	private String projectId;

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
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
