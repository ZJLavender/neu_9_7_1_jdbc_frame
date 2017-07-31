package com.neu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//用户读取db.properties文件中的内容
//单例模式，懒汉模式
public class ReadProperties extends Properties {
	private static ReadProperties read;
//	加载文件
	private ReadProperties(){
//		把文件转换为输入流
		InputStream is=ReadProperties
				.class.getResourceAsStream("/db.properties");
//		加载到内存
		try {
			load(is);
		} catch (IOException e) {
			
		}
	}
	
	public static ReadProperties getInstance(){
		if(read==null){
			read=new ReadProperties();
		}
		return read;
	}
	
}
