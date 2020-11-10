package com.logan.testnusantech;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class CalculatorActivity extends AppCompatActivity implements CalculatorView {
    @Bean
    protected CalculatorImpl impl;

    @ViewById
    protected RecyclerView inputs;
    @ViewById
    protected TextView result;

    @AfterViews
    protected void init() {
        impl.init(this);
    }

    @Override
    public RecyclerView inputs() {
        return inputs;
    }

    @Override
    public TextView result() {
        return result;
    }

    @Click({R.id.plus, R.id.divide, R.id.min, R.id.multiply})
    protected void calculate(View clickView) {
        impl.calculate(clickView.getId());
    }


}