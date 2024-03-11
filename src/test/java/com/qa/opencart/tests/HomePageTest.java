package com.qa.opencart.tests;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {


    @Test
    public void homePageTitleTest(){
        String actualTitle=homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
    }
    @Test
    public void homePageURLTest(){
        String actualURL=homePage.getHomePageURL();
        Assert.assertEquals(actualURL,prop.getProperty("url"));
    }
    @Test
    public void searchTest(){
        String actualSearchHeader= homePage.doSearch("macbook");
        Assert.assertEquals(actualSearchHeader,"Search - macbook");
    }




}
