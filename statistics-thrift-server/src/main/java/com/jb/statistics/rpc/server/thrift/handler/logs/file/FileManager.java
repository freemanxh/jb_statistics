package com.jb.statistics.rpc.server.thrift.handler.logs.file;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.statistics.rpc.server.thrift.CollUtil;
import com.jb.statistics.rpc.server.thrift.Constants;

@Service("fileManager")
public class FileManager {

	private Logger logger = Logger.getLogger(FileManager.class);

	@Autowired
	private Constants thriftServerConstants;

	/** 打印输出流 */
	private PrintWriter printWrite;

	/** 缓存写输出 */
	private BufferedWriter bw;

	/** 当前正在写的文件 */
	private File currentFile;

	/** 文件已经写入的行书 */
	private int rows = -1;

	/**
	 * 立刻写成正式文件
	 */
	public void write2FileNow() {
		if (null != currentFile) {
			if (currentFile.length() > 0) {
				newFile();
			}
		}
	}

	/**
	 * 将队列中的数据写入到文件中
	 * 
	 * @param logList
	 */
	public void write2File(List<Object> logList) {
		// 检查文件的有效性
		while (!checkFile()) {
			logger.error("检测文件失败，稍后重新进行!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (CollUtil.notEmpty(logList)) {
			logger.info("开始写文件，本次写入" + logList.size() + "个日志对象");
			int size = this.thriftServerConstants.getTempFileSize();
			if (logList.size() > size) {
				size = logList.size();
			}
			for (Object object : logList) {
				// System.out.println("44444444444444");
				printWrite.println(object.toString());
				// System.out.println(object.toString());
				rows++;
				// 如果当前文件已经写满，生成新文件
				if (rows >= size) {
					newFile();
				}
			}
			printWrite.flush();
		}
	}

	/**
	 * 检查当前文件情况
	 * 
	 * @return
	 */
	private boolean checkFile() {
		// 程序启动第一次
		if (rows == -1) {
			if (!newFile()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 如果符合条件了，新生成一个文件。
	 */
	private boolean newFile() {
		boolean b = this.closeAll();
		if (!b) {
			return b;
		}

		String fileNamePrev = this.thriftServerConstants.getFilePath();
		if (!fileNamePrev.endsWith("/")) {
			fileNamePrev += "/";
		}
		String fileName = fileNamePrev + "logs_" + System.currentTimeMillis() + ".temp";
		currentFile = new File(fileName);
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(currentFile))));
			printWrite = new PrintWriter(bw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			b = false;
		} finally {
			// 如果发生异常，要进行资源关闭操作，如果没有异常，就在下一个文件生成时进行资源关闭操作。
			if (!b) {
				closeAll();
			}
		}
		// 如果新生成文件成功，才进行重置操作。
		if (b) {
			rows = 0;
		}
		return b;
	}

	/**
	 * 新生成文件前，关掉上次文件的所有资源，并释放。
	 */
	private boolean closeAll() {
		boolean b = true;
		if (printWrite != null) {
			printWrite.flush();
			printWrite.close();
		}

		if (bw != null) {
			try {
				bw.close();
			} catch (IOException e) {
				b = false;
				e.printStackTrace();
			}
		}

		if (currentFile != null) {
			String oldName = currentFile.getName();
			String newName = oldName.substring(0, oldName.indexOf("."));

			currentFile.renameTo(new File(this.thriftServerConstants.getFilePath() + newName));
		}
		return b;
	}

}
