package fmproduct.taleynamalar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import fmproduct.taleynamalar.R;

public class StartActivity extends AppCompatActivity {

    // Fariz
    // 6289
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new Handler().postDelayed(()->{
            startActivity(new Intent(StartActivity.this , MainActivity.class));
            finish();
        }, 2000);

    }
}
