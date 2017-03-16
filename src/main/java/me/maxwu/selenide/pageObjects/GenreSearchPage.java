package me.maxwu.selenide.pageObjects;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
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
        SelenideElement div = null;
        try {
            div = $("#rso div._uX div._XWk");
        }catch (Exception e) {
            screenshot(
                    new java.text.SimpleDateFormat("yyyy-MM-dd-HH_mm_ss")
                            .format(new java.util.Date())
            );
            div = new SelenideElement() {
                @Override
                public void followLink() {

                }

                @Override
                public SelenideElement setValue(String text) {
                    return null;
                }

                @Override
                public SelenideElement val(String text) {
                    return null;
                }

                @Override
                public SelenideElement append(String text) {
                    return null;
                }

                @Override
                public SelenideElement pressEnter() {
                    return null;
                }

                @Override
                public SelenideElement pressTab() {
                    return null;
                }

                @Override
                public SelenideElement pressEscape() {
                    return null;
                }

                @Override
                public String getText() {
                    return "NA";
                }

                @Override
                public String text() {
                    return "NA";
                }

                @Override
                public String innerText() {
                    return null;
                }

                @Override
                public String innerHtml() {
                    return null;
                }

                @Override
                public String attr(String attributeName) {
                    return null;
                }

                @Override
                public String name() {
                    return null;
                }

                @Override
                public String val() {
                    return null;
                }

                @Override
                public String getValue() {
                    return null;
                }

                @Override
                public SelenideElement selectRadio(String value) {
                    return null;
                }

                @Override
                public String data(String dataAttributeName) {
                    return null;
                }

                @Override
                public boolean exists() {
                    return false;
                }

                @Override
                public boolean isDisplayed() {
                    return false;
                }

                @Override
                public boolean is(Condition condition) {
                    return false;
                }

                @Override
                public boolean has(Condition condition) {
                    return false;
                }

                @Override
                public SelenideElement setSelected(boolean selected) {
                    return null;
                }

                @Override
                public SelenideElement should(Condition... condition) {
                    return null;
                }

                @Override
                public SelenideElement shouldHave(Condition... condition) {
                    return null;
                }

                @Override
                public SelenideElement shouldBe(Condition... condition) {
                    return null;
                }

                @Override
                public SelenideElement shouldNot(Condition... condition) {
                    return null;
                }

                @Override
                public SelenideElement shouldNotHave(Condition... condition) {
                    return null;
                }

                @Override
                public SelenideElement shouldNotBe(Condition... condition) {
                    return null;
                }

                @Override
                public SelenideElement waitUntil(Condition condition, long timeoutMilliseconds) {
                    return null;
                }

                @Override
                public SelenideElement waitUntil(Condition condition, long timeoutMilliseconds, long pollingIntervalMilliseconds) {
                    return null;
                }

                @Override
                public SelenideElement waitWhile(Condition condition, long timeoutMilliseconds) {
                    return null;
                }

                @Override
                public SelenideElement waitWhile(Condition condition, long timeoutMilliseconds, long pollingIntervalMilliseconds) {
                    return null;
                }

                @Override
                public SelenideElement parent() {
                    return null;
                }

                @Override
                public SelenideElement closest(String tagOrClass) {
                    return null;
                }

                @Override
                public SelenideElement find(String cssSelector) {
                    return null;
                }

                @Override
                public SelenideElement find(String cssSelector, int index) {
                    return null;
                }

                @Override
                public SelenideElement find(By selector) {
                    return null;
                }

                @Override
                public SelenideElement find(By selector, int index) {
                    return null;
                }

                @Override
                public SelenideElement $(String cssSelector) {
                    return null;
                }

                @Override
                public SelenideElement $(String cssSelector, int index) {
                    return null;
                }

                @Override
                public SelenideElement $(By selector) {
                    return null;
                }

                @Override
                public SelenideElement $(By selector, int index) {
                    return null;
                }

                @Override
                public ElementsCollection findAll(String cssSelector) {
                    return null;
                }

                @Override
                public ElementsCollection findAll(By selector) {
                    return null;
                }

                @Override
                public ElementsCollection $$(String cssSelector) {
                    return null;
                }

                @Override
                public ElementsCollection $$(By selector) {
                    return null;
                }

                @Override
                public File uploadFromClasspath(String... fileName) {
                    return null;
                }

                @Override
                public File uploadFile(File... file) {
                    return null;
                }

                @Override
                public void selectOption(int... index) {

                }

                @Override
                public void selectOption(String... text) {

                }

                @Override
                public void selectOptionContainingText(String text) {

                }

                @Override
                public void selectOptionByValue(String... value) {

                }

                @Override
                public SelenideElement getSelectedOption() throws NoSuchElementException {
                    return null;
                }

                @Override
                public ElementsCollection getSelectedOptions() {
                    return null;
                }

                @Override
                public String getSelectedValue() {
                    return null;
                }

                @Override
                public String getSelectedText() {
                    return null;
                }

                @Override
                public SelenideElement scrollTo() {
                    return null;
                }

                @Override
                public File download() throws FileNotFoundException {
                    return null;
                }

                @Override
                public WebElement toWebElement() {
                    return null;
                }

                @Override
                public WebElement getWrappedElement() {
                    return null;
                }

                @Override
                public void click() {

                }

                @Override
                public SelenideElement contextClick() {
                    return null;
                }

                @Override
                public SelenideElement doubleClick() {
                    return null;
                }

                @Override
                public SelenideElement hover() {
                    return null;
                }

                @Override
                public SelenideElement dragAndDropTo(String targetCssSelector) {
                    return null;
                }

                @Override
                public SelenideElement dragAndDropTo(WebElement target) {
                    return null;
                }

                @Override
                public boolean isImage() {
                    return false;
                }

                @Override
                public File screenshot() {
                    return null;
                }

                @Override
                public BufferedImage screenshotAsImage() {
                    return null;
                }

                @Override
                public void submit() {

                }

                @Override
                public void sendKeys(CharSequence... keysToSend) {

                }

                @Override
                public void clear() {

                }

                @Override
                public String getTagName() {
                    return null;
                }

                @Override
                public String getAttribute(String name) {
                    return null;
                }

                @Override
                public boolean isSelected() {
                    return false;
                }

                @Override
                public boolean isEnabled() {
                    return false;
                }

                @Override
                public List<WebElement> findElements(By by) {
                    return null;
                }

                @Override
                public WebElement findElement(By by) {
                    return null;
                }

                @Override
                public Point getLocation() {
                    return null;
                }

                @Override
                public Dimension getSize() {
                    return null;
                }

                @Override
                public Rectangle getRect() {
                    return null;
                }

                @Override
                public String getCssValue(String propertyName) {
                    return null;
                }

                @Override
                public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
                    return null;
                }

                @Override
                public WebElement findElementByClassName(String using) {
                    return null;
                }

                @Override
                public List<WebElement> findElementsByClassName(String using) {
                    return null;
                }

                @Override
                public WebElement findElementByCssSelector(String using) {
                    return null;
                }

                @Override
                public List<WebElement> findElementsByCssSelector(String using) {
                    return null;
                }

                @Override
                public WebElement findElementById(String using) {
                    return null;
                }

                @Override
                public List<WebElement> findElementsById(String using) {
                    return null;
                }

                @Override
                public WebElement findElementByLinkText(String using) {
                    return null;
                }

                @Override
                public List<WebElement> findElementsByLinkText(String using) {
                    return null;
                }

                @Override
                public WebElement findElementByPartialLinkText(String using) {
                    return null;
                }

                @Override
                public List<WebElement> findElementsByPartialLinkText(String using) {
                    return null;
                }

                @Override
                public WebElement findElementByName(String using) {
                    return null;
                }

                @Override
                public List<WebElement> findElementsByName(String using) {
                    return null;
                }

                @Override
                public WebElement findElementByTagName(String using) {
                    return null;
                }

                @Override
                public List<WebElement> findElementsByTagName(String using) {
                    return null;
                }

                @Override
                public WebElement findElementByXPath(String using) {
                    return null;
                }

                @Override
                public List<WebElement> findElementsByXPath(String using) {
                    return null;
                }

                @Override
                public Coordinates getCoordinates() {
                    return null;
                }

                @Override
                public WebDriver getWrappedDriver() {
                    return null;
                }
            };
        }
        return div;
    }
    public List<String> getGenres(){
        //List<String> genres = Arrays.asList(getGenreDiv().getText().split("/"));
        List<String> genres;
        try{
            getGenreDiv().should(exist);
            genres = Arrays.asList(getGenreDiv().text().split("/"));
        }catch (Exception e){
            genres = new ArrayList<>(Arrays.asList("NA"));
        }
        logger.debug("Genres are: " + genres.stream().collect(Collectors.joining()));
        return genres;
    }
}
