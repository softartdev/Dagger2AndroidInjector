package com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard;

class DashboardPresenter {
    private DashboardView mView;

    DashboardPresenter(DashboardView view) {
        mView = view;
    }

    void check() {
        mView.onCheck();
    }
}
