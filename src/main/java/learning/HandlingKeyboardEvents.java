package learning;

import com.microsoft.playwright.*;

public class HandlingKeyboardEvents {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://login.yahoo.com/");
        page.locator("#login-username").type("Abc@yahoo.com",new Locator.TypeOptions().setDelay(100));

        /*page.keyboard().press("Enter");
        Thread.sleep(1000);
        page.goBack();*/
        page.keyboard().press("Control+A");
        Thread.sleep(1000);
        page.keyboard().press("Control+X");
        Thread.sleep(1000);
        page.keyboard().press("Control+V");
        Thread.sleep(1000);
        page.close();
        browser.close();
        playwright.close();
    }
}
