package me.maxwu.genre.htmlUnit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import me.maxwu.genre.GenreTerm;
import me.maxwu.genre.IGenreCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static me.maxwu.genre.selenide.SelenideBase.keywordArtistGenre;
import static me.maxwu.genre.selenide.SelenideBase.keywordGenre;
import static me.maxwu.genre.selenide.SelenideBase.keywordSongGenre;

/**
 * Created by maxwu on 3/19/17.
 */
public class HtmlUnitBase implements IGenreCmd{
    static Logger logger = LoggerFactory.getLogger(HtmlUnitBase.class.getName());
    private WebClient webClient;

    HtmlUnitBase(){
        webClient = new WebClient(BrowserVersion.CHROME);
        // inhibit the tons of error messages with HtmlUnit and its JavaScript engine.
        webClient.setCssErrorHandler(new SilentCssErrorHandler());
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);
        webClient.setJavaScriptTimeout(4000);
    }

    @Override
    public List<String> getSongGenres(String song, String artist) {
        List<String> genres = searchGenreFor(keywordSongGenre(song));
        if (genres.get(0).equals("NA")){
            genres = searchGenreFor(keywordGenre(song));
        }
        if ((genres.get(0).equals("NA")) && (!artist.isEmpty())) {
            genres = searchGenreFor(keywordArtistGenre(song, artist));
        }
        return genres;
    }

    private WebClient getWebClient(){
        return this.webClient;
    }

    private List<String> searchGenreFor(String text) {
        String req = "https://www.google.com/search?q=" + text;
        List<String> genres;
        WebClient webClient = getWebClient();

        try {
            final HtmlPage page = webClient.getPage(req);
            HtmlDivision div = (HtmlDivision) page
                    .getByXPath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div[1]")
                    .get(0);
            String result = div.getTextContent();
            logger.debug("Query: [" + text + "] , return: [" + result + "]");

            genres = Arrays.asList(result.split("/"));
        }catch (IOException e){
            logger.warn("Failed to query with [" + text + "]: " + e.getMessage());
            genres = GenreTerm.getDefaultGenreList();
        }catch (IndexOutOfBoundsException e){
            // This keyword could not fetch genre directly.
            logger.info("Failed to query with [" + text + "]: " + e.getMessage());
            genres = GenreTerm.getDefaultGenreList();
        }
        finally {
            webClient.close();
        }
        return genres;
    }

    public static void main(String[] args){
        String song = "That's What I Like";
        String artist = "Bruno Mars";
        String genres = new HtmlUnitBase().getSongGenres(song, artist).stream().collect(Collectors.joining(", "));
    }
}
