package me.maxwu.genre.search;

import me.maxwu.genre.IGenreCmd;
import me.maxwu.genre.IGenreKeyword;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by maxwu on 3/21/17.
 */
public class GoogleKeyword implements IGenreKeyword{

    public String getDelimiter(){
        return "/";
    }

    public <T> List<T> getKeyWordList(String song, String artist){
        return null;
    }
}
