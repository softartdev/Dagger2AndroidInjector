package com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard;

import android.content.Context;

import com.softartdev.android.dagger2simple.R;
import com.softartdev.android.dagger2simple.data.DataManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

class DashboardPresenter {
    private DashboardView mView;

    @Inject
    Context context;

    @Inject
    DataManager dataManager;

    @Inject
    public DashboardPresenter(DashboardView view) {
        mView = view;
    }

    void check() {
        String checked = context.getString(R.string.check_context);

        List<String> dataSet = dataManager.getDataSet();

        mView.onCheck(checked, dataSet);
    }
}
