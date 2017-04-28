package com.vogella.android.dagger2simple.di.components;

import com.vogella.android.dagger2simple.ui.second.SecondActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface SecondActivitySubcomponent extends AndroidInjector<SecondActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SecondActivity> {}
}
