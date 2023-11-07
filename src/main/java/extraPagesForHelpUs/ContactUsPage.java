package extraPagesForHelpUs;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends PageBase {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    By nameField = By.id("FullName");
    By emailField = By.id("Email");
    By enquiryField = By.id("Enquiry");
    By submitBtn = By.xpath("//button[@name='send-email']");
    By resultMessage = By.xpath("//div[@class='result']");

    public void contactUs(String name, String email ,String message){
        setText(nameField,name);
        setText(emailField,email);
        setText(enquiryField,message);
        click(submitBtn);
    }

    public String getMessageResult(){
        return driver.findElement(resultMessage).getText();
    }


}

