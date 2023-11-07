package registration;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegistrationPage extends PageBase {
    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }
    By genderRadioBtn = By.id("gender-male");
    By firstNameField = By.id("FirstName");
    By lastNameField  = By.id("LastName");
    By emailField     = By.id("Email");
    By passwordField  = By.id("Password");
    By confirmPasswordField = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");


    public RegistrationResultsPage userRegistration(String firstName , String lastName , String email , String password){
        click(genderRadioBtn);
        setText(firstNameField,firstName);
        setText(lastNameField,lastName);
        setText(emailField,email);
        setText(passwordField,password);
        setText(confirmPasswordField,password);
        click(registerBtn);
        return new RegistrationResultsPage(driver);
    }


}
