package fmproduct.taleynamalar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.adapters.recycler.ProductsAdapter;
import fmproduct.taleynamalar.constants.ProductC;

public class ShopActivity extends AppCompatActivity {

    private int cover;
    private int shopid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        cover = getIntent().getIntExtra("cover" , 0);
        shopid = getIntent().getIntExtra("id" , 0);

        init();
    }

    private void init(){
        AppCompatImageView shopCover = findViewById(R.id.shop_image);
        RecyclerView recyclerView  = findViewById(R.id.shop_recycler);

        shopCover.setImageResource(this.cover);

        ProductsAdapter adapter = new ProductsAdapter(this , ProductC.getProduts());
        recyclerView.setAdapter(adapter);
    }
}
