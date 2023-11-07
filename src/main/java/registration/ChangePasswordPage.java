package registration;

import base.PageBase;
import home.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends PageBase {
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }
    By oldPasswordField = By.id("OldPassword");
    By newPasswordField = By.id("NewPassword");
    By confirmNewPasswordField = By.id("ConfirmNewPassword");

    By changePasswordBtn = By.xpath("//button[normalize-space()='Change password']");
    By alert =By.xpath("//span[@title='Close']");
    By logOutLink = By.linkText("Log out");


    public void changePassword(String oldPassword, String newPassword){
        setText(oldPasswordField,oldPassword);
        setText(newPasswordField,newPassword);
        setText(confirmNewPasswordField,newPassword);
        click(changePasswordBtn);
    }
    public void closeAlert(){
        click(alert);
    }
    public HomePage logout(){
        waitAndClick(logOutLink);
       // click(logOutLink);
        return new HomePage(driver);
    }

    }






