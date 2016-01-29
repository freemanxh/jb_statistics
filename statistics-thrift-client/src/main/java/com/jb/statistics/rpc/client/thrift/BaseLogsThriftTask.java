package com.jb.statistics.rpc.client.thrift;

import java.util.Map;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.jb.statistics.rpc.thrift.LogsRequ;
import com.jb.statistics.rpc.thrift.LogsResp;
import com.jb.statistics.rpc.thrift.LogsService;
import com.jb.statistics.thirtinte.InvokeApi;

public abstract class BaseLogsThriftTask extends BaseTask {

	public static final int ADD = 1, DELETE = 2;
	protected String id;
	protected int type;
	protected int subType;
	protected long createTime = System.currentTimeMillis();
	protected String version;
	protected String channel;
	protected String remarks;
	protected int sub2Type;
	protected int sub3Type;
	protected String device;
	protected String mobilePhone;
	protected String moreInfo;
	protected int os;
	protected String osVersion;
	protected String projectId;

	public void run() {
		try {

			LogsRequ logsRequ = new LogsRequ();

			logsRequ.setId(id);

			Map<String, String> map = InvokeApi.getMobileAndProjectId(id);
			if (map != null) {
				logsRequ.setMobilePhone(map.get("mobile"));
				logsRequ.setProjectId(map.get("projectId"));
			}

			logsRequ.setChannel(channel);
			logsRequ.setCreateTime(createTime);
			logsRequ.setRemarks(remarks);
			logsRequ.setSubType(subType);
			logsRequ.setType(type);
			logsRequ.setVersion(version);
			logsRequ.setSub2Type(sub2Type);
			logsRequ.setSub3Type(sub3Type);
			logsRequ.setDevice(device);
			logsRequ.setMoreInfo(moreInfo);
			logsRequ.setOs(os);
			logsRequ.setOsVersion(osVersion);

			this.sendFlag(logsRequ);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract TTransport getTTransport();

	protected LogsResp sendFlag(LogsRequ logsRequ) {
		TTransport transport = this.getTTransport();
		try {
			transport.open();
			// 使用高密度二进制协议
			TProtocol protocol = new TCompactProtocol(transport);

			LogsService.Client client = new LogsService.Client(protocol);
			LogsResp logsResp = client.logByThrift(logsRequ);

			return logsResp;
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		} finally {
			transport.close();
		}

		return null;
	}

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

	public long getInsertTime() {
		return createTime;
	}

	public void setInsertTime(long insertTime) {
		this.createTime = insertTime;
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

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "BaseLogsThriftTask [id=" + id + ", type=" + type + ", subType=" + subType + ", insertTime=" + createTime + ", version=" + version + ", channel=" + channel + ", remarks=" + remarks + ", sub2Type=" + sub2Type + ", sub3Type=" + sub3Type + ", device=" + device + ", mobilePhone=" + mobilePhone + ", moreInfo=" + moreInfo + ", os=" + os + ", osVersion=" + osVersion + ", projectId=" + projectId + "]";
	}

}
