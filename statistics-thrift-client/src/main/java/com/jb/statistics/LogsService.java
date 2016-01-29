package com.jb.statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.jb.statistics.entities.LogEntity;
import com.jb.statistics.rpc.client.thrift.BaseLogsThriftTask;
import com.jb.statistics.rpc.client.thrift.LogsGroup0ThriftTask;
import com.jb.statistics.rpc.client.thrift.LogsGroup1ThriftTask;
import com.jb.statistics.rpc.client.thrift.LogsGroup2ThriftTask;
import com.jb.statistics.rpc.client.thrift.LogsGroup3ThriftTask;
import com.jb.statistics.rpc.client.thrift.LogsGroup4ThriftTask;
import com.jb.statistics.rpc.util.Constants;

public class LogsService {

	private static ExecutorService taskExecutor = null;

	private static String logsServers = null;

	static {
		int cpus = Runtime.getRuntime().availableProcessors();
		taskExecutor = Executors.newFixedThreadPool(cpus * 4);

		logsServers = Constants.LOGS_SERVERS;
	}

	private static Map<Integer, Integer> map;

	// public void log(int userId, int type, int subType) {
	// this.log(String.valueOf(userId), type, subType);
	// }
	//
	// public void log(String userId, int type, int subType) {
	// this.log(userId, type, subType, "");
	// }
	//
	// public void log(String userId, int type, int subType, int remark) {
	// this.log(userId, type, subType, String.valueOf(remark));
	// }

	public static void log(LogEntity le) {
		if (le == null) {
			return;
		}

		if ((le.getId() == null || le.getId().trim().length() == 0)) {
			return;
		}

		log(le.getId(), le.getType(), le.getSubType(), le.getVersion(), le.getSub2Type(), le.getSub3Type(), le.getOs(), le.getOsVersion(), le.getChannel(), le.getDevice(), le.getRemarks(), le.getMoreInfo());
	}

	public static void log(String userId, int type, int subType, String version, int sub2Type, int sub3Type, int os, String osVersion, String channel, String device, String remark, String moreInfo) {
		if (userId == null) {
			return;
		}
		int index = getDBIndex(type);
		BaseLogsThriftTask logsTask = null;
		switch (index) {
		case 0:
			logsTask = new LogsGroup0ThriftTask();
			break;
		case 1:
			logsTask = new LogsGroup1ThriftTask();
			break;
		case 2:
			logsTask = new LogsGroup2ThriftTask();
			break;
		case 3:
			logsTask = new LogsGroup3ThriftTask();
			break;
		case 4:
			logsTask = new LogsGroup4ThriftTask();
			break;
		default:
			return;
		}

		logsTask.setRemarks(remark);
		logsTask.setId(userId);
		logsTask.setType(type);
		logsTask.setSubType(subType);
		logsTask.setSub2Type(sub2Type);
		logsTask.setSub3Type(sub3Type);
		logsTask.setVersion(version);
		logsTask.setMoreInfo(moreInfo);
		logsTask.setOs(os);
		logsTask.setOsVersion(osVersion);
		logsTask.setChannel(channel);
		logsTask.setDevice(device);

		System.out.println("send log:" + logsTask);

		taskExecutor.execute(logsTask);
	}

	private static int getDBIndex(int type) {
		if (map == null) {
			map = new HashMap<Integer, Integer>();
			// constant.logs.logsServers=0:1,2,3,4,5;;;1:6,7,8;;;2:9,10,11,12;;;3:13,14,15;;;4:16,17,18
			String[] ss = logsServers.split(";;;");
			for (String s : ss) {
				String[] ss2 = s.split(":");
				String[] ss3 = ss2[1].split(",");
				for (String s3 : ss3) {
					map.put(Integer.parseInt(s3), Integer.parseInt(ss2[0]));
				}
			}
		}
		return map.get(type);
	}

	public static void main(String[] args) {
		LogEntity le = new LogEntity();
		le.setId("117346498");
		le.setType(1);
		le.setSubType(1112);
//		le.setSub2Type(121);
//		le.setSub3Type(131);
		le.setVersion("21123");
		le.setChannel("qq11");
		le.setDevice("device113");
		le.setOs(1);
		le.setOsVersion("9.0");
//		le.setMoreInfo("");
		LogsService.log(le);
	}

	// public void log(int userId, int type, int subType, String remark) {
	// this.log(String.valueOf(userId), type, subType, remark);
	// }
	//
	// public void log(int userId, int type, int subType, int remark) {
	// this.log(String.valueOf(userId), type, subType, remark);
	//
	// }
}
