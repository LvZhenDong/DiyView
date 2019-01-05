package com.kklv.diyview.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kklv.diyview.util.DensityUtils;

/**
 * Created by yaodongdong on 2019/1/4
 */
public class RingPgb extends View {
    public RingPgb(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float radius=DensityUtils.dp2px(getContext(),50);
        float x = (getWidth() - getHeight() / 2) / 2;
        float y = getHeight() / 4;

        RectF oval = new RectF( x, y,
                getWidth() - x, getHeight() - y);

        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawArc(oval,180,180,true,paint);
    }
}
