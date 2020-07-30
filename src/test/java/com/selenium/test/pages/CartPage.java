package com.selenium.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by danangpurnama on 18/07/2020.
 */

public class CartPage extends BasePage{
    @FindBy(id = "removeitem")
    private WebElement remove_item;

    @FindBy(id = "deleteconfirm")
    private WebElement delete_confirm;

    @FindBy(xpath = "(//*[@class=\"media-heading bt-typo-heading\"]//a)[1]")
    private WebElement title_product_cart_one;

    @FindBy(xpath = "(//*[@class=\"media-heading bt-typo-heading\"]//a)[2]")
    private WebElement title_product_cart_two;

    @FindBy(xpath = "(//*[@class=\"media-heading bt-typo-heading\"]//a)[3]")
    private WebElement title_product_cart_three;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public void setRemove_item_multiple() throws InterruptedException{
        int elements = driver.findElements(By.id("removeitem")).size();
        if (elements != 0 ){
            for (int i = 0; i < elements; i++) {
                Thread.sleep(3000);
                wait.forElementToBeDisplayedWhitoutName(10, this.remove_item);
                this.remove_item.click();
                wait.forElementToBeDisplayed(5,this.delete_confirm, "Hapus");
                this.delete_confirm.click();
            }
        }
    }

    public void checkTitleProductCartDisplay() {
        wait.forElementToBeDisplayedWhitoutName(10, this.title_product_cart_one);
    }
    public void assertTitle_product_cart(String titleProduct1, String titleProduct2, String titleProduct3) {
        this.title_product_cart_one.getText().contains(titleProduct1);
        this.title_product_cart_two.getText().contains(titleProduct2);
        this.title_product_cart_three.getText().contains(titleProduct3);
    }
}
