package com.jb.statistics.rpc.server.thrift.handler.server;

import java.util.List;
import java.util.Map;

import org.apache.thrift.TProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jb.statistics.dao.logs.statis.CountLogs;
import com.jb.statistics.dao.logs.statis.entities.ClickBean;
import com.jb.statistics.dao.logs.statis.entities.ClickFunctionBean;
import com.jb.statistics.dao.logs.statis.entities.ProjectBean;
import com.jb.statistics.dao.logs.statis.entities.UserCountBean;
import com.jb.statistics.rpc.server.thrift.Util;
import com.jb.statistics.rpc.server.thrift.handler.logs.LogsProxyHandler;

@Service("logsProxyServer")
public class LogsProxyServer extends BaseServer {

	// private static Logger logger = Logger.getLogger(ProxyServer.class);

	@Autowired
	private LogsProxyHandler logsProxyHandler;

	@Autowired
	private CountLogs countLogs;

	//
	// /**
	// * @param args
	// */
	// public static void main(String[] args) {
	// logger.info("proxyserver is Starting...");
	// System.out.println("proxyserver is Starting... port:"+Utils.PORT);
	// try {
	// TServerSocket serverTransport = new TServerSocket(Utils.PORT,
	// Utils.CLIENT_TIMEOUT);
	// LogService.Processor processor = new LogService.Processor(new
	// ProxyHandler());
	// TBinaryProtocol.Factory portFactory = new TBinaryProtocol.Factory(true,
	// true);
	// TThreadPoolServer.Args arg = new TThreadPoolServer.Args(serverTransport);
	//
	// arg.processor(processor);
	// arg.protocolFactory(portFactory);
	// TServer server = new TThreadPoolServer(arg);
	// server.serve();
	// } catch (TTransportException e) {
	// e.printStackTrace();
	// }
	// }

	// public void doDb() {
	// System.out.println("...run...");
	//
	// // List<ClickBean> list = countLogs.countByHour("2016-01-26",
	// // "2016-01-26", "44717878", 0, 0);
	// // System.out.println("----list:" + list);
	//
	// // List<ClickFunctionBean>
	// // list2=this.countLogs.countByDayByProject("2016-01-25", "2016-01-26",
	// // "44717878");
	// // System.out.println("--list2:"+list2);
	//
	// // List<UserCountBean> list2 =
	// this.countLogs.countNewUserByDayByProject("2016-01-25", "2016-01-29",
	// null);
	// // System.out.println("--list2:" + list2);
	//
	// }

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContextDao.xml", "applicationContextThriftServer.xml" });
		if (ac != null) {
			Util.ac = ac;

			LogsProxyServer logsProxyServer = (LogsProxyServer) ac.getBean("logsProxyServer");
			// logsProxyServer.doDb();
			logsProxyServer.startServer();
		}

	}

	@Override
	public TProcessor getProcess() {
		return new com.jb.statistics.rpc.thrift.LogsService.Processor<LogsProxyHandler>(logsProxyHandler);
	}

}
