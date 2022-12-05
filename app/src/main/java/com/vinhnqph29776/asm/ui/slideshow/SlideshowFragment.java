package com.vinhnqph29776.asm.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.vinhnqph29776.asm.R;
import com.vinhnqph29776.asm.adapter.ChiPagerAdapter;
import com.vinhnqph29776.asm.adapter.MyPagerAdapter;
import com.vinhnqph29776.asm.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {
    private ViewPager2 viewPager;
    private ChiPagerAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_slideshow,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager=view.findViewById(R.id.khoanchi_viewpager);

        adapter=new ChiPagerAdapter(this);
        viewPager.setAdapter(adapter);
        TabLayout tab=view.findViewById(R.id.khoanchi_tab);
        TabLayoutMediator mediator=new TabLayoutMediator(tab, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position==0){
                    tab.setText("Khoản chi");
                }if(position==1){
                    tab.setText("Loại chi");
                }
            }
        });
        mediator.attach();
    }
}