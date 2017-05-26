package com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard;

import android.content.Context;

import com.softartdev.android.dagger2simple.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

class DashboardPresenter {
    private DashboardView mView;
    private int checks = 1;

    @Inject
    Context context;

    @Inject
    public DashboardPresenter(DashboardView view) {
        mView = view;
    }

    void check() {
        String checked = context.getString(R.string.check_context);

        List<String> dataSet = new ArrayList<>();
        for (int i = 0; i < checks; i++) {
            dataSet.add(checked + ": " + checks + " - " + i);
        }
        checks++;

        mView.onCheck(checked, dataSet);
    }
}
