package registration;

import base.PageBase;
import home.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationResultsPage extends PageBase {

    public RegistrationResultsPage(WebDriver driver) {
        super(driver);
    }
    By continueBtn = By.xpath("//a[@class='button-1 register-continue-button']");
    By messageResult  = By.xpath("//div[@class='result']");

    public String getMessageResult(){
        return driver.findElement(messageResult)
                .getText();
    }

    public HomePage clickContinue(){
        click(continueBtn);
        return new HomePage(driver);
    }
}
