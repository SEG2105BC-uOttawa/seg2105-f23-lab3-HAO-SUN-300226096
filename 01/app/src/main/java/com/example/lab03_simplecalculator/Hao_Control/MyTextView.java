package com.example.lab03_simplecalculator.Hao_Control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import android.graphics.Paint;
import android.util.AttributeSet;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


//设置了一个小组件：添加了边框的标签
public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {
    Paint paint=new Paint();
    public MyTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        //添加边框
        canvas.drawLine(0,
                0,
                this.getWidth(),
                0,
                paint);
        canvas.drawLine(0,
                this.getHeight()-1,
                this.getWidth(),
                this.getHeight()-1,
                paint);
        canvas.drawLine(0,
                0,
                0,
                this.getHeight(),
                paint);
        canvas.drawLine(this.getWidth()-1,
                0,
                this.getWidth()-1,
                this.getHeight(),
                paint);
    }
}
