package com.demo.demos.camera;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.demo.demos.R;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/3 15:59
 * <br>desc:
 */
public class CameraView extends View {

	private Camera mCamera;
	private Drawable mDrawable;
	private Sensor mSensor;
	private Paint mPaint;
	private int mX;
	private int mY;

	public CameraView(Context context) {
		this(context, null);
	}

	public CameraView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CameraView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mPaint = new Paint();
		mPaint.setColor(Color.BLACK);
		mPaint.setTextSize(30);
		mCamera = new Camera();
		mCamera.setLocation(0, 0, -64);
		mDrawable = context.getResources().getDrawable(R.mipmap.ic_launcher);
		SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
		SensorEventListener trigger = new SensorEventListener() {
			@Override
			public void onSensorChanged(SensorEvent event) {
				// Do work
				float[] values = event.values;
				mY = (int) (-values[0] * 9);
				mX = (int) (-values[1] * 9);
				int z = (int) (values[2] * 9);
				Log.i("Trigger", "x: " + mX + ", y: " + mY + ", z: " + z);
				invalidate();
			}

			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {

			}
		};
		sensorManager.registerListener(trigger, mSensor, 1000);
	}

	private void runAnimation() {
		final ValueAnimator va = ValueAnimator.ofFloat(0, 80);
		va.setInterpolator(new LinearInterpolator());
		va.setDuration(10000);
		va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			float lastValue = 0;

			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				float value = (float) animation.getAnimatedValue();
				mCamera.rotateY(value - lastValue);
				lastValue = value;
				invalidate();
			}
		});
		va.start();
	}


	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
//		mCamera.rotateY(45);
//		runAnimation();
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		mDrawable.setBounds(0, 0, right - left - 20, bottom - top - 20);
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.translate(10, 10);
		int centerY = getHeight() >> 1;
		int centerX = getWidth() >> 1;

		canvas.translate(centerX, centerY);
		mCamera.save();
		mCamera.rotateX(mX);
		mCamera.rotateY(mY);
		mCamera.applyToCanvas(canvas);
		mCamera.restore();
		canvas.translate(-centerX, -centerY);
		mDrawable.draw(canvas);
	}
}