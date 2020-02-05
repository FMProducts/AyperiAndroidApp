package fmproduct.taleynamalar.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Option implements Parcelable {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("answer")
    @Expose
    private ArrayList<Answer> answer;

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

    public ArrayList<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<Answer> answer) {
        this.answer = answer;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.text);
        dest.writeList(this.answer);
    }

    public Option() {
    }

    protected Option(Parcel in) {
        this.id = in.readInt();
        this.text = in.readString();
        this.answer = new ArrayList<Answer>();
        in.readList(this.answer, Answer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Option> CREATOR = new Parcelable.Creator<Option>() {
        @Override
        public Option createFromParcel(Parcel source) {
            return new Option(source);
        }

        @Override
        public Option[] newArray(int size) {
            return new Option[size];
        }
    };
}
