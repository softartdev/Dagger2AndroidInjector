package com.softartdev.android.dagger2simple.di.components;

import com.softartdev.android.dagger2simple.ui.third.ThirdActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface ThirdActivitySubcomponent extends AndroidInjector<ThirdActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ThirdActivity> {}
}
