package fmproduct.taleynamalar.constants;

import java.util.ArrayList;

import fmproduct.taleynamalar.models.User;

public class UserC {

    public static User getUser01(){
        User u01 = new User();
        u01.setName("Aybolek");
        u01.setId(1);
        u01.setPhone("+993677777777");
        return u01;
    }

    public static User getUser02() {
        User u02 = new User();
        u02.setId(2);
        u02.setName("Merjen");
        u02.setPhone("+99365555555");
        return u02;
    }

    public static User getUser03(){
        User u03 = new User();
        u03.setId(3);
        u03.setName("Aylar");
        u03.setPhone("+99366666666");
        return u03;
    }

    public static ArrayList<User> getUsers(){
        ArrayList<User> result = new ArrayList<>();

        User u01 = new User();
        u01.setName("Aybolek");
        u01.setId(1);
        u01.setPhone("+993677777777");

        User u02 = new User();
        u02.setId(2);
        u02.setName("Merjen");
        u02.setPhone("+99365555555");

        User u03 = new User();
        u03.setId(3);
        u03.setName("Aylar");
        u03.setPhone("+99366666666");



        result.add(u01);
        result.add(u02);
        result.add(u03);

        return result;
    }
}
