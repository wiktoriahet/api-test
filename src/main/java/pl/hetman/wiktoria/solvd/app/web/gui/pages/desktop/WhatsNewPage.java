package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WhatsNewPageBase;

public class WhatsNewPage extends WhatsNewPageBase {

    public WhatsNewPage(WebDriver driver) {
        super(driver);
        setPageURL("what-is-new.html");
    }

}
