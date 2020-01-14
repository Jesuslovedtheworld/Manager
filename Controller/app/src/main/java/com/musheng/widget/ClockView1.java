package com.musheng.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class ClockView1 extends View {

    private int mHour;
    private int mMinute;
    private int mSecond;
    private int DEFAULT = 400;

    private Paint mPaint;

    private void init() {
        mPaint = new Paint();//创建画笔
        mPaint.setAntiAlias(true);//设置抗锯齿
        mPaint.setColor(Color.BLACK);//设置颜色
        mPaint.setStyle(Paint.Style.STROKE);//设置画笔形状
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        private Calendar mCalendar;

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mCalendar = Calendar.getInstance();
            mHandler.sendEmptyMessageDelayed(1234, 1000);//延时发送消息？
            mHour = mCalendar.get(Calendar.HOUR);
            mMinute = mCalendar.get(Calendar.MINUTE);
            mSecond = mCalendar.get(Calendar.SECOND);
            invalidate();
            mHandler.sendEmptyMessageDelayed(1234,1000);

        }
    };

    public ClockView1(Context context) {
        super(context);
        init();

    }


    public ClockView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {//测量
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                widthSize = DEFAULT;
                break;
            case MeasureSpec.EXACTLY:
                heightSize = widthSize;
                break;
        }
        switch (heightMode) {
            case MeasureSpec.AT_MOST:
                heightSize = 400;
                break;
            case MeasureSpec.EXACTLY:
                widthSize = heightSize;
                break;
        }
        setMeasuredDimension(widthSize, heightSize);

    }

    @Override
    protected void onDraw(Canvas canvas) {//画图工具
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth() / 2, getWidth() / 2, 8, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        canvas.save();
        canvas.rotate((float) (360 / 12 * mHour + (mMinute * 5)), getWidth() / 2, getWidth() / 2);
        canvas.drawLine(getWidth() / 2, getWidth() / 2, getWidth() / 2, getWidth() / 2 - getWidth() / 5, mPaint);

        mPaint.setStrokeWidth(8);
        canvas.save();
        canvas.rotate(360 / 60 * mMinute, getWidth() / 2, getWidth() / 2);
        canvas.drawLine(getWidth() / 2, getWidth() / 2, getWidth() / 2, getWidth() / 2 - getWidth() / 4, mPaint);
        canvas.restore();

        mPaint.setStrokeWidth(6);
        canvas.save();
        canvas.rotate(360 / 60 * mSecond, getWidth() / 2, getWidth() / 2);
        canvas.drawLine(getWidth() / 2, getWidth() / 2, getWidth() / 2, getWidth() / 2 - getWidth() / 3, mPaint);
        canvas.restore();
    }
}
