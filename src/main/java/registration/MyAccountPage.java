package registration;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    By changePasswordLink = By.linkText("Change password");
    public ChangePasswordPage openChangePasswordLink(){
        click(changePasswordLink);
        return new ChangePasswordPage(driver);
    }


}
