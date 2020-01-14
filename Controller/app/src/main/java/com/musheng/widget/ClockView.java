package com.musheng.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public class ClockView extends View {

    private Paint mPaint;
    private int mSecond;
    private int mMinute;
    private int mHour;
    private Calendar mCalendar;
    private int DEFAULT = 400;


    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mCalendar = Calendar.getInstance();
            mHour = mCalendar.get(Calendar.HOUR);//从日历中获取小时
            mMinute = mCalendar.get(Calendar.MINUTE);
            mSecond = mCalendar.get(Calendar.SECOND);
            invalidate();//获取时间后，重新绘制
            mHandler.sendEmptyMessageDelayed(1234, 1000);
        }
    };

    private void init() {
        mPaint = new Paint();//初始化画笔
        mPaint.setAntiAlias(true);//设置抗锯齿
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);

    }

    public ClockView(Context context) {
        super(context);
        init();
    }


    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        switch (widthMode) {
            case MeasureSpec.AT_MOST://如果是适应父布局，泽将宽度设置为默认的
                widthSize = DEFAULT;
                break;
            case MeasureSpec.EXACTLY://如果是准确的
                heightSize = widthSize;
                break;
        }
        switch (heightMode) {
            case MeasureSpec.AT_MOST:
                heightSize = DEFAULT;
                break;
            case MeasureSpec.EXACTLY:
                heightSize = widthSize;
                break;

        }
        setMeasuredDimension(widthSize,heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);//设置画笔形状
        canvas.drawCircle(getWidth()/2,getWidth()/2,8,mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        canvas.save();
        canvas.rotate((float) (360/12 * mHour + (mMinute * 0.5)),getWidth() /2 ,getWidth() / 2);
        canvas.drawLine(getWidth()/2,getWidth()/2,getWidth()/2,getWidth()/2-getWidth()/5,mPaint);
        canvas.restore();
        //设置时针
        mPaint.setStrokeWidth(8);
        canvas.save();
        canvas.rotate(360/60*mMinute,getWidth()/2,getWidth()/2);
        canvas.drawLine(getWidth()/2,getWidth()/2,getWidth()/2,getWidth()/2-getWidth()/4,mPaint);
        canvas.restore();

        //设置秒针
        mPaint.setStrokeWidth(6);
        canvas.save();
        canvas.rotate(360/60*mSecond,getWidth()/2,getWidth()/2);
        canvas.drawLine(getWidth()/2,getWidth()/2,getWidth()/2,getWidth()/2-getWidth()/3,mPaint);
        canvas.restore();

    }
}
