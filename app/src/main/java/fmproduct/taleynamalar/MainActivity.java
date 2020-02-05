package fmproduct.taleynamalar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;

import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.adapters.BannerAdapter;
import fmproduct.taleynamalar.adapters.MainAdapter;
import fmproduct.taleynamalar.constants.MainResponsC;
import fmproduct.taleynamalar.response.MainResponse;

public class MainActivity extends AppCompatActivity {

    private ViewPager mainPager;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        init();
    }



    private void init(){
        TabLayout tabs = findViewById(R.id.main_tabs);
        ViewPager bannerPager = findViewById(R.id.banner_pager);
        mainPager = findViewById(R.id.main_pager);
        appBarLayout = findViewById(R.id.app_bar);

        mainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                appBarLayout.setExpanded(true , true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        MainResponse response = MainResponsC.getMainResponse();

        BannerAdapter bannerAdapter = new BannerAdapter(this , response.getBanners());
        bannerPager.setAdapter(bannerAdapter);

        MainAdapter mainAdapter = new MainAdapter(this , response);
        mainPager.setAdapter(mainAdapter);
        tabs.setupWithViewPager(mainPager);


    }

    public void selectLanguage(){
        new AlertDialog.Builder(this)
                .setItems(R.array.languages, (dialog, which) -> {

                })
                .setCancelable(false).show();
    }
    public void login(){
        startActivity(new Intent(MainActivity.this , LoginActivity.class));
    }
    public void regist(){
        Intent intent = new Intent(MainActivity.this , LoginActivity.class);
        intent.putExtra("type" , 2);
        startActivity(intent);
    }
    public void goToList(){
        mainPager.setCurrentItem(1, true);
    }
    public void goToShop(){
        mainPager.setCurrentItem(2 , true);
    }
    public void goToChat(){startActivity(new Intent(MainActivity.this , ChatActivity.class));}
}
