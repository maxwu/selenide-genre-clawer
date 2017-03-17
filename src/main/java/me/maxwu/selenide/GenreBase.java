package me.maxwu.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import me.maxwu.selenide.pageObjects.BillboardTop100Page;
import me.maxwu.selenide.pageObjects.GenreSearchPage;
import me.maxwu.selenide.pageObjects.GooglePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Configuration.screenshots;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.baseUrl;
/**
 * Created by maxwu on 3/14/17.
 */
public class AppBase {
    static Logger logger = LoggerFactory.getLogger(AppBase.class.getName());
    WebDriver driver = null;

    public void setDriver(){
        if (DriverFactory.hasQuit(driver)) {
            driver = DriverFactory.getChromeDriver();
            //driver = DriverFactory.getPhantomJsDriver();
            WebDriverRunner.setWebDriver(driver);
            Configuration.reportsFolder = "target";
        }
    }

    public BillboardTop100Page onBillboardTop100Page() {
        setDriver();
        baseUrl = "http://www.billboard.com/charts/hot-100";
        return open("/", BillboardTop100Page.class);
    }

    public GooglePage onGooglePage(){
       setDriver();
       baseUrl = "http://google.com";
       return open("/", GooglePage.class);
    }

    /**
     * The logic to fetch genre is:
     *  - Try "$song genre";
     *  - If NA, try "$song song genre", otherwise return genre list
     *  - Return genre list, for failed trial, return {"NA"}.
     * @param song
     * @return
     */
    public List<String> getSongGenres(String song){
        List<String> genres = new ArrayList<>(4);
        genres = onGooglePage().getSearchFor(GooglePage.keywordSongGenre(song)).getGenres();
        if (genres.get(0).equals("NA")){
            genres = onGooglePage().getSearchFor(GooglePage.keywordGenre(song)).getGenres();
        }
        return genres;
    }

    public static void quitDriver(){
        DriverFactory.quitDriver(WebDriverRunner.getWebDriver());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        quitDriver();
    }
}