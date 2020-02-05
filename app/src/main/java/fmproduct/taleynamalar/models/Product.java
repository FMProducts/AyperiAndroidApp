package fmproduct.taleynamalar.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Product implements Parcelable {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("photos")
    @Expose
    private ArrayList<Image> photos;

    @SerializedName("view")
    @Expose
    private int view;

    @SerializedName("comments")
    @Expose
    private ArrayList<Comment> comments;

    @SerializedName("views")
    @Expose
    private int views;

    @SerializedName("likes")
    @Expose
    private int likes;

    @SerializedName("commented")
    @Expose
    private int commented;

    public int getCommented() {
        return commented;
    }

    public void setCommented(int commented) {
        this.commented = commented;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }


    public Product() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.text);
        dest.writeTypedList(this.photos);
        dest.writeInt(this.view);
        dest.writeTypedList(this.comments);
        dest.writeInt(this.views);
        dest.writeInt(this.likes);
        dest.writeInt(this.commented);
    }

    protected Product(Parcel in) {
        this.id = in.readInt();
        this.text = in.readString();
        this.photos = in.createTypedArrayList(Image.CREATOR);
        this.view = in.readInt();
        this.comments = in.createTypedArrayList(Comment.CREATOR);
        this.views = in.readInt();
        this.likes = in.readInt();
        this.commented = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
