package com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softartdev.android.dagger2simple.R;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> implements View.OnClickListener {
    private List<String> dataList;
    private RecyclerView mRecyclerView;
    private DashboardView mView;

    @Inject
    public DashboardAdapter(DashboardView dashboardView) {
        dataList = Collections.emptyList();
        mView = dashboardView;
    }

    public void setData(List<String> dataSet) {
        dataList = dataSet;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_dashboard_text_view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onClick(View v) {
        int p = mRecyclerView.getChildLayoutPosition(v);
        mView.onItemCheck(dataList.get(p));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }
}
