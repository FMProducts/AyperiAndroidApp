package fmproduct.taleynamalar.constants;

import java.util.ArrayList;

import fmproduct.taleynamalar.R;
import fmproduct.taleynamalar.models.Shop;

public class ShopC {

    public static Shop getShop(){
        Shop shop01 = new Shop();
        shop01.setCover(R.drawable.girl_banner01);
        shop01.setName("Jeren Market");
        shop01.setTopic("jerentopic");

        return shop01;
    }

    public static ArrayList<Shop> getShops(){
        ArrayList<Shop> result = new ArrayList<>();

        Shop shop01 = new Shop();
        shop01.setCover(R.drawable.girl_banner01);
        shop01.setName("Jeren Market");
        shop01.setTopic("jerentopic");


        Shop shop02 = new Shop();
        shop02.setCover(R.drawable.girl_banner02);
        shop02.setName("Женская хрень");
        shop02.setTopic("zhenskayahren");


        Shop shop03 = new Shop();
        shop03.setCover(R.drawable.girl_banner01);
        shop03.setName("Mahri makeup");
        shop03.setTopic("mahrimakeup");


        result.add(shop01);
        result.add(shop02);
        result.add(shop03);

        return result;
    }
}
