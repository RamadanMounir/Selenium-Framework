package extraPage;

import extraPagesForHelpUs.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import setUp.TestBase;

public class ContactUsTest extends TestBase {
    String firstName = "Ramadan",lastName = "Mazaly",
            email = "r110066541fskk2@gmail.com";
    String message = "hello";
    ContactUsPage contactUsPageObj;
@Test
    public void testContactUsSuccessful(){
    homePageObj.scrollToBottom();
    contactUsPageObj =  homePageObj.openContactUs();
    contactUsPageObj.contactUs(firstName+" "+lastName,email,message);
    Assert.assertTrue(contactUsPageObj.getMessageResult().contains("Your enquiry has been successfully sent to the store owner.")
            ,"enquiry message not sent");

}
}
