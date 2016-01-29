package com.jb.statistics.dao.logs;

import org.springframework.stereotype.Repository;

@Repository("intoDB1Log")
public class IntoDB1LogImpl extends IntoDBLogImpl {

	protected String getTableName() {
		return "jb_userlogs_1_";
	}

}
