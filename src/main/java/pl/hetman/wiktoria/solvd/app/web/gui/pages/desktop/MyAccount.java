package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.MyAccountPageBase;

public class MyAccount extends MyAccountPageBase {

    public MyAccount(WebDriver driver) {
        super(driver);
        setPageURL("customer/account/");
    }
}
