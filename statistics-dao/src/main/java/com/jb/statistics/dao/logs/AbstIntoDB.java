package com.jb.statistics.dao.logs;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.jb.statistics.dao.impl.BaseDaoJdbcLogsImpl;
import com.jb.statistics.rpc.thrift.LogsRequ;

public abstract class AbstIntoDB extends BaseDaoJdbcLogsImpl implements IntoDataBase {

	// private static String BATCH_INSERT_SQL;

	protected abstract String getSql();

	@Override
	public boolean intoDataBase(List<Object> sqlList) {
		final List<LogsRequ> ll = new ArrayList<LogsRequ>();
		if (sqlList != null) {
			for (Object obj : sqlList) {
				LogsRequ logsRequ = (LogsRequ) obj;
				// 是新增用户
				if (logsRequ.getType() == 2 && logsRequ.getSubType() == 1) {
					ll.add(logsRequ);
				}
			}
		}

		if (ll.size() > 0) {
			int[] results = this.jdbcTemplate_logs.batchUpdate("insert into jb_newusers (userId_,projectId_,createTime_,version_,channel_,os_,os_version_,device_) values (?,?,?,?,?,?,?,?)", new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pstmt, int i) throws SQLException {
					LogsRequ logsRequ = ll.get(i);
					if (null != logsRequ) {
						pstmt.setString(1, logsRequ.getId());
						pstmt.setString(2, logsRequ.getProjectId());
						pstmt.setLong(3, logsRequ.getCreateTime());

						pstmt.setString(4, logsRequ.getVersion());
						pstmt.setString(5, logsRequ.getChannel());
						pstmt.setInt(6, logsRequ.getOs());
						pstmt.setString(7, logsRequ.getOsVersion());
						pstmt.setString(8, logsRequ.getDevice());
						// pstmt.addBatch();
					}
				}

				@Override
				public int getBatchSize() {
					return ll.size();
				}
			});
		}

		return intoDB(sqlList);
	}

	protected abstract void setPstmt(PreparedStatement pstmt, Object obj) throws SQLException;

	protected boolean intoDB(final List<Object> sqlList) {

		int[] results = this.jdbcTemplate_logs.batchUpdate(getSql(), new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Object obj = sqlList.get(i);
				setPstmt(ps, obj);
			}

			@Override
			public int getBatchSize() {
				return sqlList.size();
			}
		});

		return results.length > 0;
	}

}
