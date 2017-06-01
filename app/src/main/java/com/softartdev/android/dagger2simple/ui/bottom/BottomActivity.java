package com.softartdev.android.dagger2simple.ui.bottom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.softartdev.android.dagger2simple.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasDispatchingSupportFragmentInjector;

public class BottomActivity extends AppCompatActivity implements HasDispatchingSupportFragmentInjector, BottomView, BottomNavigationView.OnNavigationItemSelectedListener {
    @Inject DispatchingAndroidInjector<Fragment> fragmentInjector;
    @Inject BottomPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void onFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mPresenter.home();
                return true;
            case R.id.navigation_dashboard:
                mPresenter.dashboard();
                return true;
            case R.id.navigation_notifications:
                mPresenter.notifications();
                return true;
            case R.id.navigation_cat:
                return true;
            default:
                return false;
        }
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
