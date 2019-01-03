package com.kklv.diyview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kklv.diyview.activity.ProgressActivity;
import com.kklv.diyview.activity.PswdEtActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvPgb,tvPswdEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPgb=findViewById(R.id.tv_pgb);
        tvPswdEt=findViewById(R.id.tv_pswd_et);

        tvPgb.setOnClickListener(this);
        tvPswdEt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_pgb:
                startActivity(ProgressActivity.class);
                break;
            case R.id.tv_pswd_et:
                startActivity(PswdEtActivity.class);
                break;
        }
    }

    private void startActivity(Class cls){
        Intent intent=new Intent(this,cls);
        startActivity(intent);
    }
}
