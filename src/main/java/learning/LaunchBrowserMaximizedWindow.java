package learning;

import com.microsoft.playwright.*;

import java.util.ArrayList;

public class LaunchBrowserMaximizedWindow {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        ArrayList<String>arguments=new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
        BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page=context.newPage();
        page.navigate("https://www.google.com/");
        System.out.println(page.title());
    }
}
