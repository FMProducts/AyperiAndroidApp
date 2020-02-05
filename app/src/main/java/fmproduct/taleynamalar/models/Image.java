package fmproduct.taleynamalar.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Image implements Parcelable {
    private int path;

    public Image() {
    }

    public Image(int path) {
        this.path = path;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.path);
    }

    protected Image(Parcel in) {
        this.path = in.readInt();
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
