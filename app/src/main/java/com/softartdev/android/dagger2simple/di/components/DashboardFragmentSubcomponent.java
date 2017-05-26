package com.softartdev.android.dagger2simple.di.components;

import com.softartdev.android.dagger2simple.ui.bottom.fragments.dashboard.DashboardFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface DashboardFragmentSubcomponent extends AndroidInjector<DashboardFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<DashboardFragment> {}
}
