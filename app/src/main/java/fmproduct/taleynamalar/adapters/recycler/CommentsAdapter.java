package fmproduct.taleynamalar.adapters.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.models.Comment;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private ArrayList<Comment> data;
    private LayoutInflater inflater;
    private int ownId = 2;

    private final static int OWN_COMMENT = 1;
    private final static int COMMENT = 2;

    public CommentsAdapter(Context context , ArrayList<Comment> comments){
        this.inflater = LayoutInflater.from(context);
        this.data = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == COMMENT) view = inflater.inflate(R.layout.comment_item , parent , false);
        else view = inflater.inflate(R.layout.comment_own_item , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comment comment = data.get(position);

        holder.comment.setText(comment.getText());
        holder.username.setText(comment.getUser().getName());
    }

    @Override
    public int getItemViewType(int position) {
        Comment comment = data.get(position);
        return comment.getUser().getId() == ownId ? OWN_COMMENT : COMMENT;
    }

    public void add(Comment comment){
        data.add(comment);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private AppCompatTextView username;
        private AppCompatTextView comment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.user);
            comment = itemView.findViewById(R.id.text);
        }
    }

}
