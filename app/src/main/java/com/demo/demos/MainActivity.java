package com.demo.demos;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import android.os.Bundle;
import android.os.Looper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
}