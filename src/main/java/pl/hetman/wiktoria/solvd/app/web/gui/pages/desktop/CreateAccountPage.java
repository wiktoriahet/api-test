package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.CreateAccountPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.MyAccountPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CreateAccountPageBase.class)
public class CreateAccountPage extends CreateAccountPageBase {

    @FindBy(id = "firstname")
    private ExtendedWebElement firstNameField;

    @FindBy(id = "lastname")
    private ExtendedWebElement lastNameField;

    @FindBy(id = "email_address")
    private ExtendedWebElement emailField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "password-confirmation")
    private ExtendedWebElement confirmPasswordField;

    @FindBy(xpath = "(//div[@class=\"primary\"]/button[@type=\"submit\"])[1]")
    private ExtendedWebElement createAccountButton;

    @FindBy(id = "password-confirmation-error")
    private ExtendedWebElement errorField;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        setPageURL("customer/account/create/");
    }

    public MyAccountPageBase createAccount(String firstName, String lastName, String email, String password, String confirmPassword){
        firstNameField.type(firstName);
        lastNameField.type(lastName);
        emailField.type(email);
        passwordField.type(password);
        confirmPasswordField.type(confirmPassword);
        createAccountButton.click();
        return new MyAccount(driver);
    }

    public ExtendedWebElement getFirstNameField() {
        return firstNameField;
    }

    public ExtendedWebElement getLastNameField() {
        return lastNameField;
    }

    public ExtendedWebElement getEmailField() {
        return emailField;
    }

    public ExtendedWebElement getPasswordField() {
        return passwordField;
    }

    public ExtendedWebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public ExtendedWebElement getCreateAccountButton() {
        return createAccountButton;
    }

    public ExtendedWebElement getErrorField() {
        return errorField;
    }
}
