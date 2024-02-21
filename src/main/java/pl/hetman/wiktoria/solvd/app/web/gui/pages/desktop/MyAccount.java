package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.MyAccountPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = MyAccountPageBase.class)
public class MyAccount extends MyAccountPageBase {

    @FindBy(css = "a.action.edit")
    private ExtendedWebElement editAdressButton;

    public MyAccount(WebDriver driver) {
        super(driver);
        setPageURL("customer/account/");
    }
}
