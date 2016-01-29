package com.jb.statistics.dao.logs;

import org.springframework.stereotype.Repository;

@Repository("intoDB0Log")
public class IntoDB0LogImpl extends IntoDBLogImpl {

	protected String getTableName() {
		return "jb_userlogs_0_";
	}

}
