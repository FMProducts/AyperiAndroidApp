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

import fmproduct.taleynamalar.ProductDetailActivity;
import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.models.Image;
import fmproduct.taleynamalar.models.Product;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Product> data;

    public ProductsAdapter(Context context, ArrayList<Product> data) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.product_item , parent,  false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ViewHolder holder, int position) {
        Product product = data.get(position);
        Image cover = product.getCover();
        if (cover != null) holder.image.setImageResource(cover.getPath());
        holder.text.setText(product.getText());
        holder.content.setOnClickListener(v -> {
            Intent intent = new Intent(context , ProductDetailActivity.class);
            intent.putExtra("product" , product);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private AppCompatTextView text;
        private AppCompatImageView image;
        private CardView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.product_text);
            image = itemView.findViewById(R.id.product_image);
            content = itemView.findViewById(R.id.content);
        }
    }
}
