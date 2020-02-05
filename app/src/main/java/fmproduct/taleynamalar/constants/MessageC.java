package fmproduct.taleynamalar.constants;

import java.util.ArrayList;

import fmproduct.taleynamalar.models.Message;

public class MessageC {

    public static ArrayList<Message> getMessages(){
        ArrayList<Message> result = new ArrayList<>();

        Message msg01 = new Message();
        msg01.setAdmin(0);
        msg01.setText("Salam admin");


        Message msg02 = new Message();
        msg02.setAdmin(1);
        msg02.setText("Naili brat");


        Message msg03 = new Message();
        msg03.setAdmin(0);
        msg03.setText("Gowy mana bir zat bir zat gerek");


        Message msg04 = new Message();
        msg04.setAdmin(1);
        msg04.setText("Mesele dal");


        result.add(msg01);
        result.add(msg02);
        result.add(msg03);
        result.add(msg04);

        return result;
    }
}
