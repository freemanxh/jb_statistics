package com.jb.statistics.webapp.view.result.jsonentities;

public class NewUserJsonEntity {
	/**
	 * item名称
	 */
	private String name;
	/**
	 * 新用户
	 */
	private String newUser;
	/**
	 * 活跃用户
	 */
	private String active;
	/**
	 * 累计用户
	 */
	private String users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNewUser() {
		return newUser;
	}

	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

}
