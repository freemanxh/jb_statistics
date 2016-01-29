package com.jb.statistics.dao.logs;

import org.springframework.stereotype.Repository;

@Repository("intoDB4Log")
public class IntoDB4LogImpl extends IntoDBLogImpl {

	protected String getTableName() {
		return "jb_userlogs_4_";
	}

}
