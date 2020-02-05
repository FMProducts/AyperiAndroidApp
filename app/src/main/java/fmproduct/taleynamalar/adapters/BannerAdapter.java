package fmproduct.taleynamalar.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import fmproduct.taleynamalar.BannerDetailActivity;
import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.ShopActivity;
import fmproduct.taleynamalar.constants.ShopC;
import fmproduct.taleynamalar.models.Banner;
import fmproduct.taleynamalar.models.Shop;

public class BannerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Banner> data;


    public BannerAdapter(Context context, ArrayList<Banner> data) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.banner_layout , container , false);
        Banner banner = data.get(position);

        AppCompatImageView image = view.findViewById(R.id.image);
        RelativeLayout content = view.findViewById(R.id.content);

        content.setOnClickListener(v->{
            if (banner.getType() == Banner.BANNER){
                Intent intent = new Intent(context , BannerDetailActivity.class);
                intent.putExtra("banner" , banner);
                context.startActivity(intent);
            }
            else if (banner.getType() == Banner.LINK){
                String url = banner.getTag();
                if (!url.startsWith("http://") && !url.startsWith("https://")) url = "http://" + url;
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(browserIntent);
            }
            else if (banner.getType() == Banner.SHOP){
                Shop shop = ShopC.getShop();
                Intent intent = new Intent(context , ShopActivity.class);
                intent.putExtra("id" , shop.getId());
                intent.putExtra("cover" , shop.getCover());
                context.startActivity(intent);
            }
        });

        image.setImageResource(banner.getImage());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
