package com.selenium.test.support.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Wait {

    private WebDriver driver;


    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    private void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public void forLoading(int timeout){
        ExpectedCondition<Object> condition = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
        String timeoutMessage = "Page didn't load after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void forElementToBeDisplayed(int timeout, WebElement webElement, String webElementName){
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        String timeoutMessage = webElementName + " wasn't displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void forElementToBeDisplayedWhitoutName(int timeout, WebElement webElement){
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        String timeoutMessage = " wasn't displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void forElementToBeClickable(int timeout, WebElement webElement){
        ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(webElement);
        String timeoutMessage = " wasn't clicked after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void forElementToVisible(int timeout, By elementLocator){
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(elementLocator);
        String timeoutMessage =  " elements were not displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void forPresenceOfElements(int timeout, By elementLocator, String elementName){
        ExpectedCondition<List<WebElement>> condition = ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator);
        String timeoutMessage = elementName + " elements were not displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }
}
