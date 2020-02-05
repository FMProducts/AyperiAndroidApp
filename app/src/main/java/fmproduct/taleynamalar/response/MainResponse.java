package fmproduct.taleynamalar.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import fmproduct.taleynamalar.models.Banner;
import fmproduct.taleynamalar.models.Model;
import fmproduct.taleynamalar.models.Shop;

public class MainResponse {
    @SerializedName("banners")
    @Expose
    private ArrayList<Banner> banners;

    @SerializedName("posts")
    @Expose
    private ArrayList<Model> posts;

    @SerializedName("shops")
    @Expose
    private ArrayList<Shop> shops;

    public ArrayList<Banner> getBanners() {
        return banners;
    }

    public void setBanners(ArrayList<Banner> banners) {
        this.banners = banners;
    }

    public ArrayList<Model> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Model> posts) {
        this.posts = posts;
    }

    public ArrayList<Shop> getShops() {
        return shops;
    }

    public void setShops(ArrayList<Shop> shops) {
        this.shops = shops;
    }
}
