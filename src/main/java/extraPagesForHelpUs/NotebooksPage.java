package extraPagesForHelpUs;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotebooksPage extends PageBase {
    public NotebooksPage(WebDriver driver) {
        super(driver);
    }
    By notebookTitle = By.cssSelector("div[class='page-title'] h1");
    public String getNotebookPageTitle(){
        return driver
                .findElement(notebookTitle)
                .getText();
    }
}
