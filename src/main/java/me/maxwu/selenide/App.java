package me.maxwu.selenide;

import org.yaml.snakeyaml.Yaml;
import java.util.Map;
import java.util.stream.Collectors;
import static com.codeborne.selenide.Configuration.screenshots;

/**
 * Created by maxwu on 3/15/17.
 */
public class App extends GenreBase {

    Map<Integer, Map<String, Object>> map;

    public App() {
        screenshots = false;
        map = onBillboardTop100Page().getTop100Map();
        System.out.println("Got total " + map.size() + " songs");

        map.forEach(
                (k, v) -> v.put("genres",
                        "[" + getSongGenres(v.get("song").toString(), v.get("artist").toString()).stream().collect(Collectors.joining(",")) + "]"
                )
        );

        quitDriver();
    }

    public static void main(String[] args){
        System.out.println(new Yaml().dump(new App().map));
    }
}
