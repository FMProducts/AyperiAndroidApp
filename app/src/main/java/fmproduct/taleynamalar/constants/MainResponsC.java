package fmproduct.taleynamalar.constants;

import fmproduct.taleynamalar.response.MainResponse;

public class MainResponsC {

    public static MainResponse getMainResponse(){
        MainResponse result = new MainResponse();

        result.setBanners(BannerC.getStaticBanners());
        result.setPosts(PostC.getPosts());
        result.setShops(ShopC.getShops());

        return result;
    }
}
