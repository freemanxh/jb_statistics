package com.jb.statistics.cron;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cronConstants")
public class Constants {
	@Value(("#{configProperties['constant.cron.logsTableSize']}"))
	private int logsTableSize;

	public int getLogsTableSize() {
		return logsTableSize;
	}

	public void setLogsTableSize(int logsTableSize) {
		this.logsTableSize = logsTableSize;
	}



}
