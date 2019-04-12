package com.vuphu.checkedtodo.domains.main;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.vuphu.checkedtodo.MainApplication;
import com.vuphu.checkedtodo.domains.adapter.PagerAdapter;
import com.vuphu.checkedtodo.R;
import com.vuphu.checkedtodo.domains.base.BaseActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import android.text.format.DateUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.threeten.bp.DateTimeUtils;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

@EActivity(R.layout.activity_scrolling)
public class ScrollingActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

    @App
    MainApplication application;
    @Inject
    MainPresenter presenter;

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.layout_create_note)
    LinearLayout createNote;

    @ViewById(R.id.fab)
    FloatingActionButton fab;

    @ViewById(R.id.bg)
    View viewBg;

    @ViewById(R.id.view_pager)
    ViewPager pager;

    @ViewById(R.id.content_scrolling_tab_categories)
    TabLayout tabLayout;

    @ViewById(R.id.layout_create_note_ln_time)
    LinearLayout time;

    @ViewById(R.id.layout_create_note_tv_time)
    TextView selectedTime;

    BottomSheetBehavior sheetBehavior;


    @AfterInject
    void inject() {
        DaggerMainComponent.builder()
                .applicationComponent(application.getApplicationComponent())
                .build()
                .inject(this);

    }

    @SuppressLint("ClickableViewAccessibility")
    @AfterViews
    void init() {
        addControl();
        setTime();
        setCreateNote();
    }


    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return presenter;
    }

    private void setTime() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        time.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, year, monthOfYear, dayOfMonth) -> {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        selectedTime.setText(DateUtils.formatDateTime(getApplicationContext(),
                                calendar.getTimeInMillis(), DateUtils.FORMAT_ABBREV_RELATIVE));
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        });
    }

    private void addControl() {
        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new PagerAdapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager));
    }

    private void setCreateNote() {
        sheetBehavior = BottomSheetBehavior.from(createNote);
        setSupportActionBar(toolbar);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:{
                        fab.setImageResource(R.drawable.ic_mode_edit_black_24dp);
                    }
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        fab.setImageResource(R.drawable.ic_close_black_24dp);
                        viewBg.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in));
                        viewBg.setVisibility(View.VISIBLE);
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        fab.setImageResource(R.drawable.ic_mode_edit_black_24dp);
                        viewBg.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_out));
                        viewBg.setVisibility(View.GONE);
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:

                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        viewBg.setOnClickListener(v -> {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            fab.setImageResource(R.drawable.ic_mode_edit_black_24dp);
        });

        fab.setOnClickListener(view -> {
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                fab.setImageResource(R.drawable.ic_close_black_24dp);
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                fab.setImageResource(R.drawable.ic_mode_edit_black_24dp);
            }
        });
    }
}
