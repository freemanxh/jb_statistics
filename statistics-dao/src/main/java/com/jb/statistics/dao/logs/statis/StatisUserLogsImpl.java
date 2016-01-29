package com.jb.statistics.dao.logs.statis;

import org.springframework.stereotype.Repository;

import com.jb.statistics.dao.impl.BaseDaoJdbcLogsImpl;

@Repository("statisUserLogs")
public class StatisUserLogsImpl extends BaseDaoJdbcLogsImpl implements StatisUserLogs{

	public void insertStatis(String table) {
		// String sql =
		// "insert into wm_userlogs_statis select null,type,subtype,version,channel,'"+curTime+"',count(id),count(distinct(userId)) from "+table+" where type <> 9 and type <> 7 and inserttime>="+startTime+" and inserttime < "+endTime+" group by type,subtype,version,channel";
		// String sql =
		// "insert into wm_userlogs_statis select null,type,subtype,version,channel,'"+curTime+"',count(id),count(distinct(userId)) from "+table+" where type <> 9 and type <> 7 and inserttime>="+startTime+" and inserttime < "+endTime+" group by type,subtype,version,channel";
		// jb_userlogs_0_
		
		
		String sql = "insert into jb_userlogs_statistics (projectId_,type_,subtype_,sub2Type_,sub3Type_,version_,channel_,os_,os_version_,countTime_,times_,users_) select projectId_,type_,subtype_,sub2Type_,sub3Type_,version_,channel_,os_,os_version_,FROM_UNIXTIME(createTime_/1000, '%Y-%m-%d:%H') as countTime_,count(id_) as times_,count(distinct(userId_)) as users_ from " + table + " group by projectId_,type_,subtype_,version_,channel_,sub2Type_,sub3Type_,os_,os_version_,FROM_UNIXTIME(createTime_/1000, '%Y-%m-%d%H')";
		
		System.out.println("group by :"+sql);
		
		this.jdbcTemplate_logs.update(sql);
		
		String sqlByDay = "insert into jb_userlogs_statistics_day (projectId_,type_,subtype_,sub2Type_,sub3Type_,version_,channel_,os_,os_version_,countTime_,times_,users_) select projectId_,type_,subtype_,sub2Type_,sub3Type_,version_,channel_,os_,os_version_,FROM_UNIXTIME(createTime_/1000, '%Y-%m-%d') as countTime_,count(id_) as times_,count(distinct(userId_)) as users_ from " + table + " group by projectId_,type_,subtype_,version_,channel_,sub2Type_,sub3Type_,os_,os_version_,FROM_UNIXTIME(createTime_/1000, '%Y-%m-%d')";
		
		this.jdbcTemplate_logs.update(sqlByDay);
		
		System.out.println("group by Day:"+sqlByDay);
	}

}
