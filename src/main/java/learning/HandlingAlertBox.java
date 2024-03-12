package learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingAlertBox {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");

        Thread.sleep(2000);
        page.onDialog(dialog -> {
            dialog.accept();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(dialog.message());
        });
        page.click("//input[@type='submit']");
        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();
    }

}
