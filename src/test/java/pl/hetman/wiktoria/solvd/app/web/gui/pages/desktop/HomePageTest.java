package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.core.IAbstractTest;
import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.HomePageBase;

import static org.testng.Assert.*;

public class HomePageTest implements IAbstractTest {

    @Test
    public void testOpen() {

        WebDriver webDriver = new ChromeDriver();
        HomePageBase homePageBase = new HomePage(webDriver);

        //HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        homePageBase.open();
        Assert.assertTrue(homePageBase.isPageOpened(), "Home page is not opened!");

    }
}