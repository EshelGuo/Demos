package com.demo.demos.retrofit2.converter.request.body;

import java.io.IOException;

import androidx.annotation.NonNull;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/9 10:55
 * <br>desc:
 */
public class StringConverter implements Converter<String, RequestBody> {

	@Override
	public RequestBody convert(@NonNull String value) throws IOException {
//		return RequestBody.create();
		return null;
	}
}