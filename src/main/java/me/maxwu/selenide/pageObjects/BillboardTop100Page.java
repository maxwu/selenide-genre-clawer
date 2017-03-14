package me.maxwu.selenide;

import java.util.List;

/**
 * Created by maxwu on 3/14/17.
 */
public class BillboardTop100Page {


    BillboardTop100Page(){

    }

    public List<String> getTop100List(){

        return null;
    }

    public static void main(String[] args){
        BillboardTop100Page bbPage = new BillboardTop100Page();
        System.out.println("Billboard Top100 List: <artist_name + track>");
        List<String> top100 = bbPage.getTop100List();
        top100.stream().forEach(System.out::println);
    }
}
