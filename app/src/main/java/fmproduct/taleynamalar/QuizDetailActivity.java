package fmproduct.taleynamalar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.skydoves.progressview.ProgressView;

import java.util.ArrayList;

import fmproduct.taleynamalar.adapters.recycler.CommentsAdapter;
import fmproduct.taleynamalar.constants.UserC;
import fmproduct.taleynamalar.models.Comment;
import fmproduct.taleynamalar.models.Option;
import fmproduct.taleynamalar.models.Quiz;

public class QuizDetailActivity extends AppCompatActivity {
    // MODELS
    private Quiz quiz;

    // VIEWS AND FOR VIEWS
    private LinearLayout quizContent;
    private CommentsAdapter commentsAdapter;
    private LayoutInflater inflater;
    private ArrayList<Container> views = new ArrayList<>();
    private NestedScrollView nestedScrollView;

    // PRIMITIVE
    private int allAnswers;
    private boolean isChecked = false;
    private boolean writeComment = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_detail);

        quiz = getIntent().getParcelableExtra("quiz");
        if (quiz == null) return;

        AppCompatTextView titleView = findViewById(R.id.quiz_title);
        titleView.setText(quiz.getTitle());
        init();

        initQuestions();
    }
    private void init(){
        inflater = LayoutInflater.from(this);
        quizContent = findViewById(R.id.quiz_content);
        nestedScrollView = findViewById(R.id.nested);

        if (quiz.getCommented() == 1){
            RecyclerView commentRecycler = findViewById(R.id.comment_recycler);
            commentsAdapter = new CommentsAdapter(this , quiz.getComments());
            commentRecycler.setAdapter(commentsAdapter);
            findViewById(R.id.comment_add).setOnClickListener(v->commentWrite());
            findViewById(R.id.comment_send).setOnClickListener(v->commentSend());
            findViewById(R.id.comment_add_content).animate().translationY(150).setDuration(500).start();
        }
        else{
            findViewById(R.id.comment_add_content).setVisibility(View.GONE);
            findViewById(R.id.comment_content).setVisibility(View.GONE);
        }
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

    private void initQuestions(){
        ArrayList<Option> options = quiz.getOptions();
        for (Option option : options){
            allAnswers += option.getAnswer().size();
        }

        for (Option option : options) {
            View view = inflater.inflate(R.layout.progress_view , null , false);

            ProgressView progressView = view.findViewById(R.id.progress);
            progressView.setLabelTypeface(R.font.m_light);
            progressView.setLabelText(option.getText());
//            progressView.setProgress((float) getPercent(option.getAnswer().size()));
            CheckBox checkBox = view.findViewById(R.id.radio_btn);

            checkBox.setOnCheckedChangeListener((buttonView, isCh) -> {
                if (!isChecked){
                    click();
                    progressView.setProgress((float) getPercent(option.getAnswer().size() + 1.0));
                    progressView.setLabelText(String.format("%s %.1f " , option.getText() , getPercent(option.getAnswer().size() + 1.0)) + "%");
                    progressView.progressAnimate();
                    isChecked = true;
                    checkBox.setEnabled(false);
                }
                else{
                    buttonView.setChecked(false);
                }
            });
            views.add(new Container(progressView, option.getText() , (float) getPercent(option.getAnswer().size())));
            quizContent.addView(view);
        }
    }
    private void click(){
        for (Container container : views){
            container.view.setProgress(container.percent);
            container.view.setLabelText(String.format("%s %.1f " , container.text , container.percent) + "%");
            container.view.progressAnimate();

        }
    }
    private double getPercent( double count){
        return (count / allAnswers) * 100;
    }
    private class Container{
         ProgressView view;
         String text;
         float percent;

        public Container(ProgressView view, String text, float percent) {
            this.view = view;
            this.text = text;
            this.percent = percent;
        }
    }
}
