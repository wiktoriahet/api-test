package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.hetman.wiktoria.solvd.app.web.gui.components.Product;
import pl.hetman.wiktoria.solvd.app.web.gui.components.search.SearchFieldBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.HomePageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WhatsNewPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WomenPageBase;

import java.util.List;

public class WebTest implements IAbstractTest {

    @Test(testName = "WhatsNewPageTest", description = "Verify if WhatsNewPage is opening correctly")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyOpenWhatsNewPageTest() {

        WebDriver webDriver = new ChromeDriver();
        HomePageBase homePageBase = new HomePage(webDriver);

        homePageBase.open();
        Assert.assertTrue(homePageBase.isPageOpened(), "Home page is not opened!");

        WhatsNewPageBase whatsNewPageBase = homePageBase.getWidgetMenu().openWhatsNewPage();
        Assert.assertTrue(whatsNewPageBase.isPageOpened(), "whatsNewPageBase is not opened" );
    }

    @Test(testName = "WomenPageTest", description = "Verify if WomanPage is opening correctly")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyOpenWomanPageTest() {

        WebDriver webDriver = new ChromeDriver();
        HomePageBase homePageBase = new HomePage(webDriver);

        homePageBase.open();
        Assert.assertTrue(homePageBase.isPageOpened(), "Home page is not opened!");

        WomenPageBase womenPageBase = homePageBase.getWidgetMenu().openWomenPage();
        Assert.assertTrue(womenPageBase.isPageOpened(), "whatsNewPageBase is not opened" );
    }

    @Test(testName = "SearchFieldTest", description = "Verify if SearchFieldTest is working correctly")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifySearchFieldTest() {

        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);

        homePage.open();
        //Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        String input = "bra";
        String partialUrl = "catalogsearch";

        SearchFieldBase searchField = homePage.getSearchField();
        searchField.typeSearchInputValue(input);
        SearchPage searchPage = searchField.clickSearchButton();

        Assert.assertTrue(webDriver.getCurrentUrl().contains(partialUrl), "The url doesn't contain the partialUrl");

        List<Product> products = searchPage.getProducts();

        for (Product product : products) {
            Assert.assertTrue(product.getTitleText().toLowerCase().contains(input));
        }
    }

    }
