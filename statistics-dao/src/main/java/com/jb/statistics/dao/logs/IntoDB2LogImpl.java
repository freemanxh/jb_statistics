package com.jb.statistics.dao.logs;

import org.springframework.stereotype.Repository;

@Repository("intoDB2Log")
public class IntoDB2LogImpl extends IntoDBLogImpl {

	protected String getTableName() {
		return "jb_userlogs_2_";
	}

}
