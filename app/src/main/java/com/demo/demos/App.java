package com.demo.demos;

import android.app.Application;

import com.demo.demos.retrofit2.Net;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/9 10:43
 * <br>desc:
 */
public class App extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Net.initialize();
	}
}