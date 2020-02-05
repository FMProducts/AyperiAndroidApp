package fmproduct.taleynamalar.constants;

import java.util.ArrayList;

import fmproduct.taleynamalar.models.Comment;

public class CommentC {

    public static ArrayList<Comment> getComments(){
        ArrayList<Comment> result = new ArrayList<>();

        Comment comment01 = new Comment();
        comment01.setId(1);
        comment01.setText("Bet eken");
        comment01.setUser(UserC.getUser01());


        Comment comment02 = new Comment();
        comment02.setId(3);
        comment02.setText("Howo bla bla bla");
        comment02.setUser(UserC.getUser02());


        Comment comment03 = new Comment();
        comment03.setId(3);
        comment03.setText("Yene bir comment");
        comment03.setUser(UserC.getUser03());

        result.add(comment01);
        result.add(comment02);
        result.add(comment03);

        return result;
    }
}
