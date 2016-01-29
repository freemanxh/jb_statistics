package com.jb.statistics.rpc.client.thrift;

public abstract class BaseTask implements Runnable {

	@Override
	abstract public void run();
}
