package com.jb.statistics.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jb.statistics.dao.logs.statis.CountLogs;

public abstract class BaseServiceImpl {
	@Autowired
	protected CountLogs countLogs;
}
