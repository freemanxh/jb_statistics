package com.jb.statistics.dao.logs.statis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jb.statistics.dao.impl.BaseDaoJdbcLogsImpl;

@Repository("diviceLog")
public class DiviceLogTable extends BaseDaoJdbcLogsImpl implements DiviceLog {

	/**
	 * 分表，按日
	 * 
	 * @param startTime
	 * @param endTime
	 * @param oldTable
	 * @param newTable
	 */
	public boolean divideTable(long startTime, long endTime, String oldTable, String newTable) {

		String sqlSelect = "select count(*) as theCount from " + oldTable + " where createTime_>=" + startTime + " and createTime_ < " + endTime;
		System.out.println("sqlSelect:" + sqlSelect);
		List<?> list = this.jdbcTemplate_logs.query(sqlSelect, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getInt("theCount");
			}
		});
		int count = 0;
		if (list != null && list.size() > 0) {
			count = ((Integer) list.get(0)).intValue();
		}

		String sql = "create table " + newTable + " as select * from " + oldTable + " where createTime_>=" + startTime + " and createTime_ < " + endTime;
		System.out.println("create table sql:" + sql);
		try {
			int r = this.jdbcTemplate_logs.update(sql);
			if (r == count) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 分表成功后，把之前的旧数据给删除掉
	 * 
	 * @param con
	 * @param startTime
	 * @param endTime
	 * @param table
	 */
	public void deleteItem(long startTime, long endTime, String table) {
		String sql = "delete from " + table + " where createTime_>=" + startTime + " and createTime_ < " + endTime;
		System.out.println("delete:" + sql);
		// this.jdbcTemplate_logs.update(sql);
	}
}
