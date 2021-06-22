package com.demo.demos.retrofit2.internal;

import com.demo.demos.retrofit2.converter.request.body.RequestBodyConverterFactory;
import com.demo.demos.retrofit2.converter.factory.ResponseBodyConverterFactory;
import com.demo.demos.retrofit2.converter.factory.StringConverterFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/9 10:44
 * <br>desc:
 */
public class ConverterFactories extends Converter.Factory{

	private RequestBodyConverterFactory mRequestBodyConverterFactory = new RequestBodyConverterFactory();
	private ResponseBodyConverterFactory mResponseBodyConverterFactory = new ResponseBodyConverterFactory();
	private StringConverterFactory mStringConverterFactory = new StringConverterFactory();

	@Override
	public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
		return mRequestBodyConverterFactory.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
	}

	@Override
	public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
		return mResponseBodyConverterFactory.responseBodyConverter(type, annotations, retrofit);
	}

	@Override
	public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
		return mStringConverterFactory.stringConverter(type, annotations, retrofit);
	}
}