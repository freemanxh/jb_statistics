package com.jb.statistics.rpc.client.thrift;

import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.jb.statistics.rpc.util.Constants;

public class LogsGroup0ThriftTask extends BaseLogsThriftTask {

	@Override
	protected TTransport getTTransport() {
		return new TFramedTransport(new TSocket(Constants.CONSTANT_THRIFT_LOGS_GROUP0_SERVER_IP, Constants.CONSTANT_THRIFT_LOGS_GROUP0_SERVER_PORT));
	}

}
