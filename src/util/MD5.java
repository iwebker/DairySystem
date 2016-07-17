package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5 {
	public static String encoderPass(String pass) throws UnsupportedEncodingException{
		MessageDigest md5=null;
		BASE64Encoder base64=null;
		try {
			md5=MessageDigest.getInstance("md5");
			base64=new BASE64Encoder();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return base64.encode(md5.digest(pass.getBytes("utf-8")));
	}
}
