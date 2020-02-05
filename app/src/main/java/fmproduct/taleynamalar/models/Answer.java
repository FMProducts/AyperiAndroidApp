package fmproduct.taleynamalar.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer implements Parcelable {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("userid")
    @Expose
    private int userid;
    @SerializedName("question")
    @Expose
    private int question_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.userid);
        dest.writeInt(this.question_id);
    }

    public Answer() {
    }

    protected Answer(Parcel in) {
        this.id = in.readInt();
        this.userid = in.readInt();
        this.question_id = in.readInt();
    }

    public static final Parcelable.Creator<Answer> CREATOR = new Parcelable.Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel source) {
            return new Answer(source);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };
}
