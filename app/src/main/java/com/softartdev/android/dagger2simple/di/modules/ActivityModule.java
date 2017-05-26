package com.softartdev.android.dagger2simple.di.modules;

import android.app.Activity;

import com.softartdev.android.dagger2simple.di.components.BottomActivitySubcomponent;
import com.softartdev.android.dagger2simple.di.components.MainActivitySubcomponent;
import com.softartdev.android.dagger2simple.di.components.SecondActivitySubcomponent;
import com.softartdev.android.dagger2simple.di.components.ThirdActivitySubcomponent;
import com.softartdev.android.dagger2simple.ui.bottom.BottomActivity;
import com.softartdev.android.dagger2simple.ui.bottom.BottomView;
import com.softartdev.android.dagger2simple.ui.main.MainActivity;
import com.softartdev.android.dagger2simple.ui.second.SecondActivity;
import com.softartdev.android.dagger2simple.ui.second.SecondView;
import com.softartdev.android.dagger2simple.ui.third.ThirdActivity;
import com.softartdev.android.dagger2simple.ui.third.ThirdView;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivitySubcomponent.class, SecondActivitySubcomponent.class, ThirdActivitySubcomponent.class, BottomActivitySubcomponent.class})
public abstract class ActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);


    @Binds abstract SecondView provideSecondView(SecondActivity secondActivity);

    @Binds
    @IntoMap
    @ActivityKey(SecondActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindSecondActivityInjectorFactory(SecondActivitySubcomponent.Builder builder);

    @Binds abstract ThirdView provideThirdView(ThirdActivity thirdActivity);

    @Binds
    @IntoMap
    @ActivityKey(ThirdActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindThirdActivityInjectorFactory(ThirdActivitySubcomponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(BottomActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindBottomActivityInjectorFactory(BottomActivitySubcomponent.Builder builder);

    @Binds abstract BottomView provideBottomView(BottomActivity bottomActivity);
}
