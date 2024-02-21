package pl.hetman.wiktoria.solvd.app.web.gui.pages.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.components.menu.MenuWidgetAndroid;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.MyAccountPageBase;

public class MyAccount extends MyAccountPageBase {

    @FindBy(css = "span.action.nav-toggle")
    private ExtendedWebElement widgetMenuButton;

    @FindBy(id = "store.menu")
    private MenuWidgetAndroid menuWidget;

    public MyAccount(WebDriver driver) {
        super(driver);
        setPageURL("customer/account/");
    }

    public HomePage logOut() {
        widgetMenuButton.click();
        menuWidget.accountButton();
        HomePage homePage = menuWidget.logOut();
        return homePage;
    }

    public ExtendedWebElement getWidgetMenuButton() {
        return widgetMenuButton;
    }

    public MenuWidgetAndroid getMenuWidget() {
        return menuWidget;
    }
}
