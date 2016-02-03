package com.jb.statistics.cron.job;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jb.statistics.cron.logstatistics.LogStatistic;

@Service("logStatisticJob")
public class LogStatisticJob {
	public static Logger logger = Logger.getLogger(LogStatisticJob.class);

	@Autowired
	private LogStatistic logStatistic;

	public void run() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, -1);
		this.logStatistic.statis(c);

		System.out.println("run run ...." + c.getTime().toString());
	}

	public void cal(String date) {
		this.logStatistic.statis(date);
	}

	// @Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		System.out.println("run quartzjob...");
		// long start = System.currentTimeMillis();
		// logger.error("start statistic job...");
		// Connection con = getConnection();
		// try {
		// con.setAutoCommit(false);
		// } catch (SQLException e1) {
		// e1.printStackTrace();
		// }
		// try {
		// String startTime = DateUtil.getYesterdayZero();
		// String endTime = DateUtil.getTodayZero();
		// long dayStartTime = DateUtil.getMillins(startTime);
		// long dayEndTime = DateUtil.getMillins(endTime);
		// String curTime = DateUtil.getCurTime("yyyy-MM-dd hh:mm:ss");
		//
		// for(Object key : config.keySet()){
		// String keyStr = (String)key;
		// if(keyStr.startsWith("log_table")){
		// String table = "wm_userlogs" +
		// keyStr.substring(keyStr.lastIndexOf("_"),keyStr.length());
		// String newTable = table + "_" + DateUtil.getYesTime("yyyy_MM_dd");
		// insertStatis(con, startTime, dayStartTime, dayEndTime, table);
		// divideTable(con, dayStartTime, dayEndTime, table, newTable);
		// deleteItem(con, dayStartTime, dayEndTime, table);
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
		// logger.error("end statistic job... cost time : " +
		// (System.currentTimeMillis() - start) + "ms" );
	}

	// private void insertStatis(Connection con,String curTime,long
	// startTime,long endTime,String table){
	// String sql =
	// "insert into wm_userlogs_statis select null,type,subtype,version,channel,'"+curTime+"',count(id),count(distinct(userId)) from "+table+" where type <> 9 and type <> 7 and inserttime>="+startTime+" and inserttime < "+endTime+" group by type,subtype,version,channel";
	// logger.error("static sql:" + sql);
	// execute(sql, con);
	// }
	//
	// private void divideTable(Connection con,long startTime,long
	// endTime,String oldTable,String newTable){
	// String sql = "create table " +newTable + " as select * from " + oldTable
	// + " where inserttime>="+startTime+" and inserttime < "+endTime;
	// logger.debug("divide table sql:" + sql);
	// execute(sql, con);
	// }
	//
	// private void deleteItem(Connection con,long startTime,long endTime,String
	// table){
	// String sql = "delete from " + table
	// +" where inserttime>="+startTime+" and inserttime < "+endTime;
	// logger.error("delete item sql:" + sql);
	// execute(sql,con);
	// }

	public static void main(String[] args) {

		ApplicationContext ac = null;
		if (args.length == 0) {
			ac = new ClassPathXmlApplicationContext(new String[] { "applicationContextDao.xml", "applicationContextCron.xml", "spring-quartz.xml" });
		} else {
			String date = args[0];
			ac = new ClassPathXmlApplicationContext(new String[] { "applicationContextDao.xml", "applicationContextCron.xml" });

			LogStatisticJob logStatisticJob = (LogStatisticJob) ac.getBean("logStatisticJob");

			// String[] strs = new String[] { "2016-01-28", "2016-01-29",
			// "2016-01-30", "2016-01-31", "2016-02-01", "2016-02-02" };
			// for (String s : strs) {
			logStatisticJob.cal(date);
			// }

		}

		// LogStatistic logStatistic = (LogStatistic)
		// ac.getBean("logStatistic");

		// Calendar c = Calendar.getInstance();
		// logStatistic.divide(c);
		// System.out.println(ac);

	}

}