package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class AccountPage {
    private Page page;
    public AccountPage(Page page){
        this.page=page;
    }
    private String searchTbx="//input[@name='search']";
    private String searchBtn="//button[@class='btn btn-default btn-lg']";
    private String macProduct="//div[@class='image']//img[@alt='MacBook Air']";
    private String addToCartBtn="//button[@id='button-cart']";
    private String cartBtn="//span[contains(text(),'item')]";
    private String successtxt="//div[contains(text(),'ucc')]";
    private String checkoutBtn="//strong[contains(text(),'Checkout')]";
    private String removeButton="//button[@class='btn btn-danger']";
    private String shoppingCartlbl="//div[@id='content']//p[contains(text(),'empty')]";
    private String editAccountInformationlnk="//a[contains(text(),'Edit your a')]";
    private String telephonetbx="#input-telephone";
    private String submitBtn="//input[@type='submit']";
    private String successMsglbl="//div[contains(text(),'account')]";
    private String addressBookEntries="//a[contains(text(),'address book')]";
    private String newAddressBtn="//a[contains(text(),'New ')]";
    private String firstNametbx="#input-firstname";
    private String lastNametbx="#input-lastname";
    private String companyTbx="#input-company";
    private String addressLine1="#input-address-1";
    private String addressLine2="#input-address-2";
    private String cityTbx="#input-city";
    private String postalCodeTbx="#input-postcode";
    private String countryDrpdwon="#input-country";
    private String regionDropdown="#input-zone";
    private String addressAddedSuccessfullylbl="//div[contains(text(),'added')]";
    private String accountBtn="//span[contains(text(),'ccou')]";
    private String myAccountBtn="//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'ccou')]";
    private String continuebtn="//a[text()='Continue']";

    private String deleteAddressBtn="//td[contains(text(),'John')]//following-sibling::td//a//following-sibling::a";
    private String del="//*[@id=\"content\"]/div[1]/table/tbody/tr[2]/td[2]/a[2]";
    private String deletedLabel="//div[contains(text(),'deleted')]";

    public String getAccountPageTitle(){
        String pageTitle=page.title();
        System.out.println(pageTitle);
        return pageTitle;
    }
    public boolean addProductToCart(){
        page.fill(searchTbx,"macbook");
        page.click(searchBtn);
        page.click(macProduct);
        page.click(addToCartBtn);
        return page.isVisible(successtxt);

    }
    public boolean removeProductFromCart(){
        page.click(cartBtn);
        page.click(checkoutBtn);
        page.click(removeButton);

        page.click(continuebtn);
        return page.isVisible(shoppingCartlbl);
    }

    public boolean editAccountInfo() throws InterruptedException {
        page.click(accountBtn);
        page.click(myAccountBtn);
        Thread.sleep(3000);
        page.click(editAccountInformationlnk);
        page.fill(telephonetbx,"9852366417");
        page.click(submitBtn);
        return page.isVisible(successMsglbl);
    }
    public boolean addNewAddress() throws InterruptedException {
        page.click(accountBtn);
        page.click(myAccountBtn);
        page.click(addressBookEntries);
        page.click(newAddressBtn);
        page.fill(firstNametbx,"John");
        page.fill(lastNametbx,"Richard");
        page.fill(companyTbx,"I Technologies");
        page.fill(addressLine1,"6th Avenue");
        page.fill(addressLine2,"York St");
        page.fill(cityTbx,"New York");
        page.fill(postalCodeTbx,"63457");
        page.selectOption(countryDrpdwon,"223");
        page.selectOption(regionDropdown,"3655");
        page.click(submitBtn);
        return page.isVisible(addressAddedSuccessfullylbl);

    }
    public void deleteAddress() throws InterruptedException {
        page.click(accountBtn);
        page.click(myAccountBtn);
        page.click(addressBookEntries);
        page.click(del);
        page.isVisible(deletedLabel);
        Thread.sleep(3000);

    }

}
