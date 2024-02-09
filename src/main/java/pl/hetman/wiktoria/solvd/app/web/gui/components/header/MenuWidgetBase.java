package pl.hetman.wiktoria.solvd.app.web.gui.components.header;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WhatsNewPageBase;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WomenPageBase;

public abstract class MenuWidgetBase extends AbstractUIObject {

    public MenuWidgetBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract WhatsNewPageBase openWhatsNewPage();

    public abstract WomenPageBase openWomenPage();
}
