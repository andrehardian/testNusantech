package com.logan.testnusantech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecycler extends RecyclerView.Adapter<ViewHolderRecycler> {
    @NonNull
    @Override
    public ViewHolderRecycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderRecycler(createView(parent, R.layout.adapter_input));
    }

    protected View createView(ViewGroup parent, int layout) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layout, parent, false);
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRecycler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
