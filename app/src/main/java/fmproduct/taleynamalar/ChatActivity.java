package fmproduct.taleynamalar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import fmproduct.taleynamalar.adapters.recycler.AdminChatAdapter;
import fmproduct.taleynamalar.constants.MessageC;
import fmproduct.taleynamalar.models.Message;

public class ChatActivity extends AppCompatActivity {

    private AdminChatAdapter adminChatAdapter;
    private NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        init();
    }

    private void init(){
        nestedScrollView = findViewById(R.id.nested);
        adminChatAdapter = new AdminChatAdapter(this , MessageC.getMessages());

        RecyclerView recyclerView = findViewById(R.id.chat_recycler);
        recyclerView.setAdapter(adminChatAdapter);

        findViewById(R.id.message_send).setOnClickListener(v->{
            AppCompatEditText editText = findViewById(R.id.message_edit_text);
            if (editText.getText() != null && editText.getText().length() > 5){
                Message message = new Message();
                message.setText(String.valueOf(editText.getText()));
                message.setAdmin(0);
                adminChatAdapter.addMessage(message);
                editText.setText("");
            }
            nestedScrollView.post(()->{
                nestedScrollView.fullScroll(View.FOCUS_DOWN);
            });
        });
    }
}
