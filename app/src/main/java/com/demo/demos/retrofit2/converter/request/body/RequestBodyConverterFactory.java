package com.demo.demos.retrofit2.converter.request.body;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/9 10:48
 * <br>desc:
 */
public class RequestBodyConverterFactory {

	public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {

		if(!isClass(type)){
			return null;
		}

		Class<?> clazz = (Class<?>) type;
		if(clazz == String.class){
			return new StringConverter();
		}

		return null;
	}

	private boolean isClass(Type type){
		return type instanceof Class;
	}
}