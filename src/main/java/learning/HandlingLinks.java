package learning;

import com.microsoft.playwright.*;

public class HandlingLinks {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.wikipedia.org/");
        Locator links=page.locator("a");
        for(int i=0;i<links.count();i++){
            System.out.println(links.nth(i).innerText()+links.nth(i).getAttribute("href"));
        }
    }
}
