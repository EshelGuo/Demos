package com.demo.demos.retrofit2;

import com.demo.demos.retrofit2.internal.ConverterFactories;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/9 10:42
 * <br>desc:
 */
public class Net {

	public static void initialize(){
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("www.baidu.com")
				.addConverterFactory(new ConverterFactories())
				.build();
	}
}