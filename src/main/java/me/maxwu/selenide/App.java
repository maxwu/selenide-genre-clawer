package me.maxwu.selenide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxwu on 3/15/17.
 */
public class App extends AppBase{
    public List<String> getSongs() {
        return songs;
    }

    List<String> songs;

    public App() {
        for(List<String>  ls: onBillboardTop100Page().getTop100Map().values()){
            songs.add(ls.get(1));
        }
    }

    public static void main(String[] args){
        App app = new App();
        app.getSongs().stream().forEach(System.out::println);
    }
}
