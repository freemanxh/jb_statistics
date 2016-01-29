package com.jb.statistics.common.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class Constants {

	private static Properties p = new Properties();

	public static String FLAG_CLOCK_TIME_IP;
	public static int FLAG_CLOCK_TIME_PORT;

	public static String FLAG_USER_REG_IP;
	public static int FLAG_USER_REG_PORT;

	public static String FLAG_TOPS_IP;
	public static int FLAG_TOPS_PORT;

	public static String FLAG_CLOCK_LOOP_IP;
	public static int FLAG_CLOCK_LOOP_PORT;

	public static String SEARCH_CLOCK_TIME_IP;
	public static int SEARCH_CLOCK_TIME_PORT;

	// 按闹钟时间进行搜索向后进行delay时间，m
	public static int SEARCH_CLOCK_TIME_DELAY;

	public static int SEARCH_CLOCK_TIME_DELAY_RANDOM;

	public static int CMEM_LIMIT_QQFRIEND;
	public static int CMEM_LIMIT_USER_PLACE;
	public static int CMEM_LIMIT_CLOCK_TIME;
	public static int CMEM_LIMIE_CLOCK_TIME_VISITED;
	public static int CMEM_LIMIT_GET_UP_CARD;
	public static int CMEM_LIMIT_REQUEST_CALL;
	// 谁叫过我的fulllistid零时表
	public static int CMEM_LIMIT_GET_UP_LOG_TEMP;

	public static int CMEM_LIMIT_CALLED_OTHER_TEMP;

	public static int BEST_USER_PLACE_SIZE;
	public static int USER_PLACE_SIZE;

	public static int USER_COUNT_PLACE_SIZE;

	public static int DEV_MODE;

	public static int CVM;

	public static int VALIDATE_TIME_PFID_TOKEN;

	public static int BEFORE_DOWN_TIME;

	public static int CALL_PLACE_LIMIT;

	public static int REQUEST_CALL_LIMIT;

	public static int WHO_CALLED_ME_LIST;

	public static int EXIST_TIME;

	public static int REQUEST_CALL_EXIST_TIME;

	public static int RECEIVE_CARD_NOT_READED;

	public static String SYSTEM_RECOMMEND_TYPE;

	public static int SYSTEM_RECOMMEND_MAX_PAGE;

	public static String[] MEMCACHE_SERVERS = null;

	public static int MEM_IS_EXT;

	public static int NEW_USER_SET_ROBOT_DAYS;

	public static int DELETE_EXPIRE_CLOCK_DELAY_TIME;

	public static int NEW_USER_ROBOT_AFTER_OCCUPY_HOLE;

	public static String BAIDU_CLOUD_PUSH_IP;

	public static int BAIDU_CLOUD_PUSH_PORT;

	public static int BAIDU_CLOUD_PUSH_TIMEOUT;

	public static long IS_ONLINE_TIME;

	public static int SEARCH_LAST_VISITED_TIME_DIST;

	public static int SEARCH_LAST_ACTIVE_TIME_DIST;

	public static long SELF_LOOP_LIVIING_USER_TIME;

	// 多少天之前的数据不出现在搜索里面了
	public static long SEARCH_LAST_VISITED_TIME;

	public static long SEARCH_LAST_VISIT_TIME_RANDOM;

	public static List<String> CLOCK_TIME_SEGS = new ArrayList<String>();

	public static String PUSH_IP;

	public static int PUSH_PORT;

	public static int PUSH_TIMEOUT;

	public static int PUSH_CHANNEL;

	public static int SELF_LOOP;

	public static int SELF_LOOP_SLEEP;

	public static int START_SELF_LOOP;

	public static int END_SELF_LOOP;

	public static int LOOP_BEFORE_DAY;

	public static int LAST_INTO_SEARCH_TIME;

	public static int ANONYMOUS_CLOCK_MALE_POOL_SIZE;

	public static int ANONYMOUS_CLOCK_FEMALE_POOL_SIZE;

	public static int ANONYMOUS_CLOCK_OCCUPY_HOLE_DELAY_TIME;

	public static long SEARCH_LAST_ACTIVE_TIME;

	public static int SEARCH_ACTIVE_COUNT;

	public static int REQUEST_CALL_MALE_POOL_SIZE;

	public static int REQUEST_CALL_FEMALE_POOL_SIZE;

	public static int ACTIVE_USER_IN_FIRST_DAY_WEIGHTS;

	public static int ACTIVE_USER_IN_SECOND_DAY_WEIGHTS;

	public static int ACTIVE_USER_IN_THIRD_DAY_WEIGHTS;

	public static int ACTIVE_USER_LOOP_COUNT;
	/** 是否记录日志0为不记录，1为记录 */
	public static int LOGS_MODE;

	public static int REQUEST_CALL_TEXT_SIZE;

	public static int COMMIT_CONFIRM_MSG;

	public static int TEST_SERVER;

	public static String DAY_H;
	public static String DAY_M;
	public static String DAY_L;

	public static int SYSTEM_PLACE_MODE;

	// public static String SYSTEM_DEFAULT_DESC;

	static {
		try {

			p.load(Constants.class.getResourceAsStream("/config_dao.properties"));
			
			MEMCACHE_SERVERS = StringUtils.split(
					p.getProperty("constants.cmem_servers"), ",");
			MEM_IS_EXT = Integer.parseInt(p.getProperty("constants.is_ext", "1"));

			// FLAG_CLOCK_TIME_IP = p.getProperty("flag_clock_time_ip");
			//
			//
			//
			// NEW_USER_SET_ROBOT_DAYS = Integer.parseInt(p
			// .getProperty("new_user_set_robot_days"));
			//
			// FLAG_CLOCK_TIME_PORT = Integer.parseInt(p
			// .getProperty("flag_clock_time_port"));
			//
			// FLAG_USER_REG_IP = p.getProperty("flag_user_reg_ip");
			// FLAG_USER_REG_PORT = Integer.parseInt(p
			// .getProperty("flag_user_reg_port"));
			//
			// FLAG_TOPS_IP = p.getProperty("flag_tops_ip");
			// FLAG_TOPS_PORT =
			// Integer.parseInt(p.getProperty("flag_tops_port"));
			//
			// VALIDATE_TIME_PFID_TOKEN = Integer.parseInt(p
			// .getProperty("validate_time_pfid_token"));
			//
			// SEARCH_CLOCK_TIME_IP = p.getProperty("search_clock_time_ip");
			// SEARCH_CLOCK_TIME_PORT = Integer.parseInt(p
			// .getProperty("search_clock_time_port"));
			//
			// FLAG_CLOCK_LOOP_IP = p.getProperty("flag_clock_loop_ip");
			// FLAG_CLOCK_LOOP_PORT = Integer.parseInt(p
			// .getProperty("flag_clock_loop_port"));
			//
			// SEARCH_CLOCK_TIME_DELAY = Integer.parseInt(p
			// .getProperty("search_clock_time_delay")) * 60 * 1000;
			//
			// SEARCH_CLOCK_TIME_DELAY_RANDOM = Integer.parseInt(p
			// .getProperty("search_clock_time_delay_random")) * 60 * 1000;
			//
			// CMEM_LIMIT_QQFRIEND = Integer.parseInt(p
			// .getProperty("cmem_limit_qqfriend"));
			//
			// CMEM_LIMIT_USER_PLACE = Integer.parseInt(p
			// .getProperty("cmem_limit_user_place"));
			//
			// CMEM_LIMIT_CLOCK_TIME = Integer.parseInt(p
			// .getProperty("cmem_limit_clock_time"));
			//
			// CMEM_LIMIT_GET_UP_CARD = Integer.parseInt(p
			// .getProperty("cmem_limit_get_up_card"));
			//
			// CMEM_LIMIT_REQUEST_CALL = Integer.parseInt(p
			// .getProperty("cmem_limit_request_call"));
			//
			// CMEM_LIMIE_CLOCK_TIME_VISITED = Integer.parseInt(p
			// .getProperty("cmem_limit_clock_time_visited"));
			//
			// CMEM_LIMIT_GET_UP_LOG_TEMP = Integer.parseInt(p
			// .getProperty("cmem_limit_get_up_log_temp"));
			//
			// CMEM_LIMIT_CALLED_OTHER_TEMP = Integer.parseInt(p
			// .getProperty("cmem_limit_called_other_temp"));
			//
			// BEST_USER_PLACE_SIZE = Integer.parseInt(p
			// .getProperty("user_best_place_size"));
			//
			// USER_PLACE_SIZE = Integer
			// .parseInt(p.getProperty("user_place_size"));
			//
			// DEV_MODE = Integer.parseInt(p.getProperty("dev_mode"));
			//
			// CVM = Integer.parseInt(p.getProperty("cvm"));
			// BEFORE_DOWN_TIME = Integer.parseInt(p
			// .getProperty("before_down_time")) * 60 * 1000;
			// CALL_PLACE_LIMIT = Integer.parseInt(p
			// .getProperty("call_place_limit"));
			//
			// REQUEST_CALL_LIMIT = Integer.parseInt(p
			// .getProperty("request_call_limit"));
			//
			// EXIST_TIME = Integer.parseInt(p.getProperty("exist_time"));
			//
			// REQUEST_CALL_EXIST_TIME = Integer.parseInt(p
			// .getProperty("request_call_exist_time"));
			//
			// WHO_CALLED_ME_LIST = Integer.parseInt(p
			// .getProperty("who_called_me_list"));
			//
			// RECEIVE_CARD_NOT_READED = Integer.parseInt(p
			// .getProperty("receive_card_not_readed"));
			//
			// SYSTEM_RECOMMEND_MAX_PAGE = Integer.parseInt(p
			// .getProperty("system_recommend_max_page"));
			//
			// SYSTEM_RECOMMEND_TYPE = p.getProperty("system_recommend_type");
			//
			// USER_COUNT_PLACE_SIZE = BEST_USER_PLACE_SIZE + USER_PLACE_SIZE;
			//
			// DELETE_EXPIRE_CLOCK_DELAY_TIME = Integer.parseInt(p
			// .getProperty("delete_expire_clock_delay_time"));
			//
			// NEW_USER_ROBOT_AFTER_OCCUPY_HOLE = Integer.parseInt(p
			// .getProperty("new_user_robot_after_occupy_hole"));
			//
			// PUSH_IP = p.getProperty("push_ip");
			//
			// PUSH_PORT = Integer.parseInt(p.getProperty("push_port"));
			//
			// PUSH_TIMEOUT = Integer.parseInt(p.getProperty("push_timeout"));
			// PUSH_CHANNEL = Integer.parseInt(p.getProperty("push_channel"));
			// SEARCH_LAST_VISITED_TIME_DIST = Integer.parseInt(p
			// .getProperty("search_last_visited_time_dist")) * 1000;
			//
			// SEARCH_LAST_ACTIVE_TIME_DIST = Integer.parseInt(p
			// .getProperty("search_last_active_time_dist")) * 1000;
			//
			// LAST_INTO_SEARCH_TIME = Integer.parseInt(p
			// .getProperty("last_into_search_time")) * 1000;
			//
			// SELF_LOOP = Integer.parseInt(p.getProperty("self_loop", "0"));
			//
			// ANONYMOUS_CLOCK_MALE_POOL_SIZE = Integer.parseInt(p
			// .getProperty("anonymous_clock_male_pool_size"));
			//
			// REQUEST_CALL_MALE_POOL_SIZE = Integer.parseInt(p
			// .getProperty("request_call_male_pool_size"));
			//
			// ANONYMOUS_CLOCK_FEMALE_POOL_SIZE = Integer.parseInt(p
			// .getProperty("anonymous_clock_female_pool_size"));
			//
			// REQUEST_CALL_FEMALE_POOL_SIZE = Integer.parseInt(p
			// .getProperty("request_call_female_pool_size"));
			//
			// ANONYMOUS_CLOCK_OCCUPY_HOLE_DELAY_TIME = Integer.parseInt(p
			// .getProperty("anonymous_clock_occupy_hole_delay_time")) * 60 *
			// 1000;
			//
			// SEARCH_LAST_ACTIVE_TIME = Long.parseLong(p
			// .getProperty("search_last_active_time")) * 86400000;
			//
			// SEARCH_ACTIVE_COUNT = Integer.parseInt(p
			// .getProperty("search_active_count"));
			//
			// SEARCH_LAST_VISITED_TIME = Long.parseLong(p
			// .getProperty("search_last_visited_time")) * 86400000;
			//
			// SEARCH_LAST_VISIT_TIME_RANDOM = Long.parseLong(p
			// .getProperty("search_last_visit_time_random")) * 86400000;
			//
			// SELF_LOOP_LIVIING_USER_TIME = Long.parseLong(p
			// .getProperty("self_loop_liviing_user_time")) * 86400000;
			//
			// REQUEST_CALL_TEXT_SIZE = Integer.parseInt(p
			// .getProperty("request_call_text_size"));
			//
			// COMMIT_CONFIRM_MSG = Integer.parseInt(p
			// .getProperty("commit_confirm_msg"));
			//
			// TEST_SERVER = Integer.parseInt(p.getProperty("test_server"));
			//
			// LOOP_BEFORE_DAY = Integer
			// .parseInt(p.getProperty("loop_before_day"));
			//
			// SYSTEM_PLACE_MODE = Integer.parseInt(p
			// .getProperty("system_place_mode"));
			//
			// // SYSTEM_DEFAULT_DESC=p.getProperty("system_default_desc");
			//
			// if (SELF_LOOP == 1) {
			// START_SELF_LOOP = Integer.parseInt(p
			// .getProperty("start_self_loop"));
			//
			// END_SELF_LOOP = Integer
			// .parseInt(p.getProperty("end_self_loop"));
			// SELF_LOOP_SLEEP = Integer.parseInt(p
			// .getProperty("self_loop_sleep"));
			//
			// }
			// DAY_H = p.getProperty("day_h");
			// DAY_M = p.getProperty("day_m");
			// DAY_L = p.getProperty("day_l");
			//
			// IS_ONLINE_TIME =
			// Integer.parseInt(p.getProperty("is_online_time")) * 60 * 60 *
			// 1000;
			//
			// ACTIVE_USER_IN_FIRST_DAY_WEIGHTS = Integer.parseInt(p
			// .getProperty("active_user_in_first_day_weights"));
			// ACTIVE_USER_IN_SECOND_DAY_WEIGHTS = Integer.parseInt(p
			// .getProperty("active_user_in_second_day_weights"));
			// ACTIVE_USER_IN_THIRD_DAY_WEIGHTS = Integer.parseInt(p
			// .getProperty("active_user_in_third_day_weights"));
			// ACTIVE_USER_LOOP_COUNT = Integer.parseInt(p
			// .getProperty("active_user_loop_count"));
			//
			// LOGS_MODE = Integer.parseInt(p.getProperty("logs_mode"));
			// String sClockTimeSegs = p.getProperty("clock_time_segs");
			// String[] ss = sClockTimeSegs.split("\\|");
			// if (ss.length > 0) {
			// for (String s : ss) {
			// CLOCK_TIME_SEGS.add(s);
			// }
			// }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDomain() {
		return p.getProperty("domain");
	}

	public static String getValue(String key) {
		return p.getProperty(key);
	}

	// public static String[] getMemcachedServers() {
	// return StringUtils.split(p.getProperty("memcached.servers"), ",");
	// }

	public static String[] getMemcachedServers2() {
		return StringUtils.split(p.getProperty("memcached.servers.2"), ",");
	}

	public static String getUploadServer() {
		return p.getProperty("upload.server");
	}

	public static String getAppid() {
		return p.getProperty("qq.appid");
	}

	public static String getAppkey() {
		return p.getProperty("qq.appkey");
	}

	public static String getCdnHost() {
		return p.getProperty("cdn.host");
	}

	public static String getCdnVersion() {
		return p.getProperty("cdn.version");
	}

	public static String getAppname() {
		return p.getProperty("qq.appname");
	}

	public static boolean isDevMode() {
		return DEV_MODE == 1;
	}

	public static boolean isCvm() {
		return CVM == 1;
	}

}
