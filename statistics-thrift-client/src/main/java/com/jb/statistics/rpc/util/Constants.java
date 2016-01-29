package com.jb.statistics.rpc.util;

import java.io.IOException;
import java.util.Properties;

public class Constants {

	private static Properties p = new Properties();

//	public static String CONSTANT_THRIFT_PUSH_SERVER_IP;
//	public static int CONSTANT_THRIFT_PUSH_SERVER_PORT;
//
//	public static String CONSTANT_THRIFT_SEARCH_FACTORY_IP;
//	public static int CONSTANT_THRIFT_SEARCH_FACTORY_PORT;
//
//	public static String CONSTANT_THRIFT_SMS_SEND_SERVER_IP;
//	public static int CONSTANT_THRIFT_SMS_SEND_SERVER_PORT;

	public static String CONSTANT_THRIFT_LOGS_GROUP0_SERVER_IP;
	public static int CONSTANT_THRIFT_LOGS_GROUP0_SERVER_PORT;

	public static String CONSTANT_THRIFT_LOGS_GROUP1_SERVER_IP;
	public static int CONSTANT_THRIFT_LOGS_GROUP1_SERVER_PORT;

	public static String CONSTANT_THRIFT_LOGS_GROUP2_SERVER_IP;
	public static int CONSTANT_THRIFT_LOGS_GROUP2_SERVER_PORT;

	public static String CONSTANT_THRIFT_LOGS_GROUP3_SERVER_IP;
	public static int CONSTANT_THRIFT_LOGS_GROUP3_SERVER_PORT;

	public static String CONSTANT_THRIFT_LOGS_GROUP4_SERVER_IP;
	public static int CONSTANT_THRIFT_LOGS_GROUP4_SERVER_PORT;

	public static String CONSTANT_THRIFT_LOGS_GROUP5_SERVER_IP;
	public static int CONSTANT_THRIFT_LOGS_GROUP5_SERVER_PORT;
	
	public static String LOGS_SERVERS;
	
	public static String INVOKE_URL;
	

//	public static String CONSTANT_THRIFT_PHONE_SEARCH_SERVER_IP;
//	public static int CONSTANT_THRIFT_PHONE_SEARCH_SERVER_PORT;
//
//	public static String CONSTANT_THRIFT_BAIDU_LBS_SERVER_IP;
//	public static int CONSTANT_THRIFT_BAIDU_LBS_SERVER_PORT;
//
//	public static String CONSTANT_THRIFT_SEARCH_POST_IP;
//	public static int CONSTANT_THRIFT_SEARCH_POST_PORT;
//
//	public static String CONSTANT_THRIFT_SEARCH_USERINFO_IP;
//	public static int CONSTANT_THRIFT_SEARCH_USERINFO_PORT;

	// public static String SYSTEM_DEFAULT_DESC;

	static {
		try {

			p.load(Constants.class.getResourceAsStream("/config_thrift.properties"));

//			CONSTANT_THRIFT_PUSH_SERVER_IP = p.getProperty("constant.thrift.push.server.ip");
//			CONSTANT_THRIFT_PUSH_SERVER_PORT = Integer.parseInt(p.getProperty("constant.thrift.push.server.port"));
//
//			CONSTANT_THRIFT_SMS_SEND_SERVER_IP = p.getProperty("constant_thrift_sms_send_server_ip");
//			CONSTANT_THRIFT_SMS_SEND_SERVER_PORT = Integer.parseInt(p.getProperty("constant_thrift_sms_send_server_port"));
			
			LOGS_SERVERS=p.getProperty("logsServers");
			
			INVOKE_URL=p.getProperty("invokeUrl");

			CONSTANT_THRIFT_LOGS_GROUP0_SERVER_IP = p.getProperty("constant_thrift_logs_group0_server_ip");
			CONSTANT_THRIFT_LOGS_GROUP0_SERVER_PORT = Integer.parseInt(p.getProperty("constant_thrift_logs_group0_server_port"));

			CONSTANT_THRIFT_LOGS_GROUP1_SERVER_IP = p.getProperty("constant_thrift_logs_group1_server_ip");
			CONSTANT_THRIFT_LOGS_GROUP1_SERVER_PORT = Integer.parseInt(p.getProperty("constant_thrift_logs_group1_server_port"));

			CONSTANT_THRIFT_LOGS_GROUP2_SERVER_IP = p.getProperty("constant_thrift_logs_group2_server_ip");
			CONSTANT_THRIFT_LOGS_GROUP2_SERVER_PORT = Integer.parseInt(p.getProperty("constant_thrift_logs_group2_server_port"));

			CONSTANT_THRIFT_LOGS_GROUP3_SERVER_IP = p.getProperty("constant_thrift_logs_group3_server_ip");
			CONSTANT_THRIFT_LOGS_GROUP3_SERVER_PORT = Integer.parseInt(p.getProperty("constant_thrift_logs_group3_server_port"));

			CONSTANT_THRIFT_LOGS_GROUP4_SERVER_IP = p.getProperty("constant_thrift_logs_group4_server_ip");
			CONSTANT_THRIFT_LOGS_GROUP4_SERVER_PORT = Integer.parseInt(p.getProperty("constant_thrift_logs_group4_server_port"));

			CONSTANT_THRIFT_LOGS_GROUP5_SERVER_IP = p.getProperty("constant_thrift_logs_group5_server_ip");
			CONSTANT_THRIFT_LOGS_GROUP5_SERVER_PORT = Integer.parseInt(p.getProperty("constant_thrift_logs_group5_server_port"));

//			CONSTANT_THRIFT_SEARCH_FACTORY_IP = p.getProperty("constant_thrift_search_factory_ip");
//			CONSTANT_THRIFT_SEARCH_FACTORY_PORT = Integer.parseInt(p.getProperty("constant_thrift_search_factory_port"));
//
//			CONSTANT_THRIFT_SEARCH_POST_IP = p.getProperty("constant_thrift_search_post_ip");
//			CONSTANT_THRIFT_SEARCH_POST_PORT = Integer.parseInt(p.getProperty("constant_thrift_search_post_port"));
//
//			CONSTANT_THRIFT_SEARCH_USERINFO_IP = p.getProperty("constant_thrift_search_userinfo_ip");
//			CONSTANT_THRIFT_SEARCH_USERINFO_PORT = Integer.parseInt(p.getProperty("constant_thrift_search_userinfo_port"));
//
//			CONSTANT_THRIFT_PHONE_SEARCH_SERVER_IP = p.getProperty("constant_thrift_phone_search_server_ip");
//			CONSTANT_THRIFT_PHONE_SEARCH_SERVER_PORT = Integer.parseInt(p.getProperty("constant_thrift_phone_search_server_port"));
//
//			CONSTANT_THRIFT_BAIDU_LBS_SERVER_IP = p.getProperty("constant_thrift_baidu_lbs_server_ip");
//			CONSTANT_THRIFT_BAIDU_LBS_SERVER_PORT = Integer.parseInt(p.getProperty("constant_thrift_baidu_lbs_server_port"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
