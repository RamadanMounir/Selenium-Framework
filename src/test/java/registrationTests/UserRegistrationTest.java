package registrationTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import registration.*;
import setUp.TestBase;

public class UserRegistrationTest extends TestBase {
    UserRegistrationPage userReg;
    RegistrationResultsPage registrationResultsPageObj;
    LoginPage loginPageObj;
    MyAccountPage myAccountPageObj;
    ChangePasswordPage changePasswordPageObj;
    String firstName = "Ramadan",lastName = "Mazaly",
            email = "rrrihllsf@degmail.com",password = "Ramadan123",newPassword="654321";
    /*
       @DataProvider(name = "testData")
    public static Object[][] userData(){
            return new Object[][]{
                    {"Ramadan","Mazaly","r@gmail.com","123456"},
                    {"Romio","Mounir","m@gmail.com","123456"}
                    };
            */

    @Test(priority = 0)
    public void testSuccessfulRegistrationTest(){

        userReg=homePageObj.openRegistrationPage();
        registrationResultsPageObj =
               userReg.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(registrationResultsPageObj
                       .getMessageResult()
                       .contains("Your registration completed"),"not correct message");
        homePageObj=registrationResultsPageObj.clickContinue();

    }

    @Test(priority = 1,dependsOnMethods ={"testSuccessfulRegistrationTest"})
    public void TestUserCanLoginSuccessful(){
         loginPageObj = homePageObj.openLoginPage();
         homePageObj=loginPageObj.login(email,password);
         Assert.assertTrue(homePageObj.checkLogOutLinkVisibility().contains("Log out"),"not on home page");
    }
    @Test(priority = 2)
    public void testChangePasswordSuccessful() {
        myAccountPageObj= homePageObj.openMyAccountLink();
        changePasswordPageObj =  myAccountPageObj.openChangePasswordLink();

         changePasswordPageObj.changePassword(password,newPassword);
         changePasswordPageObj.closeAlert();
         homePageObj = changePasswordPageObj.logout();
         loginPageObj = homePageObj.openLoginPage();
         homePageObj = loginPageObj.login(email,newPassword);
        Assert.assertTrue(homePageObj.checkLogOutLinkVisibility().contains("Log out"),"not on home page");
    }
    @Test(priority = 3)
    public void userCanLogoutSuccessfully(){
        homePageObj.logout();
    }
}
