package fmproduct.taleynamalar.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner implements Parcelable {

    public static final int BANNER = 0;
    public static final int LINK = 1;
    public static final int SHOP = 2;


    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("image")
    @Expose
    private int image;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("tag")
    @Expose
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Banner() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.text);
        dest.writeInt(this.image);
        dest.writeString(this.phone);
        dest.writeInt(this.type);
        dest.writeString(this.tag);
    }

    protected Banner(Parcel in) {
        this.id = in.readInt();
        this.text = in.readString();
        this.image = in.readInt();
        this.phone = in.readString();
        this.type = in.readInt();
        this.tag = in.readString();
    }

    public static final Creator<Banner> CREATOR = new Creator<Banner>() {
        @Override
        public Banner createFromParcel(Parcel source) {
            return new Banner(source);
        }

        @Override
        public Banner[] newArray(int size) {
            return new Banner[size];
        }
    };
}
