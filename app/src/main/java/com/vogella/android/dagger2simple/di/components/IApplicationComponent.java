package com.vogella.android.dagger2simple.di.components;

import com.vogella.android.dagger2simple.MyApplication;
import com.vogella.android.dagger2simple.di.modules.ActivityModule;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {ActivityModule.class, AndroidSupportInjectionModule.class})
public interface IApplicationComponent {
    void inject(MyApplication application);
}
