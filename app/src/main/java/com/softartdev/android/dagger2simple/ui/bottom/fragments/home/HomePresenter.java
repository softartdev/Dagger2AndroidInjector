package com.softartdev.android.dagger2simple.ui.bottom.fragments.home;

import android.content.Context;

import com.softartdev.android.dagger2simple.R;

import javax.inject.Inject;

class HomePresenter {
    private HomeView mView;

    @Inject
    Context context;

    @Inject
    public HomePresenter(HomeView view) {
        mView = view;
    }

    void check() {
        String checked = context.getString(R.string.check_context);
        mView.onCheck(checked);
    }
}
