package com.vogella.android.dagger2simple.ui.second;

public class SecondPresenter {
    private SecondView mSecondView;

    public SecondPresenter(SecondView secondView) {
        mSecondView = secondView;
    }

    void check() {
        mSecondView.onCheck(true);
    }
}
