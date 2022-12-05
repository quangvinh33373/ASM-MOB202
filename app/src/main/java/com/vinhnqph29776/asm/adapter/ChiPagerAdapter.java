package com.vinhnqph29776.asm.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.vinhnqph29776.asm.Khoanthu;
import com.vinhnqph29776.asm.fragment_loaithu;
import com.vinhnqph29776.asm.khoanchi;
import com.vinhnqph29776.asm.loaichi;
import com.vinhnqph29776.asm.ui.slideshow.SlideshowFragment;

public class ChiPagerAdapter extends FragmentStateAdapter {
    int pagesize=2;
    public ChiPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new khoanchi();
            case 1: return  new loaichi();
        }return null;
    }

    @Override
    public int getItemCount() {
        return pagesize;
    }
}
