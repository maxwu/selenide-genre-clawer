package me.maxwu.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by maxwu on 3/15/17.
 */
public class BillboardTop100GenreTest  extends AppBase {
    // Make screenshot on every case
    // @Rule
    // public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();

    @Rule
    public BillboardTop100Watcher top100Rule = new BillboardTop100Watcher();

    @AfterClass
    public static void tearDown(){
        quitDriver();
    }


    @Test
    public void testTop10Genres(){
        Map<Integer, List<String>> map = onBillboardTop100Page().getTop100Map(10);
        List<String> songs = map.values().stream().map(ls -> ls.get(0)).collect(Collectors.toList());
        //songs.stream().forEach(System.out::println);

        for(String song: songs){
            List<String> genres = onGooglePage().getSearchFor(song).getGenres();
            System.out.println(song + ":" + genres.stream().collect(Collectors.joining()));
        }
    }
}
