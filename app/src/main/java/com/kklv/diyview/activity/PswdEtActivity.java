package com.kklv.diyview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import com.kklv.diyview.R;

public class PswdEtActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pswd_et);

        editText=findViewById(R.id.et_pswd);



    }
}
