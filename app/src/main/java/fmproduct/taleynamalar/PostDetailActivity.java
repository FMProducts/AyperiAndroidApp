package fmproduct.taleynamalar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkEventListener;

import fmproduct.taleynamalar.adapters.recycler.CommentsAdapter;
import fmproduct.taleynamalar.adapters.recycler.PostsAdapter;
import fmproduct.taleynamalar.constants.UserC;
import fmproduct.taleynamalar.models.Comment;
import fmproduct.taleynamalar.models.Post;
import retrofit2.http.POST;

public class PostDetailActivity extends AppCompatActivity {

    private NestedScrollView nestedScrollView;
    private CommentsAdapter commentsAdapter;
    private boolean writeComment = false;
    private Post post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        post = getIntent().getParcelableExtra("post");

        init();
    }

    private void init(){
        nestedScrollView = findViewById(R.id.nested);
        AppCompatTextView postText = findViewById(R.id.post_text);
        AppCompatImageView postImage = findViewById(R.id.post_image);
        SparkButton like = findViewById(R.id.like);

        postImage.setImageResource(post.getCover().getPath());
        postText.setText(post.getText());

        findViewById(R.id.header_news).setVisibility(post.getType() == PostsAdapter.NEWS ? View.VISIBLE : View.INVISIBLE);
        findViewById(R.id.ayperi).setVisibility(post.getType() == PostsAdapter.POST ? View.VISIBLE : View.INVISIBLE);

        if (post.getCommented() == 1){
            RecyclerView commentRecycler = findViewById(R.id.comment_recycler);
            commentsAdapter = new CommentsAdapter(this , post.getComments());
            commentRecycler.setAdapter(commentsAdapter);
            findViewById(R.id.comment_add).setOnClickListener(v->commentWrite());
            findViewById(R.id.comment_send).setOnClickListener(v->commentSend());
            findViewById(R.id.comment_add_content).animate().translationY(150).setDuration(500).start();
        }
        else{
            findViewById(R.id.comment_add_content).setVisibility(View.GONE);
            findViewById(R.id.comment_content).setVisibility(View.GONE);
        }


        like.setEventListener(new SparkEventListener() {
            @Override
            public void onEvent(ImageView button, boolean buttonState) {

                like.setActiveImage(R.drawable.heart_fill);
                like.setInactiveImage(R.drawable.heart_fill);
            }

            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {
                like.setActiveImage(R.drawable.heart_fill);
                like.setInactiveImage(R.drawable.heart_fill);
            }

            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });
    }

    private void commentWrite(){
        findViewById(R.id.comment_add).animate().alpha(0).setDuration(500).start();
        findViewById(R.id.comment_add_content).animate().translationY(0).setDuration(500).start();


        nestedScrollView.post(() -> nestedScrollView.fullScroll(View.FOCUS_DOWN));
        writeComment = true;
    }
    private void commentSend(){
        if (!writeComment) return;
        AppCompatEditText editText = findViewById(R.id.comment_edit_text);
        findViewById(R.id.comment_add).animate().alpha(1).setDuration(500).start();
        findViewById(R.id.comment_add_content).animate().translationY(150).setDuration(500).start();

        nestedScrollView.post(() -> nestedScrollView.fullScroll(View.FOCUS_DOWN));

        Comment comment = new Comment();
        comment.setId(12);
        comment.setText(String.valueOf(editText.getText()));
        comment.setUser(UserC.getUser02());

        if (commentsAdapter != null){
            commentsAdapter.add(comment);
            editText.setText("");
        }
        writeComment = false;

    }

}
