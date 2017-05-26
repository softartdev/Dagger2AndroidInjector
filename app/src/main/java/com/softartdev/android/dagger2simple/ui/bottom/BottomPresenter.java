package com.softartdev.android.dagger2simple.ui.bottom;

import com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard.DashboardFragment;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.home.HomeFragment;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.notifications.NotificationsFragment;

import javax.inject.Inject;

class BottomPresenter {
    private BottomView mView;

    private DashboardFragment mDashboardFragment = new DashboardFragment();
    private HomeFragment mHomeFragment = new HomeFragment();
    private NotificationsFragment mNotificationsFragment = new NotificationsFragment();

    @Inject
    BottomPresenter(BottomView view) {
        mView = view;
    }

    void home() {
        mView.onFragment(mHomeFragment);
    }

    void dashboard() {
        mView.onFragment(mDashboardFragment);
    }

    void notifications() {
        mView.onFragment(mNotificationsFragment);
    }
}
