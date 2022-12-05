package com.vinhnqph29776.asm;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.tabs.TabLayout;
import com.vinhnqph29776.asm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
TabLayout tabLayout;


    private AppBarConfiguration mAppBarConfiguration;
ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navigationView.setItemIconTintList(null);
        tabLayout=findViewById(R.id.khoanthu_tab);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
            R.id.nav_icomes, R.id.nav_spends,R.id.nav_statistic,R.id.nav_about,R.id.nav_exit)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_exit:
                        finish();
                        break;
                    case R.id.nav_icomes:
                                navController.navigate(R.id.nav_icomes);
                        drawer.closeDrawer(GravityCompat.START);
                                break;
                    case R.id.nav_spends:
                        navController.navigate(R.id.nav_spends);
                     drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_statistic:
                        navController.navigate(R.id.nav_statistic);
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_about:
                        navController.navigate(R.id.nav_about);
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                }

         return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}