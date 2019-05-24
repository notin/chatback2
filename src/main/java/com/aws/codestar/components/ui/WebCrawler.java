package com.aws.codestar.components.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebCrawler
{
    public WebCrawler()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AhuraMazda\\Documents\\GitHub\\contact_service\\src" +
                "\\main\\resources\\chromedriver.exe");
    }

    public void searchSeattleTimes()
    {
        getDriver();
    }

    public WebDriver getDriver()
    {
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}