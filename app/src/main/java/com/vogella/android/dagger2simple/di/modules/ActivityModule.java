package com.vogella.android.dagger2simple.di.modules;

import android.app.Activity;

import com.vogella.android.dagger2simple.di.components.SecondActivitySubcomponent;
import com.vogella.android.dagger2simple.ui.main.MainActivity;
import com.vogella.android.dagger2simple.di.components.IMainActivitySubcomponent;
import com.vogella.android.dagger2simple.ui.second.SecondActivity;
import com.vogella.android.dagger2simple.ui.second.SecondView;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {IMainActivitySubcomponent.class, SecondActivitySubcomponent.class})
public abstract class ActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindYourActivityInjectorFactory(IMainActivitySubcomponent.Builder builder);


    @Binds abstract SecondView provideSecondView(SecondActivity secondActivity);

    @Binds
    @IntoMap
    @ActivityKey(SecondActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindSecondActivityInjectorFactory(SecondActivitySubcomponent.Builder builder);
}
