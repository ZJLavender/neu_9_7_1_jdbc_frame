package com.neu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//�û���ȡdb.properties�ļ��е�����
//����ģʽ������ģʽ
public class ReadProperties extends Properties {
	private static ReadProperties read;
//	�����ļ�
	private ReadProperties(){
//		���ļ�ת��Ϊ������
		InputStream is=ReadProperties
				.class.getResourceAsStream("/db.properties");
//		���ص��ڴ�
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
