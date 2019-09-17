package com.briup.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.briup.pojo.Medicinal;


public class DateUtil {
	
	public static final Properties errors =new Properties();
	static {
		try {
			InputStream is=new FileInputStream("src/errors.config");
			errors.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static Object[][] listToArray(List<Medicinal> meds){
		Object[][] data=new Object[meds.size()][];
		int size=meds.size();
		for(int i=0;i<size;i++) {
			Medicinal m = meds.get(i);
			Object[] info =new Object[] {m.getId(),m.getName(),m.getType(),m.getDescription(),m.getPrice()};
			data[i]=info;
		}
		return data;
	}
}
