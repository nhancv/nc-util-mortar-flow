package com.nhancv.mortarflow.mortar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nhancv.mortarflow.R;

import javax.inject.Inject;

/**
 * Created by nhancao on 6/11/16.
 */
public class MainView extends LinearLayout {
    @Inject
    Main.Presenter presenter;

    private TextView textView;

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        DaggerService.<Main.Component>getDaggerComponent(context).inject(this);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        textView = (TextView) findViewById(R.id.text);
    }

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        presenter.takeView(this);
    }

    @Override protected void onDetachedFromWindow() {
        presenter.dropView(this);
        super.onDetachedFromWindow();
    }

    public void show(CharSequence stuff) {
        textView.setText(stuff);
    }
}