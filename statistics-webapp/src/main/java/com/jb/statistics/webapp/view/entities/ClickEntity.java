package com.jb.statistics.webapp.view.entities;

public class ClickEntity {

	/**
	 * 时间段
	 */
	private String timeSeg;
	/**
	 * 次数
	 */
	private int times;
	/**
	 * 人数
	 */
	private int users;

	public String getTimeSeg() {
		return timeSeg;
	}

	public void setTimeSeg(String timeSeg) {
		this.timeSeg = timeSeg;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

}
