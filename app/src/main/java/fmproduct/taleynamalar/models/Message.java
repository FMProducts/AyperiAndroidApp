package fmproduct.taleynamalar.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message implements Parcelable {
//    private int id;
//    private int chatid;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("admin")
    @Expose
    private int admin;


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
        dest.writeInt(this.admin);
    }

    public Message() {
    }

    protected Message(Parcel in) {
        this.text = in.readString();
        this.admin = in.readInt();
    }

    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel source) {
            return new Message(source);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };
}
