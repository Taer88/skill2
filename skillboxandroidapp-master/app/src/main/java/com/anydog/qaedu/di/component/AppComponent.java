package com.anydog.qaedu.di.component;

import com.anydog.qaedu.QaEduApplication;
import com.anydog.qaedu.di.builder.ActivityBuilder;
import com.anydog.qaedu.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(QaEduApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(android.app.Application application);

        AppComponent build();
    }
}
