package me.maxwu.selenide.pageObjects;


import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by maxwu on 3/15/17.
 */
public class GenreSearchPage {
    private WebElement getGenreDiv(){
        return $("#rso div._uX div._XWk");
    }
    public List<String> getGenre(){
        return Arrays.asList(getGenreDiv().getText().split("/"));
    }
}
