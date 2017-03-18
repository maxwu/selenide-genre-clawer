package me.maxwu.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import me.maxwu.selenide.pageObjects.BillboardTop100Page;
import me.maxwu.selenide.pageObjects.GooglePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.baseUrl;
/**
 * Created by maxwu on 3/14/17.
 */
public class GenreAppBase {
    static Logger logger = LoggerFactory.getLogger(GenreAppBase.class.getName());
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

    public Map<Integer, Map<String, Object>> getBillboardTop100Map(){
        return getBillboardTop100Map(100);
    }

    public Map<Integer, Map<String, Object>> getBillboardTop100Map(int size){
        return onBillboardTop100Page().getTop100Map(size);
    }

    public GooglePage onGooglePage(){
       setDriver();
       baseUrl = "http://google.com";
       return open("/", GooglePage.class);
    }

    @org.jetbrains.annotations.Contract(pure = true)
    public static String keywordSongGenre(String song){
        return song + " song genre";
    }

    @org.jetbrains.annotations.Contract(pure = true)
    public static String keywordGenre(String song){
        return song + " genre";
    }

    @org.jetbrains.annotations.Contract(pure = true)
    public static String keywordArtistGenre(String song, String artist){
        return artist + " - " + song + " genre";
    }

    /**
     * The logic to fetch genre is:
     *  - Try "$song genre";
     *  - If NA, try "$song song genre", otherwise return genre list
     *  - Return genre list, for failed trial, return {"NA"}.
     * @param song
     * @return ArrayList of genre strings
     */
    public List<String> getSongGenres(String song, String artist){
        List<String> genres;
        genres = onGooglePage().getSearchFor(keywordSongGenre(song)).getGenres();
        if (genres.get(0).equals("NA")){
            genres = onGooglePage().getSearchFor(keywordGenre(song)).getGenres();
        }
        if ((genres.get(0).equals("NA")) && (!artist.isEmpty())) {
            genres = onGooglePage().getSearchFor(keywordArtistGenre(song, artist)).getGenres();
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