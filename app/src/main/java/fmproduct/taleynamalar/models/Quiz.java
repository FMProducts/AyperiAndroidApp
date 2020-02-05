package fmproduct.taleynamalar.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Quiz extends Model implements Parcelable {
    @SerializedName("id")
    @Expose
    private  int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("options")
    @Expose
    private ArrayList<Option> options;
    // quiz : 3
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("comments")
    @Expose
    private ArrayList<Comment> comments;

    @SerializedName("views")
    @Expose
    private int view;

    @SerializedName("likes")
    @Expose
    private int likes;

    @SerializedName("commented")
    @Expose
    private int commented;

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getCommented() {
        return commented;
    }

    public void setCommented(int commented) {
        this.commented = commented;
    }

    public ArrayList<Comment>  getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment>  comments) {
        this.comments = comments;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }


    public Quiz() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeTypedList(this.options);
        dest.writeInt(this.type);
        dest.writeTypedList(this.comments);
        dest.writeInt(this.view);
        dest.writeInt(this.likes);
        dest.writeInt(this.commented);
    }

    protected Quiz(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.options = in.createTypedArrayList(Option.CREATOR);
        this.type = in.readInt();
        this.comments = in.createTypedArrayList(Comment.CREATOR);
        this.view = in.readInt();
        this.likes = in.readInt();
        this.commented = in.readInt();
    }

    public static final Creator<Quiz> CREATOR = new Creator<Quiz>() {
        @Override
        public Quiz createFromParcel(Parcel source) {
            return new Quiz(source);
        }

        @Override
        public Quiz[] newArray(int size) {
            return new Quiz[size];
        }
    };
}
