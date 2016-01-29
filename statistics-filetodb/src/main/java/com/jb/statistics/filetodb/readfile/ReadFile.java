package com.jb.statistics.filetodb.readfile;

import java.util.List;

public interface ReadFile {
	/** 批量读取文件 */
	List<Object> readFiles();

	/** 删除已经读取过的文件 */
	void deleteFiles();
}
