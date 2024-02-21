package pl.hetman.wiktoria.solvd.app.web.gui.components.menu;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.android.CreateAccountPage;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.android.HomePage;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WomenPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.android.SignInPage;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.WhatsNewPage;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.WomenPage;

public class MenuWidgetAndroid extends MenuWidgetBase {

    @FindBy(xpath = "(//ul/li[@class=\"authorization-link\"])[3]")
    private ExtendedWebElement logOutButton;

    @FindBy(xpath = "(//div/a[@class=\"nav-sections-item-switch\"])[2]")
    private ExtendedWebElement accountButton;

    @FindBy(xpath = "(//li/a[@href=\"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/\"])[2]")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "(//li/a[@href=\"https://magento.softwaretestingboard.com/customer/account/create/\"])[2]")
    private ExtendedWebElement createAccountButton;

    @FindBy(id = "ui-id-3")
    private ExtendedWebElement whatsNewLink;

    @FindBy(id = "ui-id-4")
    private ExtendedWebElement womenPageButton;

    @FindBy(className = "ui-state-focus")
    private ExtendedWebElement womenPageLink;

    public MenuWidgetAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CreateAccountPage createAccount(){
        accountButton.click();
        createAccountButton.click();
        return new CreateAccountPage(getDriver());
    }

    public SignInPage signIn(){
        signInButton.click();
        return new SignInPage(getDriver());
    }

    public void accountButton(){
        accountButton.click();
    }

    public HomePage logOut() {
        logOutButton.click();
        return new HomePage(getDriver());
    }

    @Override
    public WhatsNewPage openWhatsNewPage() {
        whatsNewLink.click();
        return new WhatsNewPage(driver);
    }

    @Override
    public WomenPageBase openWomenPage() {
        womenPageButton.click();
        womenPageLink.click();
        return new WomenPage(driver);
    }
}
