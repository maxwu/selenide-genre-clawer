package me.maxwu.selenide;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by maxwu on 3/15/17.
 */
public class GenreTest {

    @Test
    public void testGenreList(){
        List<String> genres = Genre.getGenreList();
        genres.stream().forEach(g -> System.out.println("<"+g+">"));
        Assert.assertEquals(126, genres.size());
    }
}
