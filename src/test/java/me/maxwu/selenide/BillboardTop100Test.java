package me.maxwu.selenide;

import me.maxwu.selenide.pageObjects.BillboardTop100Page;
import org.junit.*;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by maxwu on 3/14/17.
 */
public class BillboardTop100Test extends AppBase {
    static Logger logger = LoggerFactory.getLogger(DriverFactory.class.getName());

    @After
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void testTop100Map(){
        Map<Integer, List<String>> map = onBillboardTop100Page().getTop100Map();
        Assert.assertEquals(100, map.size());
    }

    /**
    @Test @Ignore("deprecated")
    public void testTop100Songs(){
        List<String> songs = onBillboardTop100Page().getTop100SongNames();
        songs.stream().forEach(logger::info);
        Assert.assertEquals(100, songs.size());
    }

    @Test @Ignore("deprecated")
    public void testTop100Artists(){
        List<String> singers = onBillboardTop100Page().getTop100ArtistNames();
        singers.stream().forEach(logger::info);
        Assert.assertEquals(100, singers.size());
    }
    **/
}
