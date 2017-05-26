package com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard;

import android.content.Context;

import com.softartdev.android.dagger2simple.R;

import javax.inject.Inject;

class DashboardPresenter {
    private DashboardView mView;

    @Inject
    Context context;

    @Inject
    public DashboardPresenter(DashboardView view) {
        mView = view;
    }

    void check() {
        String checked = context.getString(R.string.check_context);
        mView.onCheck(checked);
    }
}
