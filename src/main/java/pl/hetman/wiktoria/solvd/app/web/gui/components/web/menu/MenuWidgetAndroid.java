package pl.hetman.wiktoria.solvd.app.web.gui.components.web.menu;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WomenPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.WhatsNewPage;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.WomenPage;

public class MenuWidgetAndroid extends MenuWidgetBase {

    @FindBy(id = "ui-id-3")
    private ExtendedWebElement whatsNewLink;

    @FindBy(id = "ui-id-4")
    private ExtendedWebElement womenPageButton;

    @FindBy(xpath = "//*[@id=\"ui-id-2\"]/li[2]/ul/li[1]/a")
    private ExtendedWebElement womenPageLink;

    public MenuWidgetAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
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
