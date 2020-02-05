package fmproduct.taleynamalar.constants;

import java.util.ArrayList;

import fmproduct.taleynamalar.models.Comment;
import fmproduct.taleynamalar.models.Product;

public class ProductC {
    public static ArrayList<Product> getProduts(){
        ArrayList<Product> products = new ArrayList<>();

        Product p01 = new Product();
        p01.setId(1);
        p01.setComments(CommentC.getComments());
        p01.setPhotos(ImageC.getImages());
        p01.setCommented(1);
        p01.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");
        p01.setView(200);


        Product p02 = new Product();
        p02.setId(2);
        p02.setComments(CommentC.getComments());
        p02.setPhotos(ImageC.getImages2());
        p02.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");
        p02.setView(300);



        Product p03 = new Product();
        p03.setId(3);
        p03.setComments(CommentC.getComments());
        p03.setPhotos(ImageC.getImages());
        p03.setCommented(1);
        p03.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");
        p03.setView(300);


        Product p04 = new Product();
        p04.setId(4);
        p04.setComments(CommentC.getComments());
        p04.setPhotos(ImageC.getImages2());
        p04.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");
        p04.setView(400);


        Product p05 = new Product();
        p05.setId(5);
        p05.setCommented(1);
        p05.setComments(CommentC.getComments());
        p05.setPhotos(ImageC.getImages());
        p05.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");
        p05.setView(500);

        products.add(p01);
        products.add(p02);
        products.add(p03);
        products.add(p04);
        products.add(p05);

        return products;
    }
}
