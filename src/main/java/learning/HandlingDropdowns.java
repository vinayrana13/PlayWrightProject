package learning;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class HandlingDropdowns {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.wikipedia.org/");

        //Select by value
        page.selectOption("#searchLanguage","hi");
        Thread.sleep(2000);

        //Select by text
        page.selectOption("#searchLanguage",new SelectOption().setLabel("Italiano"));
        Thread.sleep(2000);
        //Select by index
        page.selectOption("#searchLanguage",new SelectOption().setIndex(10));
        Thread.sleep(2000);

        //Getting all the options from dropdown and printing all of them
        List<ElementHandle> values=page.querySelectorAll("#searchLanguage");
        for(ElementHandle vale:values){
            System.out.println(vale.innerText());
        }
    }
}
