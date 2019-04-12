package com.vuphu.checkedtodo.infrastructures;

import android.app.Application;


import com.vuphu.checkedtodo.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by MyPC on 12/13/2016.
 */
@Module
public class ApplicationModule {

    private Application application;



    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationScope
    Application provideApplication() {
        return application;
    }





}
