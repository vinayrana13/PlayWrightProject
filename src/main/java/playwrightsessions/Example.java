/*
package playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://academy.naveenautomationlabs.com/");
            page.locator("[id=\"\\31 611313114803\"]").first().click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("vinay013");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").press("Tab");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("vinayrana13@ymail.com");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").press("Tab");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("Vinay123");
            page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").fill("+1 (823) 547-5614");
            page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Get Started")).click();
        }
    }
}
*/
