package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    private String emailId="//input[@name='email']";
    private String password="//input[@name='password']";
    private String loginBtn="//input[@value='Login']";
    private String forgotPwdLink="//div[@class='form-group']/a";
    private String logoutLink="//ul//a[text()='Logout']";

    public LoginPage(Page page){
        this.page=page;
    }
    public String getLoginPageTitle(){

        String pageTitle=page.title();
        return pageTitle;
    }
    public boolean isForgotPwdLinkExist(){
        return page.isVisible(forgotPwdLink);
    }

   /* public void doLogin(String uname, String pwd) throws InterruptedException {
        page.fill(emailId,uname);
        page.fill(password,pwd);
        page.click(loginBtn);
        String pagetitle=page.title();
        System.out.println(pagetitle);

        //page.click();
        //Thread.sleep(3000);*/

    //}


    public AccountPage doLogin(String username, String pasword) throws InterruptedException {

        page.fill(emailId,username);
        page.fill(password,pasword);
        page.click(loginBtn);
        page.isVisible(logoutLink);
        return new AccountPage(page);
    }
    /*public AccountPage navigateToAccountPage(){
        page.click(myAccount);
        page.click(loginLink);
        return new LoginPage(page);
    }*/
}
