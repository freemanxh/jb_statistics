package com.jb.statistics.dao.logs.statis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jb.statistics.dao.impl.BaseDaoJdbcLogsImpl;
import com.jb.statistics.dao.logs.statis.entities.ClickBean;
import com.jb.statistics.dao.logs.statis.entities.ClickFunctionBean;
import com.jb.statistics.dao.logs.statis.entities.ProjectBean;
import com.jb.statistics.dao.logs.statis.entities.UserCountBean;

@Repository("countLogs")
public class CountLogsImpl extends BaseDaoJdbcLogsImpl implements CountLogs {

	public List<ClickBean> countByHour(String startDate, String endDate, String projectId, int type, int subType) {
		if (type > 0 && subType <= 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder("select right(countTime_,2) as theHour,sum(times_) theTimes from jb_userlogs_statistics where 1=1");
		if (projectId != null) {
			sb.append(" and projectId_='");
			sb.append(projectId);
			sb.append("'");
		}

		if (type > 0) {
			sb.append(" and type=");
			sb.append(type);
		}
		if (subType > 0) {
			sb.append(" and subType=");
			sb.append(subType);
		}
		if (startDate != null) {
			sb.append(" and left(countTime_,10)>='" + startDate + "'");
		}
		if (endDate != null) {
			sb.append(" and left(countTime_,10)<='" + endDate + "'");
		}

		sb.append(" group by right(countTime_,2)");

		List<?> list = this.jdbcTemplate_logs.query(sb.toString(), new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				ClickBean cb = new ClickBean();
				cb.setTimes(rs.getInt("theTimes"));
				cb.setTimeSeg(String.valueOf(new Integer(rs.getString("theHour")).intValue()));
				cb.setUsers(0);
				// TODO Auto-generated method stub
				return cb;
			}
		});

		List<ClickBean> ll = new ArrayList<ClickBean>();
		if (list != null && list.size() > 0) {
			for (Object o : list) {
				ll.add((ClickBean) o);
			}
		}
		return ll;
	}

	/**
	 * 按项目按日统计
	 * 
	 * @param startDate
	 * @param endDate
	 * @param projectId
	 * @return
	 */
	public List<ClickFunctionBean> countByDayByProject(String startDate, String endDate, String projectId) {
		StringBuilder sb = new StringBuilder("select subType_,sum(times_) theTimes from jb_userlogs_statistics_day where 1=1 and type_=1 and subType_>=1 and subType_<=20 ");
		if (projectId != null) {
			sb.append(" and projectId_='");
			sb.append(projectId);
			sb.append("'");
		}

		if (startDate != null) {
			sb.append(" and countTime_>='" + startDate + "'");
		}
		if (endDate != null) {
			sb.append(" and countTime_<='" + endDate + "'");
		}

		sb.append(" group by subType_");

		List<?> list = this.jdbcTemplate_logs.query(sb.toString(), new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				ClickFunctionBean cfb = new ClickFunctionBean();
				cfb.setFunctionType(String.valueOf(rs.getInt("subType_")));
				cfb.setTimes(rs.getInt("theTimes"));
				// TODO Auto-generated method stub
				return cfb;
			}
		});

		List<ClickFunctionBean> ll = new ArrayList<ClickFunctionBean>();
		if (list != null && list.size() > 0) {
			for (Object o : list) {
				ll.add((ClickFunctionBean) o);
			}
		}
		return ll;
	}

	public Map<String, Integer> countNewUesrs(String startDate, String endDate, String projectId) {
		StringBuilder sb = new StringBuilder("select projectId_,count(id) as theCount from jb_newusers where 1=1");
		if (projectId != null) {
			sb.append(" and projectId_='");
			sb.append(projectId);
			sb.append("'");
		}

		if (startDate != null) {
			sb.append(" and from_unixtime(createTime_/1000,'%Y-%m-%d')>='" + startDate + "'");
		}
		if (endDate != null) {
			sb.append(" and from_unixtime(createTime_/1000,'%Y-%m-%d')<='" + endDate + "'");
		}

		sb.append(" group by projectId_");

		List<?> list = this.jdbcTemplate_logs.query(sb.toString(), new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put(rs.getString("projectId_"), rs.getInt("theCount"));
				return map;
			}
		});

		Map<String, Integer> map = new HashMap<String, Integer>();

		if (list != null && list.size() > 0) {
			for (Object o : list) {
				Map<String, Integer> mapTemp = (Map<String, Integer>) o;
				map.putAll(mapTemp);
			}
		}
		return map;
	}

	public Map<String, Integer> countActiveUsers(String startDate, String endDate, String projectId) {
		StringBuilder sb = new StringBuilder("select projectId_,count(distinct(userId_)) as theCount from jb_userlogs_0_ where 1=1  and type_=1 and subType_>=1 and subType_<=20 ");

		if (projectId != null) {
			sb.append(" and projectId_='");
			sb.append(projectId);
			sb.append("'");
		}

		if (startDate != null) {
			sb.append(" and from_unixtime(createTime_/1000,'%Y-%m-%d')>='" + startDate + "'");
		}
		if (endDate != null) {
			sb.append(" and from_unixtime(createTime_/1000,'%Y-%m-%d')<='" + endDate + "'");
		}

		sb.append(" group by projectId_");

		List<?> list = this.jdbcTemplate_logs.query(sb.toString(), new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put(rs.getString("projectId_"), rs.getInt("theCount"));
				return map;
			}
		});

		Map<String, Integer> map = new HashMap<String, Integer>();

		if (list != null && list.size() > 0) {
			for (Object o : list) {
				Map<String, Integer> mapTemp = (Map<String, Integer>) o;
				map.putAll(mapTemp);
			}
		}
		return map;
	}

	public List<ProjectBean> listProjects() {
		String sql = "select * from jb_projects order by projectName_";

		List<?> list = this.jdbcTemplate_logs.query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProjectBean pb = new ProjectBean();
				pb.setProjectId(rs.getString("projectId_"));
				pb.setProjectName(rs.getString("projectName_"));
				return pb;
			}
		});
		List<ProjectBean> ll = new ArrayList<ProjectBean>();
		if (list != null && list.size() > 0) {
			for (Object o : list) {
				ll.add((ProjectBean) o);
			}
		}
		return ll;
	}
}
