package me.maxwu.selenide;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by maxwu on 3/15/17.
 */
public class BillboardTop100GenreTest  extends AppBase {
    @After
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void testTop10Genres(){
        Map<Integer, List<String>> map = onBillboardTop100Page().getTop100Map(10);
        Assert.assertEquals(10, map.size());
    }
}
