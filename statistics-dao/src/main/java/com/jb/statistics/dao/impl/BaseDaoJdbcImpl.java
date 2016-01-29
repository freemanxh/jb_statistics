package com.jb.statistics.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jb.statistics.common.utils.Constants;

public class BaseDaoJdbcImpl {
    
    @Autowired
    protected Constants daoConstants;
    
	@Autowired
	protected JdbcTemplate jdbcTemplate;
}
