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
import fmproduct.taleynamalar.models.Message;

public class AdminChatAdapter extends RecyclerView.Adapter<AdminChatAdapter.ViewHolder> {

//    private Context context;
    private ArrayList<Message> data;
    private LayoutInflater inflater;
    private String username;

    private static final int ADMIN = 1;
    private static final int USER = 2;

    public AdminChatAdapter(Context context, ArrayList<Message> messages) {
//        this.context = context;
        this.data = messages;
        this.username = "Merjen";
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if (viewType == USER) view = inflater.inflate(R.layout.message_item , parent , false);
        else view = inflater.inflate(R.layout.message_admin_item , parent , false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Message message = data.get(position);
        holder.text.setText(message.getText());
        holder.user.setText(message.getAdmin() == 1 ? "Admin" : this.username);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        Message message = data.get(position);
        if (message.getAdmin() == 1) return ADMIN;
        else return USER;
    }

    public void addMessage(Message message){
        data.add(message);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private AppCompatTextView text;
        private AppCompatTextView user;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            user = itemView.findViewById(R.id.user);
        }
    }
}
