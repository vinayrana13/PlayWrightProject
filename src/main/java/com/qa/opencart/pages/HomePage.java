package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    //1. String locators - Object Repository

    private String search="input[name='search']";
    private String searchButton="button[class='btn btn-default btn-lg']";
    private String searchPageHeader="div#content h1";
    private String loginLink="//a[text()='Login']";
    private String myAccount="//span[contains(text(),'Acc')]";
    //2. Page constructor
    public HomePage(Page page){
        this.page=page;
    }
    //3. Page Action methods
    public String getHomePageTitle(){
        String title=page.title();
        System.out.println("Page title is: "+title);
        return title;
    }
    public String getHomePageURL(){
        String url=page.url();
        System.out.println("Page URL is: "+url);
        return url;
    }
    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchButton);
        String header=page.textContent(searchPageHeader);
        System.out.println("Header is: "+header);
        return header;
    }

    public LoginPage navigateToLoginPage(){
        page.click(myAccount);
        page.click(loginLink);
        return new LoginPage(page);
    }
}
