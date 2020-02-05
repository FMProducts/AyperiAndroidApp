package fmproduct.taleynamalar.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatTextView;

import java.util.ArrayList;

import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.models.Answer;
import fmproduct.taleynamalar.models.Option;
import fmproduct.taleynamalar.models.Quiz;

public class QuizView extends RelativeLayout {

    private Quiz quiz;

    public QuizView(Context context) {
        super(context);
    }

    public QuizView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QuizView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public QuizView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
        init();
    }

    public void init(){
        if (quiz == null) return;

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View view = inflater.inflate(R.layout.quiz_view , this , false);
        LinearLayout q_content =  view.findViewById(R.id.quiz_content);
        ArrayList<View> questions = getQuestionsView(quiz.getOptions() , inflater);

        for (View v : questions) {
            q_content.addView(v);
        }

        addView(view);
    }

    private ArrayList<View> getQuestionsView(ArrayList<Option> options, LayoutInflater inflater){
        ArrayList<Answer> answers = new ArrayList<>();
        ArrayList<View> views = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            answers.addAll(options.get(i).getAnswer());
        }

        for (int i = 0; i < options.size(); i++) {
            Option q = options.get(i);
            View view = inflater.inflate(R.layout.question_view , this , false);
            ProgressBar progressBar = view.findViewById(R.id.progress);
            AppCompatTextView percent = view.findViewById(R.id.percent);
            AppCompatTextView title = view.findViewById(R.id.title);

            title.setText(q.getText());
            progressBar.setVisibility(View.INVISIBLE);
            progressBar.setProgress((int) getPercent(answers.size() , q.getAnswer().size()));
            percent.setVisibility(View.INVISIBLE);
            percent.setText(getPercent(answers.size(), q.getAnswer().size()) + "%");

            title.setOnClickListener(v->{
                clicked(progressBar , percent ,getPercent(answers.size() , q.getAnswer().size())  , views , q);
                sendAnswer();
            });

            views.add(view);
        }

        return views;
    }

    private void clicked(ProgressBar progressBar , AppCompatTextView percent , double percentValue , ArrayList<View> views , Option option){
        for (View view : views) {

            AppCompatTextView per = view.findViewById(R.id.percent);
            ProgressBar pr = view.findViewById(R.id.progress);
            per.setVisibility(View.VISIBLE);
            pr.setVisibility(View.VISIBLE);
//            ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, 0,Float.parseFloat(percent.getText().toString()));
//            anim.setDuration(2000);
//            pr.startAnimation(anim);

        }

        progressBar.setVisibility(View.VISIBLE);
        percent.setVisibility(View.VISIBLE);


//        ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, 0,  (float) percentValue);
//        anim.setDuration(2000);
//        progressBar.startAnimation(anim);
    }

    private void sendAnswer(){

    }

    private double getPercent(double allanswers , double count){
        return (count / allanswers) * 100;
    }

}
