package com.demo.demos.base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/10 15:32
 * <br>desc:
 */
public class Test {

	public static void main(String args[]){

		File file = new File("C:\\Users\\Administrator\\Desktop\\image.png");
		try {
			FileInputStream is = new FileInputStream(file);
			byte[] buf = new byte[(int) file.length()];
			int read = is.read(buf);
//			String result = Base64.encode("String result = Base64.encode(buf);".getBytes(StandardCharsets.UTF_8));
			String result = Base64.encode(buf);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}