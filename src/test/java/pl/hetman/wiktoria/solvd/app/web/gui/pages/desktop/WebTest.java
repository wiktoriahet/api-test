package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.HomePageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WhatsNewPageBase;

public class WebTest implements IAbstractTest {

    @Test(testName = "WhatsNewPageTest", description = "Verify if WhatsNewPage is opening correctly")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyOpenWhatsNewPageTest() {

        WebDriver webDriver = new ChromeDriver();
        HomePageBase homePageBase = new HomePage(webDriver);

        homePageBase.open();
        Assert.assertTrue(homePageBase.isPageOpened(), "Home page is not opened!");

        WhatsNewPageBase whatsNewPageBase = homePageBase.getHeaderMenu().openWhatsNewPage();
        Assert.assertTrue(whatsNewPageBase.isPageOpened(), "whatsNewPageBase is not opened" );

    }
}