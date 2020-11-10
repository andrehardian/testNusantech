package com.logan.testnusantech;

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

    @Click
    protected void plus() {
        impl.plus();
    }

    @Click
    protected void min() {
        impl.minus();
    }

    @Click
    protected void divide() {
        impl.divide();
    }

    @Click
    protected void multiply() {
        impl.multiply();
    }
}