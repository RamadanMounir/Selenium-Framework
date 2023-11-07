package home;

import base.PageBase;
import extraPagesForHelpUs.ContactUsPage;
import extraPagesForHelpUs.NotebooksPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import registration.LoginPage;
import registration.MyAccountPage;
import registration.UserRegistrationPage;
import itemsDetails.SearchPage;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By  registerLink = By.linkText("Register");
    By loginLink = By.linkText("Log in");
    By logoutLink = By.linkText("Log out");
    By myAccountLink = By.linkText("My account");
    By searchBarField = By.id("small-searchterms");
    By searchBtn = By.xpath("//button[@type='submit']");
    By contactUsLink = By.cssSelector("a[href='/contactus']");
    By changeCurrency = By.id("customerCurrency");

    By computerMenuLink = By.linkText("Computers");
    By noteBookMenuLink = By.linkText("Notebooks");

    public UserRegistrationPage openRegistrationPage(){
        click(registerLink);
        return new UserRegistrationPage(driver);
    }
    public LoginPage openLoginPage(){
        click(loginLink);
        return new LoginPage(driver);
    }
    public NotebooksPage openNoteBookUsingHoverMenu(){
        actions =new Actions(driver);
        actions.moveToElement(driver.findElement(computerMenuLink))
                .build()
                .perform();
                actions.moveToElement(driver.findElement(noteBookMenuLink))
                .click()
                .build()
                .perform();
        return new NotebooksPage(driver);
    }
    public MyAccountPage openMyAccountLink(){
        click(myAccountLink);
        return new MyAccountPage(driver);
    }

    public SearchPage searchFor(String value){
        setText(searchBarField,value);
        click(searchBtn);
        return new SearchPage(driver);
    }
    public ContactUsPage openContactUs(){
        waitAndClick(contactUsLink);
        return new ContactUsPage(driver);
    }
    public void changeCurrency(String currency){
        select = new Select(driver.findElement(changeCurrency));
        select. selectByVisibleText(currency);
    }

    public String checkLogOutLinkVisibility(){
        return driver.findElement(logoutLink).getText();
    }
    public void logout(){
        click(logoutLink);
    }
    public void scrollToBottom(){

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,2500)","");
    }

}
