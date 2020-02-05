package fmproduct.taleynamalar.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Post extends Model implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("likes")
    @Expose
    private int likes;

    @SerializedName("view")
    @Expose
    private int view;

    // post : 1 , news : 2
    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("tag")
    @Expose
    private int tag;

    @SerializedName("photos")
    @Expose
    private ArrayList<Image> photos;

    @SerializedName("comments")
    @Expose
    private ArrayList<Comment> comments;

    @SerializedName("commented")
    @Expose
    private int commented;

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public int getCommented() {
        return commented;
    }

    public void setCommented(int commented) {
        this.commented = commented;
    }

    public Image getCover(){
        if (photos.size() >= 1) return photos.get(0);
        else return null;
    }

    public ArrayList<Image> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Image> photos) {
        this.photos = photos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public Post() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.text);
        dest.writeInt(this.likes);
        dest.writeInt(this.view);
        dest.writeInt(this.type);
        dest.writeInt(this.tag);
        dest.writeTypedList(this.photos);
        dest.writeTypedList(this.comments);
        dest.writeInt(this.commented);
    }

    protected Post(Parcel in) {
        this.id = in.readInt();
        this.text = in.readString();
        this.likes = in.readInt();
        this.view = in.readInt();
        this.type = in.readInt();
        this.tag = in.readInt();
        this.photos = in.createTypedArrayList(Image.CREATOR);
        this.comments = in.createTypedArrayList(Comment.CREATOR);
        this.commented = in.readInt();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel source) {
            return new Post(source);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}
