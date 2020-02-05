package fmproduct.taleynamalar.adapters.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fmproduct.taleynamalar.PostDetailActivity;
import fmproduct.taleynamalar.QuizDetailActivity;
import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.models.Image;
import fmproduct.taleynamalar.models.Model;
import fmproduct.taleynamalar.models.Post;
import fmproduct.taleynamalar.models.Quiz;
import fmproduct.taleynamalar.views.QuizView;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Model> data;

    public static final int NEWS = 2;
    public static final int QUIZ = 3;
    public static final int POST = 1;


    public PostsAdapter(Context context, ArrayList<Model> data) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == QUIZ){
            view = inflater.inflate(R.layout.quiz_item , parent , false);
            return new QuizViewHolder(view);
        }
        if (viewType == POST) view = inflater.inflate(R.layout.post_item , parent , false);
        else view = inflater.inflate(R.layout.news_item , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder holder, int position) {
        int viewtype = getItemViewType(position);
        if (viewtype == POST || viewtype == NEWS){
            Post post = (Post) data.get(position);
            holder.description.setText(post.getText());
            holder.content.setOnClickListener(v->{
                Intent intent = new Intent(context , PostDetailActivity.class);
                intent.putExtra("post" , post);
                context.startActivity(intent);
            });
            Image image = post.getCover();
            if (image != null) holder.image.setImageResource(image.getPath());
        }

//        if (viewtype == NEWS){
//            Post post = (Post) data.get(position);
//            holder.description.setText(post.getText());
//            Image image = post.getCover();
//            if (image != null) holder.image.setImageResource(image.getPath());
//        }


        if (viewtype == QUIZ){
            QuizViewHolder qholder = (QuizViewHolder) holder;
            Quiz quiz = (Quiz) data.get(position);
            qholder.quiz.setText(quiz.getTitle());
            qholder.vote.setOnClickListener(v->{
                Intent intent = new Intent(context , QuizDetailActivity.class);
                intent.putExtra("quiz" , quiz);
                context.startActivity(intent);
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        Model model = data.get(position);
        if (model.getType() == POST) return POST;
        else if (model.getType() == NEWS) return NEWS;
        else return QUIZ;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private AppCompatTextView description;
        private AppCompatImageView image;
        private CardView content;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.content);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image);
        }
    }

    class QuizViewHolder extends ViewHolder{

        private AppCompatTextView quiz;
        private AppCompatButton vote;


        QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            quiz = itemView.findViewById(R.id.quiz);
            vote = itemView.findViewById(R.id.vote);
        }
    }


}
