package com.kklv.diyview.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

import com.kklv.diyview.util.DensityUtils;

/**
 * Created by yaodongdong on 2019/1/3
 */
public class PswdEt extends AppCompatEditText {
    public PswdEt(Context context) {
        super(context);
        init();
    }

    public PswdEt(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PswdEt(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                pswdCount=s.length();
                invalidate();
            }
        });
        setInputType(InputType.TYPE_CLASS_NUMBER);

        //最多6个字符
        int maxLength = 6;
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        setFilters(fArray);
    }
    Paint paint;
    float strokeWidth;
    int radius;
    float divideX;
    int pswdCount;
    @Override
    protected void onDraw(Canvas canvas) {
        setSingleLine(true);
        setBackgroundColor(Color.TRANSPARENT);
        setCursorVisible(false);
        int round=DensityUtils.dp2px(getContext(),4);
         strokeWidth=DensityUtils.dp2px(getContext(),1 );
        radius=DensityUtils.dp2px(getContext(),3);
         paint=new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(strokeWidth);
        //画边框
        RectF rectF=new RectF(0,0,getWidth(),getHeight());
        canvas.drawRoundRect(rectF,round,round,paint);
        //画分割线
         divideX=getWidth()/6;
        for (int i = 0; i < 5; i++) {
            canvas.drawLine((i+1)*divideX,0,(i+1)*divideX,getHeight(),paint);
        }

        drawCircle(canvas,pswdCount);
    }

    private void drawCircle(Canvas canvas,int count){

        paint.reset();
        paint.setColor(Color.BLACK);
        for (int i = 0; i < count; i++) {
            canvas.drawCircle((divideX/2)+(divideX)*i,getHeight()/2,radius,paint);
        }

    }
}
