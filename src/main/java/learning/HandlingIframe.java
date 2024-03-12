package learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingIframe {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
        Thread.sleep(3000);
        page.frameLocator("//iframe[@id='iframeResult']").locator("//button[text()='Try it']").click();
        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
