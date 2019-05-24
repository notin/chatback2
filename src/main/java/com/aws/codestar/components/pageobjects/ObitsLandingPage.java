package com.aws.codestar.components.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ObitsLandingPage
{

    @FindBy(xpath = "//*[text() = 'View all results.']")
    private WebElement seeResults;

    public void clickSeeResults()
    {
        seeResults.click();
    }
}
