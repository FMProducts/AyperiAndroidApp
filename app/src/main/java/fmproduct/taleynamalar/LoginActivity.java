package fmproduct.taleynamalar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        int type = getIntent().getIntExtra("type" , 0);
        if (type == 2){
            AppCompatTextView title = findViewById(R.id.title);
            title.setText("Регистрация");
        }
    }
}
