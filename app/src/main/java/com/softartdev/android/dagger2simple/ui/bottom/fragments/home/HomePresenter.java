package com.softartdev.android.dagger2simple.ui.bottom.fragments.home;

import android.content.Context;

import com.softartdev.android.dagger2simple.R;

import java.util.Random;

import javax.inject.Inject;

class HomePresenter {
    private HomeView mView;
    private Random mRandom = new Random();

    @Inject
    Context context;

    @Inject
    public HomePresenter(HomeView view) {
        mView = view;
    }

    void check() {
        String checked = context.getString(R.string.check_context);
        String firstData = String.valueOf(mRandom.nextInt(1000));
        String secondData = String.valueOf(mRandom.nextInt(1000));
        String thirdData = String.valueOf(mRandom.nextInt(1000));
        mView.onCheck(checked, firstData, secondData, thirdData);
    }
}
