package com.jb.statistics.rpc.client.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.jb.statistics.rpc.thrift.FlagRequ;
import com.jb.statistics.rpc.thrift.FlagResp;
import com.jb.statistics.rpc.thrift.FlagService;

public abstract class BaseThriftTask extends BaseTask {

	public static final int ADD = 1, DELETE = 2;
	protected String id;
	protected int type = 1;
	protected int subType;
	// 1=add,2=delete
	protected int opType = 1;
	protected String msg = "";
	protected int workType;

	public void run() {
		try {
			FlagRequ fRequ = new FlagRequ();
			fRequ.setId(this.id);
			fRequ.setType(this.type);
			fRequ.setSubType(this.subType);
			fRequ.setMsg(this.msg);
			fRequ.setWorkType(workType);
			fRequ.setOpType(this.opType);

			System.out.println("rRequ:" + fRequ);
			this.sendFlag(fRequ);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract TTransport getTTransport();

	protected FlagResp sendFlag(FlagRequ flagRequ) {

		TTransport transport = this.getTTransport();
		try {
			transport.open();

			// 使用高密度二进制协议
			TProtocol protocol = new TCompactProtocol(transport);

			FlagService.Client client = new FlagService.Client(protocol);

			FlagResp flagResp = client.sendFlag(flagRequ);

			return flagResp;
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		} finally {
			transport.close();
		}

		return null;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setSubType(int subType) {
		this.subType = subType;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOpType(int opType) {
		this.opType = opType;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setWorkType(int workType) {
		this.workType = workType;
	}

}
