package com.kklv.diyview.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.kklv.diyview.util.DensityUtils;

import java.text.DecimalFormat;

/**
 * Created by yaodongdong on 2019/1/3
 */
public class AnimProgressBar extends View {
    public AnimProgressBar(Context context) {
        super(context);
        startAnim();
    }

    public AnimProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        startAnim();
    }

    public AnimProgressBar(Context context, @Nullable AttributeSet attrs, int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);
        startAnim();
    }

    public AnimProgressBar(Context context, @Nullable AttributeSet attrs, int
            defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        startAnim();
    }

    float mProgress;

    float pgbHeight, tipHeight, margin, tipWidth, tipRound, triWidth, triHeight;
    Paint paint;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        pgbHeight = DensityUtils.dp2px(getContext(), 5);
        margin = DensityUtils.dp2px(getContext(), 8);
        tipHeight = DensityUtils.dp2px(getContext(), 20);
        tipWidth = DensityUtils.dp2px(getContext(), 30);
        tipRound = DensityUtils.dp2px(getContext(), 2);
        triWidth = DensityUtils.dp2px(getContext(), 10);
        triHeight = triWidth / 2;

        paint = new Paint();
        paint.setColor(Color.GRAY);

        RectF re1 = new RectF(tipWidth / 2, tipHeight + margin, getWidth() - tipWidth / 2,
                tipHeight + margin + pgbHeight);
        canvas.drawRoundRect(re1, pgbHeight, pgbHeight, paint);

        paint.setColor(Color.BLUE);
        RectF reFore = new RectF(tipWidth / 2, tipHeight + margin, tipWidth / 2 + mProgress,
                tipHeight + margin + pgbHeight);
        canvas.drawRoundRect(reFore, pgbHeight, pgbHeight, paint);

        drawRoundRect(canvas);
        drawTriangle(canvas);
        drawText(canvas);
    }

    String currentPgb = "0%";

    private void startAnim() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 100);
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mProgress = (value / 100) * (getWidth() - tipWidth);

                DecimalFormat df = new DecimalFormat("#");
                currentPgb = df.format(value);

                invalidate();
            }
        });

        animator.start();
    }

    private void drawRoundRect(Canvas canvas) {
        RectF reTip = new RectF(0 + mProgress, 0, tipWidth + mProgress, tipHeight);
        canvas.drawRoundRect(reTip, tipRound, tipRound, paint);
    }

    private void drawTriangle(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(tipWidth / 2 - triWidth / 2 + mProgress, tipHeight);
        path.lineTo(tipWidth / 2 + mProgress, tipHeight + triHeight);
        path.lineTo(tipWidth / 2 + triWidth / 2 + mProgress, tipHeight);
        path.close();
        canvas.drawPath(path, paint);
    }

    private void drawText(Canvas canvas) {
        paint.setTextSize(DensityUtils.sp2px(getContext(), 10));
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        float baseline = (tipHeight - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        canvas.drawText(currentPgb + "%", tipWidth / 2 + mProgress, baseline, paint);
    }
}
