package pl.hetman.wiktoria.solvd.app.web.gui.components.menu;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WomenPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.WhatsNewPage;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop.WomenPage;

public class MenuWidget extends MenuWidgetBase {

    @FindBy(xpath = "//*[@id=\"ui-id-2\"]/li[1]")
    private ExtendedWebElement whatsNewLink;

    @FindBy(xpath = "//*[@id=\"ui-id-4\"]/span[2]")
    private ExtendedWebElement womenPageLink;

    public MenuWidget(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public WhatsNewPage openWhatsNewPage() {
        whatsNewLink.click();
        return new WhatsNewPage(driver);
    }

    @Override
    public WomenPageBase openWomenPage() {
        womenPageLink.scrollTo();
        womenPageLink.hover();
        womenPageLink.click();
        return new WomenPage(driver);
    }
}
