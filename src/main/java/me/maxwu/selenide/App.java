package me.maxwu.selenide;

import org.yaml.snakeyaml.Yaml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Configuration.screenshots;

/**
 * Created by maxwu on 3/15/17.
 */
public class App extends AppBase{

    Map<String, List<String>> map = new HashMap<>();

    public App() {
        List<String> songs = new ArrayList<String>();
        screenshots = false;
        onBillboardTop100Page().getTop100Map().values().stream().forEach(ls -> songs.add(ls.get(0)));
        songs.stream().forEach(song -> map.put(song, onGooglePage().getSearchFor(song).getGenres()));
        quitDriver();
    }

    public static void main(String[] args){
        System.out.println(new Yaml().dump(new App().map));
    }
}
