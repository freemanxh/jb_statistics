package com.jb.statistics.dao.logs.statis.entities;

public class ClickBean implements Comparable<ClickBean> {
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

	@Override
	public String toString() {
		return "ClickBean [timeSeg=" + timeSeg + ", times=" + times + ", users=" + users + "]";
	}

	@Override
	public int compareTo(ClickBean o) {
		String[] ss = this.timeSeg.split(":");
		int s = Integer.parseInt(ss[0]);

		String[] ss2 = o.timeSeg.split(":");
		int s2 = Integer.parseInt(ss2[0]);
		return s - s2;
	}

}
