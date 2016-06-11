package com.nhancv.mortarflow.flow;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nhancv.mortarflow.R;

import flow.Flow;

public class FlowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
    }

    //Install flow https://github.com/square/flow
    @Override
    protected void attachBaseContext(Context baseContext) {
        baseContext = Flow.configure(baseContext, this).install();
        super.attachBaseContext(baseContext);
    }

    @Override
    public void onBackPressed() {
        if (!Flow.get(this).goBack()) {
            super.onBackPressed();
        }
    }
}
