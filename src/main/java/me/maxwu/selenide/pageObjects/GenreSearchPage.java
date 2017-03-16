package me.maxwu.selenide.pageObjects;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;

/**
 * Created by maxwu on 3/15/17.
 */
public class GenreSearchPage {
    static Logger logger = LoggerFactory.getLogger(GenreSearchPage.class.getName());

    private SelenideElement getGenreDiv(){
        return $("#rso div._uX div._XWk");
    }

    //getGenreDiv().should(exist);
    public List<String> getGenres(){
        List<String> genres;
        try{
            genres = Arrays.asList(getGenreDiv().getText().split("/"));
        }catch (ElementNotFound e){
            logger.error("Mark genre to NA due to error:\n" + e.toString());
            genres = new ArrayList<>(Arrays.asList("NA"));
        }
        logger.debug("## Genres are: " + genres.stream().collect(Collectors.joining(", ")));
        return genres;
    }
}
