package me.maxwu.selenide.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import me.maxwu.selenide.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$$;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by maxwu on 3/14/17.
 */
public class BillboardTop100Page {
    static Logger logger = LoggerFactory.getLogger(BillboardTop100Page.class.getName());

    private ElementsCollection getTop100Rows() {
        return $$(By.cssSelector("div.chart-row__main-display"));
    }

    public Map<Integer, List<String>> getTop100Map(){
        return getTop100Map(100);
    }

    public Map<Integer, List<String>> getTop100Map(int size){
        Map<Integer, List<String>> top100Map = new HashMap<Integer, List<String>>();
        for(WebElement rowDiv: getTop100Rows().stream().limit(size).collect(Collectors.toList())){
            ArrayList<String> rowList = new ArrayList<String>(3);
            String rank = rowDiv.findElement(By.cssSelector("span.chart-row__current-week")).getText().trim();
            logger.debug("rank : " + rank);
            String song = rowDiv.findElement(By.cssSelector("h2.chart-row__song")).getText().trim();
            logger.debug("song : " + song);
            String artist = rowDiv.findElement(By.cssSelector(".chart-row__artist")).getText().trim();
            logger.debug("artist : " + artist);
            rowList.add(song);
            rowList.add(artist);
            rowList.add("NA");
            top100Map.put(Integer.valueOf(rank), rowList);
        }
        logger.debug("total size is " + top100Map.size());
        return top100Map;
    }

    /**
    private ElementsCollection getTop100SongH2() {
        return $$(By.cssSelector("h2.chart-row__song"));
    }

    public List<String> getTop100SongNames() {
        return getTop100SongH2().stream().map(e -> e.getText().trim()).collect(Collectors.toList());
    }

    private ElementsCollection getTop100SongArtistsA() {
        return $$(By.cssSelector(".chart-row__artist"));
    }

    public List<String> getTop100ArtistNames() {
        return getTop100SongArtistsA().stream().map(e -> e.getText().trim()).collect(Collectors.toList());
    }
     **/
}
