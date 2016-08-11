package com.wl.libs.widget.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * 用途描述：
 *
 * @auther wanglei
 * @Time 2016-07-07 10:57
 */
public class CircleProgressBar extends View {


    public CircleProgressBar(Context context) {
        this(context, null);
    }

    public CircleProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }
    
    /**
     * 圆形进度画笔
     */
    private Paint mCirclePaint;

    /**
     * 圆形进度颜色
     */
    private int mCircleColor;

    private int mProgressStarAngle;

    private int mAngleStep;

    private StaticLayout layout;

    

    private void init() {
        mAngleStep = 5;
        mProgressStarAngle = 0;
        mCircleColor = Color.GRAY;

        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(mCircleColor);
        mCirclePaint.setStrokeWidth(5);
        mCirclePaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = getWidth() > getHeight() ? getHeight()/2 - 10 : getWidth()/2 -10;

    }

    Runnable anim = new Runnable() {
        @Override
        public void run() {
            postInvalidate();
        }
    };
}
