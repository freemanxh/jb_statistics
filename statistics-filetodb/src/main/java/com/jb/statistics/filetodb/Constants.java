package com.jb.statistics.filetodb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("file2dbConstants")
public class Constants {
	@Value(("#{configProperties['constant.file2db.filePath']}"))
	private String filePath;
	
	@Value(("#{configProperties['constant.file2db.entityClassName']}"))
	private String entityClassName;
	
	@Value(("#{configProperties['constant.file2db.readFileRecordCount']}"))
	private int readFileRecordCount;
	
	@Value(("#{configProperties['constant.file2db.writeFileSleep']}"))
	private long writeFileSleep;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getEntityClassName() {
		return entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}

	public int getReadFileRecordCount() {
		return readFileRecordCount;
	}

	public void setReadFileRecordCount(int readFileRecordCount) {
		this.readFileRecordCount = readFileRecordCount;
	}

	public long getWriteFileSleep() {
		return writeFileSleep;
	}

	public void setWriteFileSleep(long writeFileSleep) {
		this.writeFileSleep = writeFileSleep;
	}

}
