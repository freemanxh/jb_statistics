package com.jb.statistics.rpc.server.thrift.handler.logs;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.statistics.rpc.server.thrift.handler.logs.file.ThreadQueue;
import com.jb.statistics.rpc.thrift.LogsRequ;
import com.jb.statistics.rpc.thrift.LogsResp;

@Service("logsProxyHandler")
public class LogsProxyHandler implements com.jb.statistics.rpc.thrift.LogsService.Iface {
	// queue
	private Queue<Object> logsQueue = new ConcurrentLinkedQueue<Object>();

	// private static Executor executor =
	// Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() *
	// 4);

	@Autowired
	private ThreadQueue threadQueue;

	private boolean init;

	public LogsProxyHandler() {
		// new Thread(new ThreadQueue(logsQueue)).start();
		// executor.execute(new ThreadQueue(logsQueue));
	}

	/**
	 * 返回成功
	 * 
	 * @return
	 */
	private LogsResp returnSuccess() {
		LogsResp logsResp = new LogsResp();
		// 设置响应结果码为200
		logsResp.setCode(200);
		return logsResp;
	}

	// @Override
	// public OperateResult logByThrift(ClockLog clockLog) throws TException {
	// // 将客户端传输的对象放入队列当中
	// logsQueue.offer(clockLog);
	// return returnSuccess();
	// }

	@Override
	public LogsResp logByThrift(LogsRequ logsRequ) throws TException {
		if (!this.init) {
			this.threadQueue.setQueue(this.logsQueue);
			// new Thread(new ThreadQueue(logsQueue)).start();
			new Thread(this.threadQueue).start();
			this.init = true;
		}

//		System.out.println("run here:"+logsRequ);
		// 将客户端传输的对象放入队列当中
		logsQueue.offer(logsRequ);
		return returnSuccess();
	}
	// @Override
	// public OperateResult clockCallFlowByThrift(ClockCallFlow clockCallFlow)
	// throws TException {
	// logsQueue.offer(clockCallFlow);
	// return returnSuccess();
	// }
	//
	// @Override
	// public OperateResult clockUserModifyFlowByThrift(ClockUserModifyFlow
	// clockUserModifyFlow) throws TException {
	// logsQueue.offer(clockUserModifyFlow);
	// return returnSuccess();
	// }
	//
	// @Override
	// public OperateResult clockMsgConfirmByThrift(ClockMsgConfirm
	// clockMsgConfirm) throws TException {
	// logsQueue.offer(clockMsgConfirm);
	// return returnSuccess();
	// }
}
