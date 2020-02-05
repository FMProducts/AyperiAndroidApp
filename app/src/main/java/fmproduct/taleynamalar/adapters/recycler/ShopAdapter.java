package fmproduct.taleynamalar.adapters.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.ShopActivity;
import fmproduct.taleynamalar.models.Shop;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Shop> data;

    public ShopAdapter(Context context, ArrayList<Shop> data) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ShopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shop_item , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ViewHolder holder, int position) {
        Shop shop = data.get(position);
        holder.name.setText(shop.getName());
        holder.image.setImageResource(shop.getCover());
        holder.card.setOnClickListener(v->{
            Intent intent = new Intent(context , ShopActivity.class);
            intent.putExtra("id" , shop.getId());
            intent.putExtra("cover" , shop.getCover());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageView image;
        private AppCompatTextView name;
        private CardView card;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.card);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
        }
    }
}
