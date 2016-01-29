package com.jb.statistics.filetodb.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jb.statistics.dao.logs.IntoDataBase;

@Service("file2DataBase3")
public class File2DataBase3 extends AbstFile2DataBase {

	/**
	 * 把cmem相关对象入库
	 */
	@Autowired
	private IntoDataBase intoDB3Log;

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContextDao.xml", "applicationContextFile2DB.xml" });

		File2DataBase3 file2DataBase3 = (File2DataBase3) ac.getBean("file2DataBase3");

		file2DataBase3.file2DataBase();
	}

	@Override
	protected IntoDataBase getIntoDataBase() {
		return intoDB3Log;
	}

}
