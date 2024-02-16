package pl.hetman.wiktoria.solvd.app.web.gui.pages.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.hetman.wiktoria.solvd.app.web.gui.components.menu.MenuWidgetAndroid;
import pl.hetman.wiktoria.solvd.app.web.gui.components.search.SearchFieldAndroid;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WhatsNewPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WomenPageBase;

public class AndroidTest implements IAbstractTest {

    @DataProvider(name = "accountData")
    public Object[][] createAccountData() {
        return new Object[][]{
                {"Anna", "Nowak", "anna@no14.com", "alfabet1@", "alfabet1@"},
                {"Anna", "Nowak", "anna@no8.com", "alfabet1@", "alfabet1#"},
                {"Anna", "Nowak", "anna@no9.com", "alfabet1%", "alfabet1@"}
        };
    }

    @DataProvider(name = "signInData")
    public Object[][] signInData() {
        return new Object[][]{
                {"anna@no4.com", "alfabet1@"},
                {"anna@no4.com", "alfabet1"},
                {"anna@no4.com", "alfabet1#"}
        };
    }

    @DataProvider(name = "emailData")
    public Object[][] emailData() {
        return new Object[][]{
                {"anna@no4.com"},
                //{"anna@no5.com"},
                //{"anna@no6.com"}
        };
    }

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

    @Test(testName = "CreateAccountAndLogoutTest", description = "Verify if CreateAccount and Logout is working correctly", dataProvider = "accountData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyCreateAccountAndLogoutTest(String firstName, String lastName, String email, String password, String confirmPassword) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.clickWidgetButton();
        CreateAccountPage createAccountPage = homePage.getWidgetMenu().createAccount();

        Assert.assertTrue(createAccountPage.isPageOpened(), "account page is not opened");

        MyAccount accountPage = createAccountPage.createAccount(firstName, lastName, email, password, confirmPassword);

        SoftAssert sa = new SoftAssert();

        if (password.equals(confirmPassword)) {
            Assert.assertTrue(accountPage.isPageOpened(), "accountPage is not opened");
        } else {
            Assert.assertTrue(createAccountPage.getErrorField().isDisplayed(), "errorField is not displayed");
        }

        if (accountPage.isPageOpened()) {
            HomePage homePageAfterLogOut = accountPage.logOut();
            sa.assertTrue(homePageAfterLogOut.isPageOpened(20), "homePageAfterLogOut is not opened");
        }
        sa.assertAll();
    }

    @Test(testName = "SignInAndLogoutTest", description = "Verify if SignIn and Logout is working correctly", dataProvider = "signInData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifySignInAndLogoutTest(String email, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.clickWidgetButton();

        MenuWidgetAndroid widgetMenu = homePage.getWidgetMenu();
        widgetMenu.accountButton();
        SignInPage signInPage = widgetMenu.signIn();
        HomePage homePageAfterSignIn = signInPage.signIn(email, password);

        String correctPassword = "alfabet1@";

        SoftAssert sa = new SoftAssert();

        if (password.equals(correctPassword)) {
            sa.assertTrue(homePageAfterSignIn.isPageOpened(), "homePageAfterSignIn is not opened");

            homePageAfterSignIn.clickWidgetButton();

            MenuWidgetAndroid widgetMenuAfterSignIn = homePageAfterSignIn.getWidgetMenu();
            widgetMenuAfterSignIn.accountButton();

            HomePage homePageAfterLogOut = widgetMenuAfterSignIn.logOut();

            sa.assertTrue(homePageAfterLogOut.isPageOpened(20), "homePageAfterLogOut is not opened");
            sa.assertAll();

        } else {
            sa.assertTrue(signInPage.getErrorMessage().isDisplayed(), "Error message is not displayed");
            sa.assertAll();
        }
    }

    @Test(testName = "ForgotPasswordTest", description = "Verify if forgot password is working correctly", dataProvider = "emailData")
    @MethodOwner(owner = "Wiktoria")
    @TestPriority(Priority.P1)
    public void verifyForgotPasswordTest(String email) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.clickWidgetButton();

        MenuWidgetAndroid widgetMenu = homePage.getWidgetMenu();
        widgetMenu.accountButton();
        SignInPage signInPage = widgetMenu.signIn();

        ForgotPasswordPage forgotPasswordPage = signInPage.signInForgotPassword();

        Assert.assertTrue(forgotPasswordPage.isPageOpened(), "forgotPasswordPage is not opened");

        forgotPasswordPage.resetPassword(email);

        String partialUrl = "referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2luZGV4Lw%2C%2C/";

        Assert.assertTrue(getDriver().getCurrentUrl().contains(partialUrl), "signInPageAfterReset is not opened");
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