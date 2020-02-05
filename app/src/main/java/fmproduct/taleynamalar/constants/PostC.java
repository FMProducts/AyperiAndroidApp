package fmproduct.taleynamalar.constants;

import java.util.ArrayList;

import fmproduct.taleynamalar.models.Comment;
import fmproduct.taleynamalar.models.Model;
import fmproduct.taleynamalar.models.Post;
import fmproduct.taleynamalar.models.Quiz;

public class PostC {

    public static ArrayList<Model> getPosts(){
        ArrayList<Model> result = new ArrayList<>();

        Post post01 = new Post();
        post01.setType(1);
        post01.setView(100);
        post01.setLikes(99);
        post01.setComments(CommentC.getComments());
        post01.setCommented(1);

        post01.setPhotos(ImageC.getImages());
        post01.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");

        Quiz q01 = new Quiz();
        q01.setId(1);
        q01.setType(3);
        q01.setComments(CommentC.getComments());
        q01.setCommented(1);
        q01.setComments(CommentC.getComments());
        q01.setTitle("Лучший Поисковик по вашему мнению?");
        q01.setOptions(QuestionC.getQuistionsWebSite());


        Quiz q02 = new Quiz();
        q02.setId(1);
        q02.setType(3);
        q02.setComments(CommentC.getComments());
        q02.setCommented(0);
        q02.setComments(CommentC.getComments());
        q02.setTitle("Читаете ли вы стихи пушкина?");
        q02.setOptions(QuestionC.getQuistionsPoem());


        Quiz q03 = new Quiz();
        q03.setId(1);
        q03.setType(3);
        q03.setComments(CommentC.getComments());
        q03.setCommented(1);
        q03.setComments(CommentC.getComments());
        q03.setTitle("Куда бы вы хотели слетать на каникулах?");
        q03.setOptions(QuestionC.getQuistionsRelax());


        Post post02 = new Post();
        post02.setType(2);
        post02.setView(100);
        post02.setComments(CommentC.getComments());
        post02.setCommented(0);
        post02.setLikes(99);
        post02.setPhotos(ImageC.getImages2());
        post02.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");


        Post post03 = new Post();
        post03.setType(1);
        post03.setView(100);
        post03.setLikes(99);
        post03.setComments(CommentC.getComments());
        post03.setCommented(1);
        post03.setPhotos(ImageC.getImages());
        post03.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");


        Post post04 = new Post();
        post04.setType(2);
        post04.setView(100);
        post04.setLikes(99);
        post04.setComments(CommentC.getComments());
        post04.setCommented(0);
        post04.setPhotos(ImageC.getImages2());
        post04.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");

        result.add(post01);
        result.add(q01);
        result.add(post02);
        result.add(q02);
        result.add(post03);
        result.add(q03);
        result.add(post04);

        return result;
    }
}
