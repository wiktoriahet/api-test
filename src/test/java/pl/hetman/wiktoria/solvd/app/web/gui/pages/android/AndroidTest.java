package pl.hetman.wiktoria.solvd.app.web.gui.pages.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.hetman.wiktoria.solvd.app.web.gui.components.web.search.SearchFieldAndroid;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WhatsNewPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WomenPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.SearchPage;

public class AndroidTest implements IAbstractTest {

    @Test(testName = "WhatsNewPageTest", description = "Verify if WhatsNewPage is opening correctly")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyOpenWhatsNewPageTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.clickWidgetButton();

        WhatsNewPageBase whatsNewPageBase = homePage.getWidgetMenu().openWhatsNewPage();
        Assert.assertTrue(whatsNewPageBase.isPageOpened(), "whatsNewPageBase is not opened");
    }

    @Test(testName = "WomenPageTest", description = "Verify if WomenPage is opening correctly")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyOpenWomenPageTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.clickWidgetButton();

        WomenPageBase womenPageBase = homePage.getWidgetMenu().openWomenPage();
        Assert.assertTrue(womenPageBase.isPageOpened(), "womenPageBase is not opened");
    }

    @Test(testName = "SearchFieldTest", description = "Verify if SearchField is working correctly")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifySearchFieldTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        String searchedItem = "bra";

        SearchFieldAndroid searchField = homePage.getSearchField();
        searchField.typeSearchInputValue(searchedItem);

        SearchPage searchPage = searchField.clickSearchButton();

        String partialUrl = "catalogsearch";

        Assert.assertTrue(getDriver().getCurrentUrl().contains(partialUrl), "The url doesn't contain the partialUrl");

    }

    @BeforeTest
    @Override
    public WebDriver getDriver() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "ANDROID");
        dc.setCapability("appium:automationName", "UiAutomator2");
        dc.setCapability("appium:deviceName", "Pixel_3");
        dc.setCapability("appium:deviceType", "phone");
        dc.setCapability("appium:udid", "emulator-5554");
        dc.setCapability("browserName", "chrome");
        dc.setCapability("chromedriverExecutable", "C:\\Users\\wikto\\Desktop\\JAVA\\selenium-server\\chromedriver.exe");
        return getDriver("default", dc, "http://192.168.56.1:4723/");
    }
}