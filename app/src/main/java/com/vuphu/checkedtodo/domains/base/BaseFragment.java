package com.vuphu.checkedtodo.domains.base;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import org.androidannotations.annotations.EFragment;

@EFragment
public abstract class BaseFragment <V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment {

}
