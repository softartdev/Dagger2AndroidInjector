package com.softartdev.android.dagger2simple.di.modules;

import android.support.v4.app.Fragment;

import com.softartdev.android.dagger2simple.di.components.DashboardFragmentSubcomponent;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard.DashboardFragment;
import com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard.DashboardView;

import java.util.Map;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.Multibinds;

@Module(subcomponents = DashboardFragmentSubcomponent.class)
public abstract class FragmentModule {

    @Multibinds
    abstract Map<Class<? extends android.app.Fragment>, AndroidInjector.Factory<? extends android.app.Fragment>> bindNativeFragments();

    @Binds
    @IntoMap
    @FragmentKey(DashboardFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindDashboardFragmentInjectorFactory(DashboardFragmentSubcomponent.Builder builder);

    @Binds
    abstract DashboardView provideDashboardView(DashboardFragment dashboardFragment);
}
