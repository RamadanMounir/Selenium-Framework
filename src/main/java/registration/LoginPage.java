package registration;

import base.PageBase;
import home.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginBtn = By.cssSelector("button[class='button-1 login-button']");
    By welcomSigninMessage = By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']");

    public HomePage login(String email , String password){
        setText(emailField,email);
        setText(passwordField,password);
        click(loginBtn);
        return new HomePage(driver);
    }
    public String getWelcomeSigninMessage(){
        return driver.findElement(welcomSigninMessage)
                .getText();
    }

}
