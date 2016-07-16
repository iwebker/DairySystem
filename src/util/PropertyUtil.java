package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	/**
	 * 根据键获取值
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		Properties pro=new Properties();
		InputStream in=new PropertyUtil().getClass().getResourceAsStream("/config.properties");
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (String)pro.get(key);
	}
}
