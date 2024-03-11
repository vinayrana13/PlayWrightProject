package com.qa.opencart.tests;
import com.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {


    @Test(priority =1)
    public void accountPageNavigationTest() throws InterruptedException {
        String username=prop.getProperty("username");
        String password=prop.getProperty("password");

        loginPage=homePage.navigateToLoginPage();
        accountPage=loginPage.doLogin(username,password);

        String title=accountPage.getAccountPageTitle();
        Assert.assertEquals(accountPage.getAccountPageTitle(),"My Account");

    }
    @Test(priority = 2)
    public void verifyAddProductToCartTest() throws InterruptedException {
        accountPage.addProductToCart();

    }
    @Test(priority = 3)
    public void verifyRemoveProductFromCart(){
        accountPage.removeProductFromCart();
    }
    @Test(priority = 4)
    public void verifyEditAccountInformation() throws InterruptedException {
        accountPage.editAccountInfo();
    }
    @Test(priority = 5)
    public void verifyAddNewAddress() throws InterruptedException {
        accountPage.addNewAddress();
    }
    @Test(priority = 6)
    public void verifyDeleteAddress() throws InterruptedException {
        accountPage.deleteAddress();
    }
}
