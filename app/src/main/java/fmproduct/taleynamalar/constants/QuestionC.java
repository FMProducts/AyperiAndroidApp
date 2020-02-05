package fmproduct.taleynamalar.constants;

import java.util.ArrayList;

import fmproduct.taleynamalar.models.Option;

public class QuestionC {

    public static ArrayList<Option> getQuistionsWebSite(){
        ArrayList<Option> result = new ArrayList<>();

        Option option01 = new Option();
        option01.setId(1);
        option01.setAnswer(AnswerC.getAnswers());
        option01.setText("www.google.com");

        Option option02 = new Option();
        option02.setId(2);
        option02.setAnswer(AnswerC.getAnswers());
        option02.setText("www.yandex.ru");

        Option option03 = new Option();
        option03.setId(3);
        option03.setAnswer(AnswerC.getAnswers());
        option03.setText("www.bingo.com");

        Option option04 = new Option();
        option04.setId(4);
        option04.setAnswer(AnswerC.getAnswers());
        option04.setText("www.yahoo.com");


        result.add(option01);
        result.add(option02);
        result.add(option03);
        result.add(option04);

        return result;
    }

    public static ArrayList<Option> getQuistionsPoem(){
        ArrayList<Option> result = new ArrayList<>();

        Option option01 = new Option();
        option01.setId(1);
        option01.setAnswer(AnswerC.getAnswers());
        option01.setText("Да");

        Option option02 = new Option();
        option02.setId(2);
        option02.setAnswer(AnswerC.getAnswers());
        option02.setText("Нет");

        Option option03 = new Option();
        option03.setId(3);
        option03.setAnswer(AnswerC.getAnswers());
        option03.setText("Иногда");

        result.add(option01);
        result.add(option02);
        result.add(option03);

        return result;
    }

    public static ArrayList<Option> getQuistionsRelax(){
        ArrayList<Option> result = new ArrayList<>();

        Option option01 = new Option();
        option01.setId(1);
        option01.setAnswer(AnswerC.getAnswers());
        option01.setText("Аваза");

        Option option02 = new Option();
        option02.setId(2);
        option02.setAnswer(AnswerC.getAnswers());
        option02.setText("Мальдивы");

        Option option03 = new Option();
        option03.setId(3);
        option03.setAnswer(AnswerC.getAnswers());
        option03.setText("Москва");

        Option option04 = new Option();
        option04.setId(4);
        option04.setAnswer(AnswerC.getAnswers());
        option04.setText("Бали");

        result.add(option01);
        result.add(option02);
        result.add(option03);
        result.add(option04);

        return result;
    }


}
