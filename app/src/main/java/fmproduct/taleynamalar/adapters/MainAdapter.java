package fmproduct.taleynamalar.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import fmproduct.taleynamalar.MainActivity;
import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.adapters.recycler.PostsAdapter;
import fmproduct.taleynamalar.adapters.recycler.ShopAdapter;
import fmproduct.taleynamalar.response.MainResponse;

public class MainAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;
    private MainResponse data;

    public MainAdapter(Context context, MainResponse data) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if (position == 0){
            View view = inflater.inflate(R.layout.main_item , container , false);
            setClickListeners(view);
            container.addView(view);
            return view;
        }
        else if (position == 1){
            View view = inflater.inflate(R.layout.main_layout , container , false);
            RecyclerView recyclerView = view.findViewById(R.id.main_recycler);
            RecyclerView.Adapter adapter = new PostsAdapter(context , data.getPosts());
            recyclerView.setAdapter(adapter);
            container.addView(view);
            return view;
        }
        else {
            View view = inflater.inflate(R.layout.main_layout , container , false);
            RecyclerView recyclerView = view.findViewById(R.id.main_recycler);
            RecyclerView.Adapter adapter = new ShopAdapter(context , data.getShops());
            recyclerView.setAdapter(adapter);
            container.addView(view);
            return view;
        }
    }

    private void setClickListeners(View view){
        MainActivity activity = (MainActivity) context;

        view.findViewById(R.id.language_card).setOnClickListener(v -> activity.selectLanguage());
        view.findViewById(R.id.shop_card).setOnClickListener(v->activity.goToShop());
        view.findViewById(R.id.list_card).setOnClickListener(v->activity.goToList());
        view.findViewById(R.id.login_card).setOnClickListener(v->activity.login());
        view.findViewById(R.id.registation_card).setOnClickListener(v->activity.regist());
        view.findViewById(R.id.chat_card).setOnClickListener(v->activity.goToChat());

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0)return context.getResources().getString(R.string.home);
        else if (position == 1) return context.getResources().getString(R.string.lenta);
        else return context.getResources().getString(R.string.shops);
    }
}
