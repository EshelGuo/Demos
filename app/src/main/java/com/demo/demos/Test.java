package com.demo.demos;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/4 16:05
 * <br>desc:
 */
public class Test {

	public static void main(String args[]) {
		System.out.println(isPowerOfTwo(2));
	}

	public static boolean isPowerOfTwo(int n) {
		return (n & (n - 1)) == 0;
	}

	public static boolean isPowerOfFour(int n) {
		boolean two = isPowerOfTwo(n);
		if(!two) return false;
		return (n | 0x55555555) == 0x55555555;
	}

	public static boolean isPowerOf16(int n) {
		boolean two = isPowerOfTwo(n);
		if(!two) return false;
		return (n | 0b10001000100010001000100010000) == 0b10001000100010001000100010000;
	}
}