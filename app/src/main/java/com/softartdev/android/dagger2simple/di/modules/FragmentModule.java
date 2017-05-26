package com.softartdev.android.dagger2simple.di.modules;

import android.support.v4.app.Fragment;

import com.softartdev.android.dagger2simple.di.components.DashboardFragmentSubcomponent;
import com.softartdev.android.dagger2simple.di.components.HomeFragmentSubcomponent;
import com.softartdev.android.dagger2simple.di.components.NotificationsFragmentSubcomponent;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard.DashboardFragment;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard.DashboardView;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.home.HomeFragment;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.home.HomeView;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.notifications.NotificationsFragment;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.notifications.NotificationsView;

import java.util.Map;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.Multibinds;

@Module(subcomponents = {DashboardFragmentSubcomponent.class, HomeFragmentSubcomponent.class, NotificationsFragmentSubcomponent.class})
public abstract class FragmentModule {

    @Multibinds
    abstract Map<Class<? extends android.app.Fragment>, AndroidInjector.Factory<? extends android.app.Fragment>> bindNativeFragments();

    @Binds
    @IntoMap
    @FragmentKey(DashboardFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindDashboardFragmentInjectorFactory(DashboardFragmentSubcomponent.Builder builder);

    @Binds
    abstract DashboardView provideDashboardView(DashboardFragment dashboardFragment);

    @Binds
    @IntoMap
    @FragmentKey(HomeFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindHomeFragmentInjectorFactory(HomeFragmentSubcomponent.Builder builder);

    @Binds
    abstract HomeView provideHomeView(HomeFragment homeFragment);

    @Binds
    @IntoMap
    @FragmentKey(NotificationsFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindNotificationsFragmentInjectorFactory(NotificationsFragmentSubcomponent.Builder builder);

    @Binds
    abstract NotificationsView provideNotificationsView(NotificationsFragment notificationsFragment);
}
