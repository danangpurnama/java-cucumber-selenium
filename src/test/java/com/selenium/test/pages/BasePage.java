package com.selenium.test.pages;

import com.selenium.test.support.driver.Setup;
import com.selenium.test.support.driver.Wait;
import org.openqa.selenium.WebDriver;

/**
 * Created by danangpurnama on 28/07/2020.
 */

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }
}