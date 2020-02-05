package fmproduct.taleynamalar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import fmproduct.taleynamalar.models.Banner;

public class BannerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_detail);
        setTitle(R.string.app_name);

        Banner banner = getIntent().getParcelableExtra("banner");
        if (banner == null) return;

        AppCompatTextView bannerText = findViewById(R.id.banner_text);
        AppCompatImageView bannerImage = findViewById(R.id.banner_image);

        bannerText.setText(banner.getText());
        bannerImage.setImageResource(banner.getImage());

        findViewById(R.id.banner_call).setOnClickListener(v->{
            Intent intent = new Intent(Intent.ACTION_DIAL , Uri.parse("tel:"+banner.getPhone()));
            startActivity(intent);
        });
    }
}
