package com.qa.opencart.base;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    protected HomePage homePage;
    protected LoginPage loginPage;

    protected AccountPage accountPage;
    protected Properties prop;

    @BeforeTest
    public void setup() throws FileNotFoundException {
        pf=new PlaywrightFactory();
        prop=pf.initProp();
        page=pf.intiBrowser(prop);
        homePage=new HomePage(page);
    }
    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
