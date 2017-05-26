package com.softartdev.android.dagger2simple.ui.bottom.fragments.notifications;

import android.content.Context;

import com.softartdev.android.dagger2simple.R;

import javax.inject.Inject;

class NotificationsPresenter {
    private NotificationsView mView;

    @Inject
    Context context;

    @Inject
    public NotificationsPresenter(NotificationsView view) {
        mView = view;
    }

    void check() {
        String checked = context.getString(R.string.check_context);
        mView.onCheck(checked);
    }
}
