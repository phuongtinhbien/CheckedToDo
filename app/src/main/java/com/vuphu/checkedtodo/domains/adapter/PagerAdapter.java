package com.vuphu.checkedtodo.domains.adapter;

import com.vuphu.checkedtodo.domains.note.HomeFragment_;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.ItemTouchHelper;

public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = HomeFragment_.builder().arg("DIRECTION", ItemTouchHelper.RIGHT).build();
                break;
            case 1:
                frag = HomeFragment_.builder().arg("DIRECTION", ItemTouchHelper.LEFT).build();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "All";
                break;
            case 1:
                title = "History";
                break;
        }
        return title;
    }
}
