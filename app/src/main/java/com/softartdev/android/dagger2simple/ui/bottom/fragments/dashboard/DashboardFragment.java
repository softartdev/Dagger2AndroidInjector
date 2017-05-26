package com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.softartdev.android.dagger2simple.R;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class DashboardFragment extends Fragment implements DashboardView, View.OnClickListener {
    TextView dashboardTextView;
    RecyclerView dashboardRecyclerView;

    @Inject DashboardPresenter mPresenter;
    @Inject DashboardAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        dashboardTextView = (TextView) view.findViewById(R.id.dashboard_text_view);

        dashboardRecyclerView = (RecyclerView) view.findViewById(R.id.dashboard_recycler_view);
        dashboardRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        dashboardRecyclerView.setAdapter(mAdapter);

        Button checkButton = (Button) view.findViewById(R.id.dashboard_button);
        checkButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onCheck(String checked, List<String> dataSet) {
        dashboardTextView.setText(checked);

        mAdapter.setData(dataSet);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemCheck(String itemCheck) {
        dashboardTextView.setText(itemCheck);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dashboard_button:
                mPresenter.check();
                break;
        }
    }
}
