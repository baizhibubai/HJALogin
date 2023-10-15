package org.baizhi.hjalogin;

import java.util.ArrayList;

public class LoginData {
    public static ArrayList<String> RESTRICT = new ArrayList<>();
    public static boolean isNull(){
        return RESTRICT.isEmpty();
    }
    public static void addList(String name){
        String nametolow = name.toLowerCase();
        if (!(RESTRICT.contains(nametolow))){
            RESTRICT.add(nametolow);
        }
    }
    public static void removeList(String name){
        String nametolow = name.toLowerCase();
        if (RESTRICT.contains(nametolow)){
            RESTRICT.remove(nametolow);
        }
    }
    public static boolean hasList(String name){
        String nametolow = name.toLowerCase();
        return RESTRICT.contains(nametolow);
    }

}
