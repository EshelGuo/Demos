package com.demo.demos;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/9 10:36
 * <br>desc:
 */
interface Api {

	@POST("/user")
	void test(@Field ()@Body RequestBody body);
}
