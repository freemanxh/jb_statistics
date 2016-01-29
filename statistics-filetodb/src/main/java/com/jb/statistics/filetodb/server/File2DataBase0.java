package com.jb.statistics.filetodb.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jb.statistics.dao.logs.IntoDataBase;

@Service("file2DataBase0")
public class File2DataBase0 extends AbstFile2DataBase {

	/**
	 * 把cmem相关对象入库
	 */
	@Autowired
	private IntoDataBase intoDB0Log;

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContextDao.xml", "applicationContextFile2DB.xml" });

		File2DataBase0 file2DataBase0 = (File2DataBase0) ac.getBean("file2DataBase0");

		file2DataBase0.file2DataBase();
		
	}

	@Override
	protected IntoDataBase getIntoDataBase() {
		return intoDB0Log;
	}

}
