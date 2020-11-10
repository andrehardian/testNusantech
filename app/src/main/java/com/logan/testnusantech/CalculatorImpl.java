package com.logan.testnusantech;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

@EBean
public class CalculatorImpl implements CalculatorPresenter {
    private CalculatorView calculatorView;
    private AdapterRecycler adapterRecycler = new AdapterRecycler();
    private ArrayList<Float> listCalculate = new ArrayList<>();
    private float result;
    private int typePlus = 0;
    private int typeMinus;
    private int typeDivide;
    private int typeMultiply;

    @Override
    public void init(CalculatorView view) {
        calculatorView = view;
        calculatorView.inputs().setAdapter(adapterRecycler);
    }

    @Override
    public void calculate(int id) {
        if (checkDataLength()) {
            for (int pos = 1; pos < listCalculate.size(); pos++) {
                switch (id) {
                    case R.id.plus:
                        result += listCalculate.get(pos);
                        break;
                    case R.id.min:
                        result -= listCalculate.get(pos);
                        break;
                    case R.id.divide:
                        result /= listCalculate.get(pos);
                        break;
                    case R.id.multiply:
                        result *= listCalculate.get(pos);
                        break;
                }
            }
            setResult();
        }
    }


    private void setResult() {
        calculatorView.result().setText(String.valueOf(result));
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
