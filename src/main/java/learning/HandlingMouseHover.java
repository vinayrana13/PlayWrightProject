package learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingMouseHover {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.way2automation.com/");
        Thread.sleep(2000);
        page.locator("//li[@id='menu-item-27580']//span [text()='All Courses']").hover();
        Thread.sleep(2000);
        page.locator("//li[@id='menu-item-27582']//a[@class='menu-link']//span [text()='Selenium']").click();
        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();

    }
}
