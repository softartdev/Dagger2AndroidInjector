package com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.softartdev.android.dagger2simple.R;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class DashboardFragment extends Fragment implements DashboardView, View.OnClickListener {
    TextView dashboardTextView;

    @Inject DashboardPresenter mPresenter;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Button checkButton = (Button) view.findViewById(R.id.dashboard_button);
        checkButton.setOnClickListener(this);
        dashboardTextView = (TextView) view.findViewById(R.id.dashboard_text_view);
        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onCheck(String checked) {
        dashboardTextView.setText(checked);
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
