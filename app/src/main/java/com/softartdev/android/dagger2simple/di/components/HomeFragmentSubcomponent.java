package com.softartdev.android.dagger2simple.di.components;

import com.softartdev.android.dagger2simple.ui.bottom.fragments.home.HomeFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface HomeFragmentSubcomponent extends AndroidInjector<HomeFragment> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<HomeFragment> {}
}
