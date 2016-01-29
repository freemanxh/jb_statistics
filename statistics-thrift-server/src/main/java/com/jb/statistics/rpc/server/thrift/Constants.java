package com.jb.statistics.rpc.server.thrift;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("thriftServerConstants")
public class Constants {
	@Value(("#{configProperties['constant.thriftServer.thriftServerPort']}"))
	private int serverPort;
	
	@Value(("#{configProperties['constant.thriftServer.search.solrServerUrl']}"))
	private String solrServerUrl;

	@Value(("#{configProperties['constant.thriftServer.search.searchIndex']}"))
	private int searchIndex;

	@Value(("#{configProperties['constant.thriftServer.logs.filePath']}"))
	private String filePath;

	@Value(("#{configProperties['constant.thriftServer.logs.tempFileSize']}"))
	private int tempFileSize;

	@Value(("#{configProperties['constant.thriftServer.logs.cacheListSize']}"))
	private int cacheListSize;

	@Value(("#{configProperties['constant.thriftServer.url.phoneSearchUrl']}"))
	private String phoneSearchUrl;

	@Value(("#{configProperties['constant.thriftServer.url.baiduLBSKey']}"))
	private String baiduLBSKey;

	@Value(("#{configProperties['constant.thriftServer.serverType.setReadBuffer']}"))
	private int readBuffer;

	public int getReadBuffer() {
		return readBuffer;
	}

	public void setReadBuffer(int readBuffer) {
		this.readBuffer = readBuffer;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public String getSolrServerUrl() {
		return solrServerUrl;
	}

	public void setSolrServerUrl(String solrServerUrl) {
		this.solrServerUrl = solrServerUrl;
	}

	public int getSearchIndex() {
		return searchIndex;
	}

	public void setSearchIndex(int searchIndex) {
		this.searchIndex = searchIndex;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getTempFileSize() {
		return tempFileSize;
	}

	public void setTempFileSize(int tempFileSize) {
		this.tempFileSize = tempFileSize;
	}

	public int getCacheListSize() {
		return cacheListSize;
	}

	public void setCacheListSize(int cacheListSize) {
		this.cacheListSize = cacheListSize;
	}

	public String getPhoneSearchUrl() {
		return phoneSearchUrl;
	}

	public void setPhoneSearchUrl(String phoneSearchUrl) {
		this.phoneSearchUrl = phoneSearchUrl;
	}

	public String getBaiduLBSKey() {
		return baiduLBSKey;
	}

	public void setBaiduLBSKey(String baiduLBSKey) {
		this.baiduLBSKey = baiduLBSKey;
	}

}
