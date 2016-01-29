package com.jb.statistics.webapp.view.entities;


public class ClickFunctionEntity implements Comparable<ClickFunctionEntity> {
	/**
	 * 功能类型，对应于统计中的type
	 */
	private String functionType;

	/**
	 * 功能名称，相应的统计名称
	 */
	private String functionName;
	/**
	 * 次数
	 */
	private int times;
	/**
	 * 人数
	 */
	private int users;

	/**
	 * 点比
	 */
	private String percent;

	public String getFunctionType() {
		return functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
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

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}


	@Override
	public int compareTo(ClickFunctionEntity o) {
		int i=Integer.parseInt(this.functionType);
		int i2=Integer.parseInt(o.functionType);
		return i-i2;
	}

}
