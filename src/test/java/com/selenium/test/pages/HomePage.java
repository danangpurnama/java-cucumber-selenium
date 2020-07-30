package com.selenium.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by danangpurnama on 18/07/2020.
 */

public class HomePage extends BasePage{

    String HOME_PAGE_URL = "https://www.bhinneka.com";

    @FindBy(xpath = "//*[@class=\"btn login-links\"]")
    private WebElement button_login;
    @FindBy(id = "email")
    private WebElement field_email;
    @FindBy(xpath = "(//*[@class=\"bt-navbar__badge\"])[1]")
    private WebElement badge_icon;
    @FindBy(xpath = "//*[@class=\"navbar-cart\"]")
    private WebElement navbar_cart;
    @FindBy(xpath = "(//*[@type=\"search\"])[2]")
    private WebElement field_search;
    @FindBy(xpath = "//*[@class=\"dropdown navbar-account account-merchant\"]")
    private WebElement navbar_account;
    @FindBy(xpath = "(//*[@class=\"navbar-logo\"][@href=\"/\"])[2]")
    private WebElement logo_nav;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void goToHomePage(){
        driver.get(HOME_PAGE_URL+'/');
        wait.forLoading(10);
    }
    public void setButton_login() {
        wait.forElementToBeDisplayed(5, this.button_login,"Login");
        this.button_login.click();
    }

    public void assertBadge_icon() {
        if (this.navbar_cart.getText() != "0") {
            this.navbar_cart.click();
        }
    }

    public void setNavbar_cart() {
        this.navbar_cart.click();
    }

    public void checkNavBarAcccountDisplay() {
        wait.forElementToBeDisplayedWhitoutName(10, this.navbar_account);
    }

    public void setField_search(String keyValue) throws InterruptedException {
        this.field_search.sendKeys(keyValue);
        this.field_search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    public void selectProduct(int product){
        wait.forElementToBeDisplayedWhitoutName(10, driver.findElement(By.xpath("(//*[@class=\"bt-s-product \"])["+product+"]")));
        driver.findElement(By.xpath("(//*[@class=\"bt-s-product \"])["+product+"]")).click();
    }
}
