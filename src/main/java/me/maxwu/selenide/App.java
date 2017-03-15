package me.maxwu.selenide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxwu on 3/15/17.
 */
public class App extends AppBase{
    List<String> songs = new ArrayList<String>();

    public List<String> getSongs() {
        return songs;
    }

    public App() {
        onBillboardTop100Page().getTop100Map().values().stream().forEach(ls -> songs.add(ls.get(0)));
    }

    public static void main(String[] args){
        App app = new App();
        app.getSongs().stream().forEach(System.out::println);
    }
}
