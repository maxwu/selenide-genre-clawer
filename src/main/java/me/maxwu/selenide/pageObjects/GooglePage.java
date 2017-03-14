package me.maxwu.selenide.pageObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by maxwu on 3/14/17.
 */

public class GooglePage {

    public GenreSearchPage searchFor(String text) {
        $("#lst-ib").val(text).pressEnter();
        return page(GenreSearchPage.class);
    }
}
