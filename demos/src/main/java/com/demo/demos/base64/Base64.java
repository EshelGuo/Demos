package com.demo.demos.base64;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/10 15:11
 * <br>desc:
 */
public class Base64 {

	private static final char[] KEYS = {
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z', '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9', '+', '/'
	};

	public static String encode(byte[] data){
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < data.length; i+=3) {
			byte first = data[i];
			int index0 = (first & 0xff ) >>> 2;
			builder.append(KEYS[index0]);

			if(i+1 < data.length) {
				byte second = data[i + 1];
				int index1 = ((first & 0b11) << 4) | ((second & 0xFF) >>> 4);
				builder.append(KEYS[index1]);

				if(i+2 < data.length) {
					byte third = data[i + 2];
					int index2 = ((second & 0b1111) << 2) | ((third & 0xFF) >>> 6);
					builder.append(KEYS[index2]);

					int index3 = third & 0b111111;
					builder.append(KEYS[index3]);
				}else {
					byte third = 0b0;
					int index2 = ((second & 0b1111) << 2) | ((third & 0xFF) >>> 6);
					builder.append(KEYS[index2]);
					builder.append('=');
				}
			}else {
				byte second = 0b0;
				int index1 = (first & 0b11) << 4 | ((second & 0xFF) >>> 4);
				builder.append(KEYS[index1]);
				builder.append("==");
			}
		}

		return builder.toString();
	}

	public static byte[] decode(String data){
		return null;
	}
}