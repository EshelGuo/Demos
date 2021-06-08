package com.demo.demos;

public class MyClass {

	private static long mStartTime;

	public static void main(String args[]) {
		final Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				long endTime = System.currentTimeMillis();
				System.out.println(endTime - mStartTime);
			}
		});
		mStartTime = System.currentTimeMillis();
		thread.start();
	}
}