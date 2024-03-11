package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
   @Test(priority = 1)
    public void loginPageNavigationTest(){
       loginPage=homePage.navigateToLoginPage();
       String actualLoginTitle=loginPage.getLoginPageTitle();
       Assert.assertEquals(actualLoginTitle, AppConstants.ACCOUNT_PAGE_TITLE);
    }
    @Test(priority = 2)
    public void forgotPwdLinkExistTest(){
       Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }
    @Test(priority = 3)
    public void appLoginTest() throws InterruptedException {
       loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

}
