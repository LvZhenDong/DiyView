package com.kklv.diyview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.kklv.diyview.R;
import com.kklv.diyview.util.DensityUtils;
import com.kklv.diyview.widgets.WaveView;

public class WaveActivity extends AppCompatActivity {
    WaveView waveView;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);

        waveView=findViewById(R.id.wave);
        view=findViewById(R.id.view);

        final float marginTop=DensityUtils.dp2px(this,100);

        waveView.setOnWaveListener(new WaveView.OnWaveListener() {
            @Override
            public void onWaveAnim(float y) {
                RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) view.getLayoutParams();
                params.topMargin= (int) (y);
                view.setLayoutParams(params);
            }
        });
    }
}
