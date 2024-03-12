package learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingTabsAndPopups {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://sso.teachable.com/secure/673/identity/sign_up");
        Thread.sleep(2000);

        //When a new window opens

        Page popup=page.waitForPopup(()->{
            page.locator("//a[text()='Privacy Policy']").nth(0).click();

        });
        Thread.sleep(2000);

        //Performing actions on new window

        popup.locator("//a[@id='header-sign-up-btn']").click();
        Thread.sleep(2000);
        popup.locator("//button[contains(text(),'email')]").click();
        Thread.sleep(2000);
        popup.close();
        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
