package pl.hetman.wiktoria.solvd.app.web.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.SignInPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @FindBy(css = "div.page.messages")
    private ExtendedWebElement errorMessage;

    @FindBy(id = "email")
    private ExtendedWebElement emailField;

    @FindBy(id="pass")
    private ExtendedWebElement passwordField;

    @FindBy(id="send2")
    private ExtendedWebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        setPageURL("customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
    }

    public HomePage signIn(String email, String password){
        emailField.type(email);
        passwordField.type(password);
        signInButton.click();
        signInButton.click();
        return new HomePage(driver);
    }

    public ExtendedWebElement getErrorMessage() {
        return errorMessage;
    }

    public ExtendedWebElement getEmailField() {
        return emailField;
    }

    public ExtendedWebElement getPasswordField() {
        return passwordField;
    }

    public ExtendedWebElement getSignInButton() {
        return signInButton;
    }
}
