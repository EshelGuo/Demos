package com.demo.demos;

import java.util.concurrent.locks.Condition;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/4 19:27
 * <br>desc:
 */
public class WaitDemo {

	static final Object lock = new Object();
	Condition mCondition;
	static String value;


	public static void main(String args[]){
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				print();
			}

			void print(){
				synchronized (lock) {
					while (value == null) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					System.out.println(value);
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				init();
			}

			void init(){
				synchronized (lock) {
					value = "hahaha";
					lock.notifyAll();
				}
			}
		});
		t1.start();
		t2.start();
	}


}