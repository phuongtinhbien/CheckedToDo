package com.vuphu.checkedtodo.domains.login;


import com.vuphu.checkedtodo.domains.main.ScrollingActivity;
import com.vuphu.checkedtodo.infrastructures.ApplicationComponent;
import com.vuphu.checkedtodo.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = ApplicationComponent.class)
public abstract class LoginComponent {

    public abstract LoginPresenter presenter();

    public abstract void inject(LoginActivity mainActivity);
}
