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

public class ClockView2 extends View {


    private Paint mPaint;

    private int mHour;
    private int mMinute;
    private int mSecond;
    private int DEFAULT = 400;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        private Calendar mCalendar;

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mCalendar = Calendar.getInstance();
            mHour = mCalendar.get(Calendar.HOUR);
            mMinute = mCalendar.get(Calendar.MINUTE);
            mSecond = mCalendar.get(Calendar.SECOND);
            invalidate();
            mHandler.sendEmptyMessageDelayed(1234, 1000);
        }
    };

    private void init() {
        //初始化画笔
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);//设置抗锯齿

    }

    public ClockView2(Context context) {
        super(context);
        init();
    }


    public ClockView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
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
                heightSize = DEFAULT;
                break;
            case MeasureSpec.EXACTLY:
                widthSize = heightSize;
                break;
        }
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth()/2,getWidth()/2,8,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);//定义时针
        canvas.rotate((float)(360/12*mHour) + (mMinute*5),getWidth()/2,getWidth()/2);
        canvas.drawLine(getWidth()/2,getWidth()/2,getWidth()/2,getWidth()/2-getWidth()/5,mPaint);

        mPaint.setStrokeWidth(8);
        canvas.save();
        canvas.rotate(360/60*mMinute,getWidth()/2,getWidth()/2);
        canvas.drawLine(getWidth()/2,getWidth()/2,getWidth()/2,getWidth()/2-getWidth()/4,mPaint);


        mPaint.setStrokeWidth(6);
        canvas.save();
        canvas.rotate(360/60*mSecond,getWidth()/2,getWidth()/2);
        canvas.drawLine(getWidth()/2,getWidth()/2,getWidth()/2,getWidth()/2-getWidth()/3,mPaint);

    }
}
