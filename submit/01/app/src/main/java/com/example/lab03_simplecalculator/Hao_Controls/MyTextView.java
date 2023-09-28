package com.example.lab03_simplecalculator.Hao_Controls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


//设置了一个小组件：添加了边框的标签
public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {
    private Paint paint=new Paint();
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
                this.getWidth()-0,
                0,
                paint);
        canvas.drawLine(0,
                this.getHeight()-2,
                this.getWidth()-0,
                this.getHeight()-2,
                paint);
        canvas.drawLine(0,
                0,
                0,
                this.getHeight()-0,
                paint);
        canvas.drawLine(this.getWidth()-3,
                0,
                this.getWidth()-3,
                this.getHeight()-0,
                paint);
    }
}
