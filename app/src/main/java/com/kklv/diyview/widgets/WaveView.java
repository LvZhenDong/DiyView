package com.kklv.diyview.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.kklv.diyview.util.DensityUtils;

/**
 * Created by yaodongdong on 2019/1/5
 */
public class WaveView extends View {
    private Path mAbovePath;
    private Paint mAbovePaint;
    private float k;

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mAbovePath = new Path();
        mAbovePaint = new Paint();
        mAbovePaint.setAntiAlias(true);
        mAbovePaint.setStyle(Paint.Style.FILL);
        mAbovePaint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int offset = DensityUtils.dp2px(getContext(), 50);

        mAbovePath.reset();

        k -= 0.1f;
        float y;
        double w = 8 * Math.PI / getWidth();

        mAbovePath.moveTo(getLeft(), getBottom());

        int centerX = (getWidth() / 20) * 10;

        for (float x = 0; x <= getWidth(); x += 20) {
            y = (float) (30 * Math.cos(w * x + k) + offset);
            mAbovePath.lineTo(x, y);

            Log.i("kklv", "centerX:" + centerX + "    x:" + x);
            if (x == centerX && listener != null)
                listener.onWaveAnim(y);
        }
        mAbovePath.lineTo(getRight(), getBottom());

        canvas.drawPath(mAbovePath, mAbovePaint);

        postInvalidateDelayed(20);
    }

    OnWaveListener listener;

    public void setOnWaveListener(OnWaveListener listener) {
        this.listener = listener;
    }

    public interface OnWaveListener {
        void onWaveAnim(float y);
    }
}
