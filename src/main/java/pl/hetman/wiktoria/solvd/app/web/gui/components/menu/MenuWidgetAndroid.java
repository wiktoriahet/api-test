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

    @FindBy(xpath = "/html/body/div[2]/div/div/div[4]/ul/li[2]/div/ul/li[3]")
    private ExtendedWebElement logOutButton;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[3]/a")
    private ExtendedWebElement accountButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[4]/ul/li[2]/a")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//*[@id=\"store.links\"]/ul/li[3]/a")
    private ExtendedWebElement createAccountButton;

    @FindBy(id = "ui-id-3")
    private ExtendedWebElement whatsNewLink;

    @FindBy(id = "ui-id-4")
    private ExtendedWebElement womenPageButton;

    @FindBy(xpath = "//*[@id=\"ui-id-2\"]/li[2]/ul/li[1]/a")
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
