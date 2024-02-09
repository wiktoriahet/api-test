package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.MyAccountPageBase;

public class MyAccount extends MyAccountPageBase {

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[5]/div[2]/div[1]/div[2]/a")
    private ExtendedWebElement editAdressButton;

    public MyAccount(WebDriver driver) {
        super(driver);
        setPageURL("customer/account/");
    }
}
