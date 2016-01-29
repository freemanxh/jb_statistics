package com.jb.statistics.rpc.server.thrift.handler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

public abstract class BaseHandler {
	protected static Logger logger = Logger.getLogger(BaseHandler.class);

	// protected static ConnectionManager connectionManager;

	protected DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private final int VIEW_INFO_STEP = 1000;

	private int index;

	protected boolean isPrint() {
		return this.isPrint(VIEW_INFO_STEP);
	}

	protected boolean isPrint(int step) {
		boolean b = false;
		if (index++ % step == 0) {
			b = true;
		}
		if (index >= Integer.MAX_VALUE) {
			index = 0;
		}
		return b;
	}

	public int getIndex() {
		return index;
	}

}
