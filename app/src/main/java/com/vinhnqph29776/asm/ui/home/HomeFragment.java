package com.vinhnqph29776.asm.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.vinhnqph29776.asm.R;
import com.vinhnqph29776.asm.adapter.MyPagerAdapter;
import com.vinhnqph29776.asm.databinding.FragmentHomeBinding;

import javax.security.auth.callback.Callback;

public class HomeFragment extends Fragment {

 FragmentHomeBinding binding;
 WebView webView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
View view=inflater.inflate(R.layout.fragment_home,container,false);
webView=view.findViewById(R.id.webview_about);
webView.getSettings().setAllowContentAccess(true);
webView.setWebViewClient(new Callback());
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/vinfast.html");
return view;
    }
private class Callback extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return  false;
    }
}
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}