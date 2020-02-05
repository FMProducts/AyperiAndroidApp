package fmproduct.taleynamalar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.adapters.BannerAdapter;
import fmproduct.taleynamalar.adapters.MainAdapter;
import fmproduct.taleynamalar.constants.MainResponsC;
import fmproduct.taleynamalar.response.MainResponse;

public class MainOldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_old);

        init();
    }

    private void init(){
        TabLayout tabs = findViewById(R.id.main_tabs);
        ViewPager bannerPager = findViewById(R.id.banner_pager);
        ViewPager mainPager = findViewById(R.id.main_pager);

        MainResponse response = MainResponsC.getMainResponse();

        BannerAdapter bannerAdapter = new BannerAdapter(this , response.getBanners());
        bannerPager.setAdapter(bannerAdapter);

        MainAdapter mainAdapter = new MainAdapter(this , response);
        mainPager.setAdapter(mainAdapter);
        tabs.setupWithViewPager(mainPager);


        NestedScrollView nsv = findViewById(R.id.nested);

        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.M){
            CoordinatorLayout.LayoutParams lpm = new CoordinatorLayout.LayoutParams(
                    CoordinatorLayout.LayoutParams.MATCH_PARENT, CoordinatorLayout.LayoutParams.MATCH_PARENT);
            lpm.setMargins(0,0,0,0);
            lpm.setBehavior(new AppBarLayout.ScrollingViewBehavior());
            nsv.setLayoutParams(lpm);
            nsv.requestLayout();
        }
    }

}
