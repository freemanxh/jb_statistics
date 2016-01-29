package com.jb.statistics.dao.logs;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("intoDB3Log")
public class IntoDB3LogImpl extends IntoDBLogImpl {

	protected String getTableName() {
		return "jb_userlogs_3_";
	}

}
