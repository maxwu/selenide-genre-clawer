package me.maxwu.selenide;

import com.codeborne.selenide.WebDriverRunner;
import me.maxwu.selenide.pageObjects.BillboardTop100Page;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.baseUrl;
/**
 * Created by maxwu on 3/14/17.
 */
public class AppBase {
    static Logger logger = LoggerFactory.getLogger(AppBase.class.getName());
    WebDriver driver = null;

    public void checkDriver(){
        if (DriverFactory.hasQuit(driver)) {
            driver = DriverFactory.getChromeDriver();
            WebDriverRunner.setWebDriver(driver);
        }
    }

    public BillboardTop100Page onBillboardTop100Page() {
        checkDriver();
        baseUrl = "http://www.billboard.com/charts/hot-100";
        BillboardTop100Page page = open("/", BillboardTop100Page.class);
        return page;
    }

    public void quitDriver(){
        DriverFactory.quitDriver(driver);
        driver = null;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        quitDriver();
    }
}