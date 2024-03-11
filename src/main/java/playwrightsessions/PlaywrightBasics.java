package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {
    public static void main(String[] args) {

        Playwright playwright=Playwright.create();

        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.amazon.ca/");
        String title=page.title();
        System.out.println("Page title is: "+title);

        String url=page.url();
        System.out.println("URL is: "+url);

        browser.close();
        playwright.close();


    }
}
