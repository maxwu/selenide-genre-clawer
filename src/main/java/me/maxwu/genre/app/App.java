package me.maxwu.genre.app;

import me.maxwu.genre.selenide.SelenideBase;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Configuration.screenshots;

/**
 * Created by maxwu on 3/15/17.
 */
public class App extends SelenideBase {
    Map<Integer, Map<String, Object>> map;

    public App() {
        screenshots = false;
        map = this.getBillboardTop100Map(10);
        System.out.println("Got total " + map.size() + " songs");

        map.forEach((k, v) -> v.put("genres", getSongGenres(v.get("song").toString(), v.get("artist").toString())));
        quitDriver();
    }

    public static void main(String[] args){
        Map<Integer, Map<String, Object>> map = new App().map;
        System.out.println(new Yaml().dump(map));
        System.out.printf("Success rate = %.2f% \n",
                ( map.values().parallelStream()
                        .filter(v -> !((List<String>)v.get("genres")).get(0).equals("NA"))
                        .count() + 0.0)*100.0/(map.size())
        );
    }
}
