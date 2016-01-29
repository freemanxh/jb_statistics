package com.jb.statistics.dao.logs.statis.entities;

public class UserCountBean {
	/**
	 * 新增用户数
	 */
	private int newUsers;
	/**
	 * 活跃用户数
	 */
	private int activeUsers;
	/**
	 * 累计用户数
	 */
	private int sumUser;

	/**
	 * 项目id
	 */
	private String projectId;

	/**
	 * 项目名称
	 */
	private String projectName;

	public int getNewUsers() {
		return newUsers;
	}

	public void setNewUsers(int newUsers) {
		this.newUsers = newUsers;
	}

	public int getActiveUsers() {
		return activeUsers;
	}

	public void setActiveUsers(int activeUsers) {
		this.activeUsers = activeUsers;
	}

	public int getSumUser() {
		return sumUser;
	}

	public void setSumUser(int sumUser) {
		this.sumUser = sumUser;
	}

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
		return "UserCountBean [newUsers=" + newUsers + ", activeUsers=" + activeUsers + ", sumUser=" + sumUser + ", projectId=" + projectId + ", projectName=" + projectName + "]";
	}
	
	

}
