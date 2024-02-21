package pl.hetman.wiktoria.solvd.app.web.gui.pages.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.ForgotPasswordPageBase;

public class ForgotPasswordPage extends ForgotPasswordPageBase {

    @FindBy(id = "email_address")
    private ExtendedWebElement emailField;

    @FindBy(css = "button.action.submit.primary")
    private ExtendedWebElement resetPasswordButton;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        setPageURL("customer/account/forgotpassword/");
    }

    public SignInPage resetPassword(String email) {
        emailField.type(email);
        resetPasswordButton.click();
        return new SignInPage(getDriver());
    }

    public ExtendedWebElement getEmailField() {
        return emailField;
    }
}
