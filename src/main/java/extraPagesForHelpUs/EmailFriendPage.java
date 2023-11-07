package extraPagesForHelpUs;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailFriendPage extends PageBase {
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    By friendEmailField = By.id("FriendEmail");
    By personalMessageField = By.id("PersonalMessage");
    By sendEmailBtn = By.xpath("//button[@name='send-email']");
    By messageResults = By.xpath("//div[@class='result']");

    public void sendEmailFriendMessage(String friendEmail,String Message){
        setText(friendEmailField,friendEmail);
        setText(personalMessageField,Message);
        click(sendEmailBtn);
    }
    public String getMessageResult(){
        return driver.findElement(messageResults).getText();
    }
}
