package com.softartdev.android.dagger2simple.ui.third;

import android.content.Context;

import com.softartdev.android.dagger2simple.R;

import javax.inject.Inject;

public class ThirdPresenter {
    private ThirdView mThirdView;

    @Inject
    Context context;

    @Inject
    public ThirdPresenter(ThirdView thirdView) {
        mThirdView = thirdView;
    }

    void check() {
        mThirdView.onCheck(true);
    }

    void checkContext() {
        String checked = context.getString(R.string.check_context);
        mThirdView.onCheckContext(checked);
    }
}
