package workingWithDDT;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import registration.*;
import setUp.TestBase;

public class UserRegistrationTestWithDDTUsingDataProvider extends TestBase {
    UserRegistrationPage userReg;
    RegistrationResultsPage registrationResultsPageObj;
    LoginPage loginPageObj;
    MyAccountPage myAccountPageObj;
    ChangePasswordPage changePasswordPageObj;

    @DataProvider(name = "testData")
    public static Object[][] userData() {
        return new Object[][]{
                {"Ramadan", "Mazaly", "rr1@gmail.com", "123456","654321"},
                {"Romio"  , "Mounir", "tt1@gmail.com", "123456","654321"}
        };
    }

    @Test(dataProvider = "testData")
    public void testSuccessfulRegistrationTest(String firstName,String lastName,String email, String password,String newPassword){
        //1- user register
        userReg=homePageObj.openRegistrationPage();
        registrationResultsPageObj =
               userReg.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(registrationResultsPageObj
                       .getMessageResult()
                       .contains("Your registration completed"),"not correct message");
        homePageObj=registrationResultsPageObj.clickContinue();
        //2- user login
        loginPageObj = homePageObj.openLoginPage();
        homePageObj=loginPageObj.login(email,password);
        Assert.assertTrue(homePageObj.checkLogOutLinkVisibility().contains("Log out"),"not on home page");
        //3- user open My Account page
        myAccountPageObj= homePageObj.openMyAccountLink();
        changePasswordPageObj =  myAccountPageObj.openChangePasswordLink();
        //4-user change his password
        changePasswordPageObj.changePassword(password,newPassword);
        changePasswordPageObj.closeAlert();
        //5- user logout
        homePageObj = changePasswordPageObj.logout();
        //6- user loin with new password
        loginPageObj = homePageObj.openLoginPage();
        homePageObj = loginPageObj.login(email,newPassword);
        Assert.assertTrue(homePageObj.checkLogOutLinkVisibility().contains("Log out"),"not on home page");
        //7- user logout
        homePageObj.logout();
    }
}
