package com.jb.statistics.rpc.server.thrift.handler.logs.file;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.statistics.rpc.server.thrift.Constants;

@Service("threadQueue")
public class ThreadQueue implements Runnable {
	private Logger logger = Logger.getLogger(ThreadQueue.class);

	private Queue<Object> queue;

	@Autowired
	private FileManager fileManager;

	@Autowired
	private Constants thriftServerConstants;

	public ThreadQueue(Queue<Object> queue) {
//		this.queue = queue;
//		fileManager = new FileManager();
	}
	
	public ThreadQueue(){
		
	}

	private long writeTimestamp;

	/** 每1分钟生成一次文件 */
	private static final long PER_WRITE_TIME = 1 * 60 * 1000L;

	/**
	 * 判断是否到了生成文件的时候
	 * 
	 * @return
	 */
	private boolean isToTime() {
		if (this.writeTimestamp == 0) {
			this.writeTimestamp = System.currentTimeMillis();
		}
		return (System.currentTimeMillis() - this.writeTimestamp) > PER_WRITE_TIME;
	}

	@Override
	public void run() {
		logger.info("Log module:ThreadQueue is starting...");
		while (true) {
			// 时间到了，立即进行新开文件写数据
			if (isToTime()) {
				writeTimestamp = System.currentTimeMillis();
				fileManager.write2FileNow();
				continue;
			}

			// 用于保存每批次写入到日志文件的日志对象集合
			List<Object> loglist = new ArrayList<Object>();
			while (!queue.isEmpty() && loglist.size() <= thriftServerConstants.getCacheListSize()) {
				// 队列(先进先出)中取出一个日志对象
				Object object = queue.poll();
				if (null != object) {
					loglist.add(object);
				}
			}
			// 如果集合中的日志对象总数达到了每次写入的数量，进行日志写操作
			if (!loglist.isEmpty()) {
				// 将list里面的对象写入到文件中
				fileManager.write2File(loglist);
				logger.info("Log module:queue take " + loglist.size() + " to file manager");
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setQueue(Queue<Object> queue) {
		this.queue = queue;
	}

}
