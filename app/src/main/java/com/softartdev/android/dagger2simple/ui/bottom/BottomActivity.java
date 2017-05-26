package com.softartdev.android.dagger2simple.ui.bottom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.softartdev.android.dagger2simple.R;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard.DashboardFragment;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.home.HomeFragment;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.notifications.NotificationsFragment;

public class BottomActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    DashboardFragment mDashboardFragment;
    HomeFragment mHomeFragment;
    NotificationsFragment mNotificationsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content, mHomeFragment).commit();
                return true;
            case R.id.navigation_dashboard:
                if (mDashboardFragment == null) {
                    mDashboardFragment = new DashboardFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content, mDashboardFragment).commit();
                return true;
            case R.id.navigation_notifications:
                if (mNotificationsFragment == null) {
                    mNotificationsFragment = new NotificationsFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content, mNotificationsFragment).commit();
                return true;
        }
        return false;
    }
}
