package fmproduct.taleynamalar.constants;

import java.util.ArrayList;

import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.models.Image;

public class ImageC {
    public static ArrayList<Image> getImages(){
        ArrayList<Image> result = new ArrayList<>();

        result.add(new Image(R.drawable.girl_banner01));
        result.add(new Image(R.drawable.girl_banner02));
        result.add(new Image(R.drawable.girl_banner01));
        result.add(new Image(R.drawable.girl_banner02));

        return result;
    }

    public static ArrayList<Image> getImages2(){
        ArrayList<Image> result = new ArrayList<>();

        result.add(new Image(R.drawable.girl_banner02));
        result.add(new Image(R.drawable.girl_banner01));
        result.add(new Image(R.drawable.girl_banner02));
        result.add(new Image(R.drawable.girl_banner01));

        return result;
    }
}
