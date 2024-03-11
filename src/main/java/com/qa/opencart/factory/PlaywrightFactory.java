package com.qa.opencart.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Properties prop;

    public Page intiBrowser(Properties prop){
        String browserName=prop.getProperty("browser");
        System.out.println("Browser name is: "+browserName);
        playwright=Playwright.create();
        Browser browser = null;
        BrowserContext browserContext;
        Page page;


        switch (browserName.toLowerCase()){
            case "chromium":
                //playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;
            case "firefox":
               // playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;
            case "chrome":
                playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;
            default:
                System.out.println("Please pass right browser name");
        }
        //browserContext=browser.newContext();
        
        page=browser.newPage();
        page.navigate(prop.getProperty("url"));

        return page;
    }
    //This method is used to initialize the properties
    public Properties initProp() throws FileNotFoundException {
        try {
            FileInputStream ip = new FileInputStream("E:\\Vinay\\Java Programs\\My_Java_Programs\\PlayWrightProject\\src\\test\\resources\\config\\config.properties");
            prop=new Properties();
            prop.load(ip);
            //System.out.println(prop.getProperty("headless"));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}
