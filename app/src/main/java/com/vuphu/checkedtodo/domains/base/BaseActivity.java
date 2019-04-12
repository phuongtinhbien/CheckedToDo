package com.vuphu.checkedtodo.domains.base;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.vuphu.checkedtodo.R;

import org.androidannotations.annotations.EActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

@EActivity
public abstract class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V, P> {

    private Dialog progressDialogLoading;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

   /* public void showProgressLoading() {

        if (progressDialogLoading != null)
            progressDialogLoading.dismiss();
        View view = getLayoutInflater().inflate(R.layout.layout_progress_loading, null);
        progressDialogLoading = new Dialog(this);
        progressDialogLoading.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialogLoading.setContentView(view);
        progressDialogLoading.setCancelable(false);
        progressDialogLoading.setCanceledOnTouchOutside(false);

        Window window = progressDialogLoading.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.bg_layout_loading);
        }

        progressDialogLoading.show();
    }

    public void hideProgressLoading() {
        if (progressDialogLoading != null && progressDialogLoading.isShowing())
            progressDialogLoading.dismiss();
    }*/

}
