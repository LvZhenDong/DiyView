package com.kklv.diyview.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.kklv.diyview.util.DensityUtils;

/**
 * Created by yaodongdong on 2019/1/4
 */
public class RingPgb extends View {
    public RingPgb(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

private int currentProgress;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float radius = DensityUtils.dp2px(getContext(), 50);
        float width = DensityUtils.dp2px(getContext(), 5);

        RectF oval = new RectF(0, 0,
                getWidth(), radius * 2);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(width);
        paint.setStrokeCap(Paint.Cap.ROUND);

        int startColor=Color.parseColor("#ff0000");
        int endColor=Color.parseColor("#00ff00");
        int progress=80;
        float unitAngle= (float) (240/100.0);
        for (int i = 0, end = (int) (currentProgress*unitAngle); i < end; i++) {
            //这里一定要把end转为float
            paint.setColor(getGradient(i/(float)end,startColor,endColor));
            canvas.drawArc(oval,150+i,1,false,paint);
        }
        if(currentProgress<progress){
            currentProgress++;
            postInvalidateDelayed(100);
        }
    }

    private int getGradient(float fraction, int startColor, int endColor) {
        if (fraction > 1) fraction = 1;
        int alphaStart = Color.alpha(startColor);
        int redStart = Color.red(startColor);
        int greenStart = Color.green(startColor);
        int blueStart = Color.blue(startColor);

        int alphaEnd = Color.alpha(endColor);
        int redEnd = Color.red(endColor);
        int greenEnd = Color.green(endColor);
        int blueEnd = Color.blue(endColor);
        int alphaDiff = alphaEnd - alphaStart;
        int redDiff = redEnd - redStart;
        int greenDiff = greenEnd - greenStart;
        int blueDiff = blueEnd - blueStart;
        int alphaCurrent = (int) (alphaStart + fraction * alphaDiff);
        int redCurrent = (int) (blueStart + fraction * redDiff);
        int greenCurrent = (int) (greenStart + fraction * greenDiff);
        int blueCurrent = (int) (blueStart + fraction * blueDiff);

        int color=Color.argb(alphaCurrent,redCurrent,greenCurrent,blueCurrent);
        return color;
    }
}
