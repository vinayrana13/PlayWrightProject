package learning;

import com.microsoft.playwright.*;

import java.util.ArrayList;

public class NavigationMethods {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright=Playwright.create();
        ArrayList<String>arguments=new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
        BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page=context.newPage();
        page.navigate("https://www.way2automation.com/");
        Thread.sleep(2000);
        System.out.println(page.title());
        page.navigate("https://www.opencart.com/");
        Thread.sleep(2000);
        System.out.println(page.title());
        page.goBack(new Page.GoBackOptions().setTimeout(500));
        Thread.sleep(2000);
        page.goForward(new Page.GoForwardOptions().setTimeout(500));
        Thread.sleep(2000);
    }

}
