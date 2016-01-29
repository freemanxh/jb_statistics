package com.jb.statistics.filetodb.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jb.statistics.dao.logs.IntoDataBase;

@Service("file2DataBase2")
public class File2DataBase2 extends AbstFile2DataBase {

	/**
	 * 把cmem相关对象入库
	 */
	@Autowired
	private IntoDataBase intoDB2Log;

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContextDao.xml", "applicationContextFile2DB.xml" });

		File2DataBase2 file2DataBase2 = (File2DataBase2) ac.getBean("file2DataBase2");

		file2DataBase2.file2DataBase();
	}

	@Override
	protected IntoDataBase getIntoDataBase() {
		return intoDB2Log;
	}

}
