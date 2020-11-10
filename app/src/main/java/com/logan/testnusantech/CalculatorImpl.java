package com.logan.testnusantech;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

@EBean
public class CalculatorImpl implements CalculatorPresenter {
    private CalculatorView calculatorView;
    private AdapterRecycler adapterRecycler = new AdapterRecycler();
    private ArrayList<Float> listCalculate = new ArrayList<>();
    private float result;

    @Override
    public void init(CalculatorView view) {
        calculatorView = view;
        calculatorView.inputs().setAdapter(adapterRecycler);
    }

    @Override
    public void plus() {
        if (checkDataLength()) {
            for (int pos = 1; pos < listCalculate.size(); pos++) {
                result += listCalculate.get(pos);
            }
        setResult();
        }
    }

    private void setResult() {
        calculatorView.result().setText(String.valueOf(result));
    }

    @Override
    public void minus() {
        if (checkDataLength()) {
            for (int pos = 1; pos < listCalculate.size(); pos++) {
                result -= listCalculate.get(pos);
            }
        setResult();
        }
    }

    @Override
    public void multiply() {
        if (checkDataLength()) {
            for (int pos = 1; pos < listCalculate.size(); pos++) {
                result *= listCalculate.get(pos);
            }
        setResult();
        }
    }

    @Override
    public void divide() {
        if (checkDataLength()) {
            for (int pos = 1; pos < listCalculate.size(); pos++) {
                result /= listCalculate.get(pos);
            }
        setResult();
        }
    }

    private boolean checkDataLength() {
        calculatorView.result().setText("");
        listData();
        boolean approve = listCalculate.size() > 1;
        result = approve ? listCalculate.get(0) : 0;
        return approve;
    }

    private void listData() {
        listCalculate.clear();
        for (int pos = 0; pos < adapterRecycler.getItemCount(); pos++) {
            ViewHolderRecycler viewHolder = (ViewHolderRecycler) calculatorView.inputs().
                    findViewHolderForAdapterPosition(pos);
            if (viewHolder != null && viewHolder.isCheck()) {
                listCalculate.add(viewHolder.getInput());
            }
        }
    }


}
