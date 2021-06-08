package com.demo.demos;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/4 18:44
 * <br>desc:
 */
public class ThreadDemo {

	public static void main(String args[]){
		DemoThread thread = new DemoThread();
		thread.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

	public static class DemoThread extends Thread{

		@Override
		public void run() {
			for (int i = 0; i < 99; i++) {
				if(Thread.interrupted()){
					return;
				}

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println(i);
			}
		}
	}
}