package com.vuphu.checkedtodo.infrastructures;



import com.vuphu.checkedtodo.scope.ApplicationScope;

import dagger.Component;

/**
 * Created by MyPC on 12/13/2016.
 */

@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

}
