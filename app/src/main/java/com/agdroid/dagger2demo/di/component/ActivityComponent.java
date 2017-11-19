package com.agdroid.dagger2demo.di.component;

import com.agdroid.dagger2demo.MainActivity;
import com.agdroid.dagger2demo.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by andre on 19.11.2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
