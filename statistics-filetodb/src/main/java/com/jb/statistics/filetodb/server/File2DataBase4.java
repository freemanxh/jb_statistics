package com.jb.statistics.filetodb.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jb.statistics.dao.logs.IntoDataBase;

@Service("file2DataBase4")
public class File2DataBase4 extends AbstFile2DataBase {

	/**
	 * 把cmem相关对象入库
	 */
	@Autowired
	private IntoDataBase intoDB4Log;

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContextDao.xml", "applicationContextFile2DB.xml" });

		File2DataBase4 file2DataBase4 = (File2DataBase4) ac.getBean("file2DataBase4");

		file2DataBase4.file2DataBase();
	}

	@Override
	protected IntoDataBase getIntoDataBase() {
		return intoDB4Log;
	}

}
