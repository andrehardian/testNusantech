package com.logan.testnusantech;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderRecycler extends RecyclerView.ViewHolder {
    private EditText input;
    private CheckBox check;

    public ViewHolderRecycler(@NonNull View itemView) {
        super(itemView);
        input = findView(R.id.input);
        check = findView(R.id.check);
    }

    public float getInput() {
        return Float.parseFloat(getValueInput());
    }

    private String getValueInput(){
        return input.getText().toString();
    }

    public boolean isCheck() {
        return !getValueInput().isEmpty() && check.isChecked();
    }

    protected <K extends View> K findView(int id) {
        return (K) itemView.findViewById(id);
    }

}
