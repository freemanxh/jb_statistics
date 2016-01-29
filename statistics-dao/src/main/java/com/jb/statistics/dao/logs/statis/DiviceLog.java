package com.jb.statistics.dao.logs.statis;

public interface DiviceLog {

	boolean divideTable(long startTime, long endTime, String oldTable, String newTable);

	void deleteItem(long startTime, long endTime, String table);

}
