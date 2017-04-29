package com.vogella.android.dagger2simple.di.components;

import com.vogella.android.dagger2simple.MyApplication;
import com.vogella.android.dagger2simple.di.modules.ActivityModule;
import com.vogella.android.dagger2simple.di.modules.AppModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AppModule.class, ActivityModule.class, AndroidSupportInjectionModule.class})
public interface IApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MyApplication application);
        IApplicationComponent build();
    }

    void inject(MyApplication application);
}
