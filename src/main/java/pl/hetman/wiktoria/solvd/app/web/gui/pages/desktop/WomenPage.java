package pl.hetman.wiktoria.solvd.app.web.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import pl.hetman.wiktoria.solvd.app.web.gui.pages.common.WomenPageBase;

public class WomenPage extends WomenPageBase {

    public WomenPage(WebDriver driver) {
        super(driver);
        setPageURL("women.html");
    }
}
