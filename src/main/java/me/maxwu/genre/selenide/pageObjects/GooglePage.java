package me.maxwu.selenide.pageObjects;

import org.jetbrains.annotations.Contract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by maxwu on 3/14/17.
 */

public class GooglePage {
    static Logger logger = LoggerFactory.getLogger(GooglePage.class.getName());

    public GenreSearchPage getSearchFor(String text) {
        $("#lst-ib").val(text).pressEnter();
        logger.debug("search for \"" + text + "\"");
        return page(GenreSearchPage.class);
    }
}
