package com.selenium.test.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by danangpurnama on 28/07/20220.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/home-page.json",
        "html:target/home-page-html"},
        glue = {"com.selenium.test.support.driver",
                "com.selenium.test.stepdefs"})
public class RunCukesTest {
}
