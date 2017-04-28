package com.vogella.android.dagger2simple.ui.second;

import javax.inject.Inject;

public class SecondPresenter {
    private SecondView mSecondView;

    @Inject
    public SecondPresenter(SecondView secondView) {
        mSecondView = secondView;
    }

    void check() {
        mSecondView.onCheck(true);
    }
}
