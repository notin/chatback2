package java.com.aws.codestar.components.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator
{
    public static <T> T getPage(WebDriver driver, Class<T> cl)
    {
        return PageFactory.initElements(driver,  cl);
    }
}
