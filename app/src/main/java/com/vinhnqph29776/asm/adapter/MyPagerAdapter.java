package com.vinhnqph29776.asm.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.vinhnqph29776.asm.Khoanthu;
import com.vinhnqph29776.asm.fragment_loaithu;

public class MyPagerAdapter extends FragmentStateAdapter {
    int pagesize=2;

    public MyPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new Khoanthu();
            case 1: return  new fragment_loaithu();
        }return null;
    }

    @Override
    public int getItemCount() {
        return pagesize;
    }
}

