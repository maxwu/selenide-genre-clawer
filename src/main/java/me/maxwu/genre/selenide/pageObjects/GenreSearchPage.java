package me.maxwu.selenide.pageObjects;

import com.codeborne.selenide.ex.ElementNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by maxwu on 3/15/17.
 */
public class GenreSearchPage {
    static Logger logger = LoggerFactory.getLogger(GenreSearchPage.class.getName());

    //getGenreDiv().should(exist);
    public List<String> getGenres(){
        List<String> genres;
        try{
            genres = Arrays.asList($("#rso div._uX div._XWk").getText().split("/"));
        }catch (ElementNotFound e){
            logger.info("Mark genre to NA due to error \n" + e.toString());
            genres = new ArrayList<>(Arrays.asList("NA"));
        }
        logger.debug(" >>> Genres: " + genres.stream().collect(Collectors.joining(", ")));
        return genres;
    }
}
