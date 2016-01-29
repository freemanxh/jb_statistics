package com.jb.statistics.filetodb.server;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.jb.statistics.dao.logs.IntoDataBase;
import com.jb.statistics.filetodb.Constants;
import com.jb.statistics.filetodb.readfile.ReadFile;
//import com.utree.workmate.filetodb.intodb.IntoDBFactory;
//import com.utree.workmate.filetodb.intodb.IntoDataBase;

public abstract class AbstFile2DataBase {

	private static Logger logger = Logger.getLogger(AbstFile2DataBase.class);

	@Autowired
	protected Constants file2dbConstants;
	/**
	 * 读取文件
	 */
	@Autowired
	protected ReadFile readFile;

	// = new ReadFileImpl();

	protected abstract IntoDataBase getIntoDataBase();

	// = IntoDBFactory.getIntoDataBaseObj(Utils.SERVER_CLASS_NAME);

	public void file2DataBase() {

		while (true) {
			// 读取文件列表
			List<Object> sqlList = this.readFile.readFiles();
			if (sqlList != null && !sqlList.isEmpty()) {
				if (this.getIntoDataBase().intoDataBase(sqlList)) {
					this.readFile.deleteFiles();
				}
			}

			try {
				Thread.sleep(this.file2dbConstants.getWriteFileSleep());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
