package com.jb.statistics.rpc.server.thrift.handler.server;

import org.apache.log4j.Logger;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jb.statistics.rpc.server.thrift.Constants;

public abstract class BaseServer {
	protected Logger logger = Logger.getLogger(BaseServer.class);

	@Autowired
	private Constants thriftServerConstants;

	public abstract TProcessor getProcess();

	public void startServer() {
		try {
			int port = this.thriftServerConstants.getServerPort();
			// 传输通道 - 非阻塞方式
			TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(port);

			// 异步IO，需要使用TFramedTransport，它将分块缓存读取。
			TTransportFactory transportFactory = new TFramedTransport.Factory();

			// 使用高密度二进制协议
			TProtocolFactory proFactory = new TCompactProtocol.Factory();

			// 设置处理器 HelloImpl
			TProcessor processor = getProcess();
			// new
			// com.utree.test.testthrift.model.TestService.Processor(handler);

			// 创建服务器
			TServer server = null;
			if (thriftServerConstants.getReadBuffer() == 1) {
				// 此代码目前只在baidu push及sms send上面使用，其它的用下面的代码
				// 由于百度云相关服务crashed,增加参数限制tnbArgs.maxReadBufferBytes = 128;
				TThreadedSelectorServer.Args args = new TThreadedSelectorServer.Args(serverTransport);
				args.maxReadBufferBytes = 128;
				server = new TThreadedSelectorServer(args.protocolFactory(proFactory).transportFactory(transportFactory).processor(processor));
			} else {
				server = new TThreadedSelectorServer(new TThreadedSelectorServer.Args(serverTransport).protocolFactory(proFactory).transportFactory(transportFactory).processor(processor));
			}

			// TServer server = new TThreadedSelectorServer(new
			// TThreadedSelectorServer.Args(serverTransport).protocolFactory(proFactory).transportFactory(transportFactory).processor(processor));

			logger.info("Start server on port " + port + "...");
			server.serve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//
	// TestService.Processor processor = new TestService.Processor(handler);
	//
	// try {
	// TServerTransport serverTransport = new TServerSocket(9090);
	// TServer server = new TSimpleServer(
	// new Args(serverTransport).processor(processor));
	//
	// // Use this for a multithreaded server
	// TServer server = new TThreadPoolServer(
	// new TThreadPoolServer.Args(serverTransport)
	// .processor(processor));
	//
	// TServer server=new TThreadedSelectorServer(new
	// TThreadedSelectorServer.Args(serverTransport).processor(processor));
	//
	// System.out.println("Starting the simple server...");
	// server.serve();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }

}
