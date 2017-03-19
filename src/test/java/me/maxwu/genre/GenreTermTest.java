package me.maxwu.genre;

import me.maxwu.genre.GenreTerm;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by maxwu on 3/15/17.
 */
public class GenreTermTest {

    @Test
    public void testGenreList(){
        List<String> genres = GenreTerm.getGenreList();
        genres.stream().forEach(g -> System.out.println("<"+g+">"));
        Assert.assertEquals(126, genres.size());
    }
}
