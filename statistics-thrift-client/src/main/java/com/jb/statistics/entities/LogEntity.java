package com.jb.statistics.entities;

public class LogEntity {
	private String id;
	private int type;
	private int subType;
	private String version = "";
	private String channel = "";
	private String remarks = "";
	private int sub2Type;
	private int sub3Type;
	private String device = "";
	private String moreInfo = "";
	private int os;
	private String osVersion = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSubType() {
		return subType;
	}

	public void setSubType(int subType) {
		this.subType = subType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getSub2Type() {
		return sub2Type;
	}

	public void setSub2Type(int sub2Type) {
		this.sub2Type = sub2Type;
	}

	public int getSub3Type() {
		return sub3Type;
	}

	public void setSub3Type(int sub3Type) {
		this.sub3Type = sub3Type;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public int getOs() {
		return os;
	}

	public void setOs(int os) {
		this.os = os;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

}
