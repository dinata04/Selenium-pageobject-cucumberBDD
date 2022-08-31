package com.juaracoding.pageobject;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
				features = "src/test/resources/features/Checkout.feature",
				glue = "",
				plugin = {"pretty", "html:target/cucumber-reports.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}