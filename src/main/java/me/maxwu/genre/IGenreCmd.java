package me.maxwu.genre;

import java.util.List;

/**
 * Created by maxwu on 3/19/17.
 */

// TODO: Cache with invoked proxy
public interface IGenreCmd {
    List<String> getSongGenres(String song, String artist);
}
