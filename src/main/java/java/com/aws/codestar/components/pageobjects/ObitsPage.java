package java.com.aws.codestar.components.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ObitsPage
{
    @FindBy(xpath = "//*[contains(text(), 'Published in The Seattle Times on ')]")
    private List<WebElement> pubDate;

    @FindBy(xpath = "//*[contains(@class, 'obitName')]")
    private List<WebElement> name;
}
