package com.vogella.android.dagger2simple.ui.third;

import javax.inject.Inject;

public class ThirdPresenter {
    private ThirdView mThirdView;

    @Inject
    public ThirdPresenter(ThirdView thirdView) {
        mThirdView = thirdView;
    }

    void check() {
        mThirdView.onCheck(true);
    }
}
