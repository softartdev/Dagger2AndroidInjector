package com.softartdev.android.dagger2simple.di.components;

import com.softartdev.android.dagger2simple.di.modules.FragmentModule;
import com.softartdev.android.dagger2simple.ui.bottom.BottomActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {FragmentModule.class})
public interface BottomActivitySubcomponent extends AndroidInjector<BottomActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BottomActivity> {}
}
