package fmproduct.taleynamalar.constants;

import java.util.ArrayList;

import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.models.Banner;

public class BannerC {

    public static ArrayList<Banner> getStaticBanners(){
        ArrayList<Banner> result = new ArrayList<>();

        Banner b01 = new Banner();
        b01.setImage(R.drawable.girl_banner01);
        b01.setType(Banner.BANNER);
        b01.setPhone("+99362891947");
        b01.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");


        Banner b02 = new Banner();
        b02.setImage(R.drawable.girl_banner02);
        b02.setPhone("+99362891947");
        b02.setType(Banner.SHOP);
        b02.setTag("1");
        b02.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");


        Banner b03 = new Banner();
        b03.setImage(R.drawable.girl_banner01);
        b03.setPhone("+99362891947");
        b03.setType(Banner.LINK);
        b03.setTag("http://google.com");
        b03.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");

        result.add(b01);
        result.add(b02);
        result.add(b03);

        return result;
    }
}
