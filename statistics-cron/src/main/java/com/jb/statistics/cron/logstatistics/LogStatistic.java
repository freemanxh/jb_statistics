package com.jb.statistics.cron.logstatistics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jb.statistics.cron.Constants;
import com.jb.statistics.dao.logs.statis.DiviceLog;
import com.jb.statistics.dao.logs.statis.StatisUserLogs;

@Service("logStatistic")
public class LogStatistic {

	@Autowired
	private Constants cronConstants;

	@Autowired
	private DiviceLog diviceLog;

	@Autowired
	private StatisUserLogs statisUserLogs;

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContextDao.xml", "applicationContextCron.xml"});

		LogStatistic logStatistic = (LogStatistic) ac.getBean("logStatistic");

		Calendar c = Calendar.getInstance();
		logStatistic.statis(c);
		System.out.println(ac);

	}

	// public void start() {
	// System.out.println("start statistic...");
	// try {
	// String startDay = config.getProperty("stat_start_day");
	// String endDay = config.getProperty("stat_end_day");
	//
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// Date sd = sdf.parse(startDay);
	// Date ed = sdf.parse(endDay);
	// Calendar c = Calendar.getInstance();
	// c.setTime(sd);
	// do {
	// statis(c);
	// } while (c.getTimeInMillis() <= ed.getTime());
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// System.out.println("statistic finished...");
	// }
	//
	// private void statis(Calendar c) {
	// Connection con = getConnection();
	// try {
	// con.setAutoCommit(false);
	// } catch (SQLException e1) {
	// e1.printStackTrace();
	// }
	//
	// c.set(Calendar.HOUR_OF_DAY, 0);
	// c.set(Calendar.MINUTE, 0);
	// c.set(Calendar.SECOND, 0);
	//
	// Date date = new Date(c.getTimeInMillis());
	// DateFormat df = new SimpleDateFormat("yyyy_MM_dd");
	//
	// try {
	// // 表名，以时间命名
	// String tbTime = df.format(date);
	// // DateUtil.getTime(c, "yyyy_MM_dd");
	// long startTime = c.getTimeInMillis();
	// c.add(Calendar.DAY_OF_YEAR, 1);
	// // 第二天
	// long endTime = c.getTimeInMillis();
	//
	// for (Object key : config.keySet()) {
	// String keyStr = (String) key;
	// if (keyStr.startsWith("log_table")) {
	// String table = "userlogs" + keyStr.substring(keyStr.lastIndexOf("_"),
	// keyStr.length());
	// String newTable = table + "_" + tbTime;
	// // insertStatis(con, statTime, startTime, endTime, table);
	// divideTable(con, startTime, endTime, table, newTable);
	// deleteItem(con, startTime, endTime, table);
	// }
	// }
	//
	// con.commit();
	// } catch (Exception e) {
	// try {
	// con.rollback();
	// } catch (SQLException e1) {
	// e1.printStackTrace();
	// }
	// e.printStackTrace();
	// }
	// closeConnection(con);
	// }

	/**
	 * @param d
	 *            'yyyy-MM-dd'
	 */
	public void statis(String d) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = df.parse(d);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			this.statis(c);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param c
	 */
	public void statis(Calendar c) {

		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);

		Date date = new Date(c.getTimeInMillis());
		DateFormat df = new SimpleDateFormat("yyyy_MM_dd");

		// 表名，以时间命名
		String tbTime = df.format(date);
		// DateUtil.getTime(c, "yyyy_MM_dd");
		long startTime = c.getTimeInMillis();
		c.add(Calendar.DAY_OF_YEAR, 1);
		// 第二天
		long endTime = c.getTimeInMillis();

		// for (Object key : config.keySet()) {
		// String keyStr = (String) key;
		// if (keyStr.startsWith("log_table")) {

		for (int i = 0; i < cronConstants.getLogsTableSize(); i++) {
			String table = "jb_userlogs_" + i + "_";

			// jb_userlogs_0_
			// "userlogs" + keyStr.substring(keyStr.lastIndexOf("_"),
			// keyStr.length());
			String newTable = table + "_" + tbTime;
			// insertStatis(con, statTime, startTime, endTime, table);
			if (this.diviceLog.divideTable(startTime, endTime, table, newTable)) {
				this.diviceLog.deleteItem(startTime, endTime, table);
				this.statisUserLogs.insertStatis(newTable);
			}
		}
	}

	// }
	// }
	// private void insertStatis(Connection con, String curTime, String
	// startTime, String endTime, String table) {
	// String sql =
	// "insert into userlogs_statis select null,type,subtype,version,channel,'"
	// + curTime + "',count(id),count(distinct(userId)) from " + table +
	// " where type <> 5 and inserttime>='" + startTime + "' and inserttime < '"
	// + endTime + "' group by type,subtype,version,channel";
	// // System.out.println(sql);
	// execute(sql, con);
	// }

	/**
	 * 分表，按日
	 * 
	 * @param con
	 * @param startTime
	 * @param endTime
	 * @param oldTable
	 * @param newTable
	 */
	// private void divideTable(Connection con, long startTime, long endTime,
	// String oldTable, String newTable) {
	// String sql = "create table " + newTable + " as select * from " + oldTable
	// + " where createTime>=" + startTime + " and createTime < " + endTime;
	// // System.out.println(sql);
	// execute(sql, con);
	// }

	/**
	 * 分表成功后，把之前的旧数据给删除掉
	 * 
	 * @param con
	 * @param startTime
	 * @param endTime
	 * @param table
	 */
	// private void deleteItem(Connection con, long startTime, long endTime,
	// String table) {
	// String sql = "delete from " + table + " where createTime>=" + startTime +
	// " and createTime < " + endTime;
	// // System.out.println(sql);
	// execute(sql, con);
	// }

	// public static void main(String[] args) {
	// try {
	// new LogStatistic().start();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

}
