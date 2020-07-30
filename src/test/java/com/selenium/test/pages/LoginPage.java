package com.selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by danangpurnama on 18/07/2020.
 */

public class LoginPage extends BasePage{

    @FindBy(id = "email")
    private WebElement field_email;
    @FindBy(id = "next")
    private WebElement button_next;
    @FindBy(id = "password")
    private WebElement field_password;
    @FindBy(xpath = "//button[@class=\"ant-btn ant-btn-primary\"]")
    private WebElement button_sign_in;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void setLogin_with_email(String emailValue, String passwordValue) {
        this.field_email.clear();
        this.field_email.sendKeys(emailValue);
        this.button_next.click();
        wait.forElementToBeDisplayed(5,this.field_password,"");
        this.field_password.clear();
        this.field_password.sendKeys(passwordValue);
        this.button_sign_in.click();
    }
}
