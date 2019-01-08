package com.kklv.diyview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.kklv.diyview.activity.ProgressActivity;
import com.kklv.diyview.activity.PswdEtActivity;
import com.kklv.diyview.activity.RingPgbActivity;
import com.kklv.diyview.activity.WaveActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvPgb, tvPswdEt, tvWave,tvRingPgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPgb = findViewById(R.id.tv_pgb);
        tvPswdEt = findViewById(R.id.tv_pswd_et);
        tvWave = findViewById(R.id.tv_wave);
        tvRingPgb=findViewById(R.id.tv_ring_pgb);

        tvPgb.setOnClickListener(this);
        tvPswdEt.setOnClickListener(this);
        tvWave.setOnClickListener(this);
        tvRingPgb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_pgb:
                startActivity(ProgressActivity.class);
                break;
            case R.id.tv_pswd_et:
                startActivity(PswdEtActivity.class);
                break;
            case R.id.tv_wave:
                startActivity(WaveActivity.class);
                break;
            case R.id.tv_ring_pgb:
                startActivity(RingPgbActivity.class);
                break;
        }
    }

    private void startActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
