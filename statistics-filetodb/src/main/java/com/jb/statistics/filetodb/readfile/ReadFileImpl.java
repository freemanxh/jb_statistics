package com.jb.statistics.filetodb.readfile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.statistics.filetodb.Constants;

@Service("readFile")
public class ReadFileImpl implements ReadFile {

	@Autowired
	private Constants file2dbConstants;

	/**
	 * 用于存放此类的fields,只需要运算一次
	 */
	private Field[] fields;

	/** 用于保存日志sql语句 */
	private List<Object> strList;

	/** 读取日志文件所在的目录 */
	private File dir;

	/** 读取到内存中的文件对象 */
	private List<File> readedFiles;

	private Class<?> clazz;

	public ReadFileImpl() {
	}

	@Override
	public List<Object> readFiles() {
		strList = new ArrayList<Object>(); 
		readedFiles = new ArrayList<File>();
		if (this.dir == null) {
			this.dir = new File(this.file2dbConstants.getFilePath());
		}

		// 获得目录下的所有日志文件
		File[] files = this.dir.listFiles();

		if (files == null || files.length == 0) {
			return null;
		}
		
		List<File> ll=new ArrayList<File>();
		for (File f:files){
			if (f.getName().indexOf(".temp") >= 0) {
				continue;
			}
			ll.add(f);
		}
		
		File[] fs=new File[ll.size()];
		fs=ll.toArray(fs);
		files=fs;

		// 得到每次的要进行操作文件的最大数
		int count = files.length <= this.file2dbConstants.getReadFileRecordCount() ? files.length : this.file2dbConstants.getReadFileRecordCount();
		for (int i = 0; i < count; i++) {
			File file = files[i];
			// temp类型的文件可能还处于在进行写状态，不能对此进行操作

			if (readFile(file)) {
				this.readedFiles.add(file);
			}
		}

		return strList;
	}

	/**
	 * 读取文件
	 * 
	 * @param file
	 * @return
	 */
	private boolean readFile(File file) {
		boolean b = false;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(file))));
			String s = null;
			while ((s = br.readLine()) != null) {
				// 将字符串转换成对象
				strList.add(convertString2Object(s));
			}
			b = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}

	/**
	 * 将日志字符串转换为sql语句
	 * 
	 * @param logStr
	 * @returnsqlList
	 */
	private Object convertString2Object(String logStr) {
		Object obj = null;
		if (null != logStr && logStr.indexOf("(") > -1) {
			// 截取获得属性部分的字符串
			logStr = logStr.substring(logStr.indexOf("(") + 1, logStr.length() - 1);
			String[] array = logStr.split(",");
			// 将所有属性封装到map
			Map<String, String> map = new HashMap<String, String>();
			for (String property : array) {
				if (property.indexOf(":") > -1) {
					String[] arr = property.split(":");
					if (null != arr && arr.length > 1) {
						map.put(arr[0].trim(), arr[1].trim());
					} else {
						map.put(arr[0].trim(), "");
					}
				}
			}
			try {
				if (clazz==null){
					try {
						clazz = Class.forName(this.file2dbConstants.getEntityClassName());
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				
				obj = clazz.newInstance();
				if (fields == null) {
					getFields();
				}

				if (fields != null) {
					for (Field field : fields) {
						String n = field.getName();
						if (map.containsKey(n)) {
							field.setAccessible(true);
							Object object = map.get(n);
							String sn = field.getType().getSimpleName();
							if (sn.equalsIgnoreCase("int")) {
								object = Integer.parseInt((String) object);
							} else if (sn.equalsIgnoreCase("long")) {
								object = Long.parseLong((String) object);
							}else if (sn.equalsIgnoreCase("byte")){
								object=Byte.parseByte((String)object);
							}
							field.set(obj, object);
						}
					}
				} else {
					throw new RuntimeException("fields is null error,type is:" + this.file2dbConstants.getEntityClassName());
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return obj;
	}

	private void getFields() {


		Field[] fieldsTemp = clazz.getDeclaredFields();
		List<Field> ll = new ArrayList<Field>();
		for (Field f : fieldsTemp) {
			if (Modifier.isStatic(f.getModifiers()) || f.getName().indexOf("_ISSET_ID") > -1 || f.getName().indexOf("_FIELD_DESC") > -1) {
				continue;
			}
			ll.add(f);
		}
		fields = new Field[ll.size()];
		ll.toArray(fields);
	}

	@Override
	public void deleteFiles() {
		if (this.readedFiles != null) {
			for (File f : this.readedFiles) {
//			    System.out.println("delete file:"+f.getName());
				f.delete();
			}
		}
	}
}
