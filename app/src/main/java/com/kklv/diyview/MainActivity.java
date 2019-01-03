package com.kklv.diyview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kklv.diyview.activity.ProgressActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvPgb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPgb=findViewById(R.id.tv_pgb);

        tvPgb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_pgb:
                startActivity(ProgressActivity.class);
                break;
        }
    }

    private void startActivity(Class cls){
        Intent intent=new Intent(this,cls);
        startActivity(intent);
    }
}
