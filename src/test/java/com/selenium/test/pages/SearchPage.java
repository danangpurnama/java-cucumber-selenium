package com.selenium.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by danangpurnama on 18/07/2020.
 */

public class SearchPage extends BasePage{

    @FindBy(xpath = "(//*[@class=\"bt-product-catalog-item__title\"])[1]")
    private WebElement result_first_product;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void setResult_first_productDisplayed(){
        wait.forElementToVisible(10, By.xpath("(//*[@class=\"bt-product-catalog-item__title\"])[1]"));
    }

    public void setResult_first_product() throws InterruptedException {
        Thread.sleep(4000);
        this.result_first_product.click();
    }
}

