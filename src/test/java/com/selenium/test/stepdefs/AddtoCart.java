package com.selenium.test.stepdefs;

import com.selenium.test.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

/**
 * Created by danangpurnama on 18/07/2020.
 */
public class AddtoCart {

    private HomePage homePage;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;

    public AddtoCart() {
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.searchPage = new SearchPage();
        this.productPage = new ProductPage();
        this.cartPage = new CartPage();
    }

    String[] product = {"Kemeja", "Tas", "Shoes"};

    @Given("User go to home page bhinneka")
    public void user_go_to_home_page_bhinneka() {
        this.homePage.goToHomePage();
        this.homePage.setButton_login();
    }

    @When("User try to login")
    public void user_try_to_login() {
        this.loginPage.setLogin_with_email("tiket9121@gmail.com", "kd$K0qwK");
        this.homePage.checkNavBarAcccountDisplay();
    }

    @When("User add {int} product")
    public void user_add_product(Integer productName) throws InterruptedException {
        for (int i=0; i < productName;i++)
        {
            this.homePage.setField_search(product[i]);
            this.searchPage.setResult_first_productDisplayed();
            this.searchPage.setResult_first_product();
            this.productPage.button_atc();
            this.productPage.button_back_shop();
        }
    }

    @Then("User should see product added")
    public void user_should_see_product_added() throws InterruptedException {
        this.homePage.setNavbar_cart();
        this.cartPage.checkTitleProductCartDisplay();
        this.cartPage.assertTitle_product_cart(product[0],product[1], product[2]);
        this.cartPage.setRemove_item_multiple();
    }
}
