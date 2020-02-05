package fmproduct.taleynamalar.constants;

import java.util.ArrayList;

import fmproduct.taleynamalar.models.Answer;

public class AnswerC {

    public static ArrayList<Answer> getAnswers(){
        ArrayList<Answer> result = new ArrayList<>();

        Answer answer01 = new Answer();
        answer01.setId(1);
        answer01.setQuestion_id(1);
        answer01.setUserid(12);


        Answer answer02 = new Answer();
        answer01.setId(1);
        answer01.setQuestion_id(2);
        answer01.setUserid(12);


        Answer answer03 = new Answer();
        answer01.setId(1);
        answer01.setQuestion_id(3);
        answer01.setUserid(12);


        Answer answer04 = new Answer();
        answer01.setId(1);
        answer01.setQuestion_id(4);
        answer01.setUserid(12);


        Answer answer05 = new Answer();
        answer01.setId(1);
        answer01.setQuestion_id(1);
        answer01.setUserid(12);


        Answer answer06 = new Answer();
        answer01.setId(1);
        answer01.setQuestion_id(2);
        answer01.setUserid(12);


        Answer answer07 = new Answer();
        answer01.setId(1);
        answer01.setQuestion_id(3);
        answer01.setUserid(12);

        Answer answer08 = new Answer();
        answer01.setId(1);
        answer01.setQuestion_id(4);
        answer01.setUserid(12);

        result.add(answer01);
        result.add(answer02);
        result.add(answer03);
        result.add(answer04);
        result.add(answer05);
        result.add(answer06);
        result.add(answer07);
        result.add(answer08);

        return result;
    }
}
