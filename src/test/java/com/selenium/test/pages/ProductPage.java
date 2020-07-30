package com.selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by danangpurnama on 18/07/2020.
 */

public class ProductPage extends BasePage{

    @FindBy(id = "atc")
    private WebElement button_atc;
    @FindBy(xpath = "//*[@class=\"btn btn-default\"]")
    private WebElement button_back_shop;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public void button_atc() {
        wait.forLoading(5);
        wait.forElementToBeDisplayed(5, this.button_atc,"Tambah ke Keranjang");
        this.button_atc.click();
    }

    public void button_back_shop() {
        wait.forElementToBeDisplayed(5, this.button_back_shop,"Kembali Berbelanja");
        this.button_back_shop.click();
    }
}
