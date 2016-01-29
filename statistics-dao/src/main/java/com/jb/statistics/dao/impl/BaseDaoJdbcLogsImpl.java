package com.jb.statistics.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDaoJdbcLogsImpl {
	@Autowired
	protected JdbcTemplate jdbcTemplate_logs;

}
