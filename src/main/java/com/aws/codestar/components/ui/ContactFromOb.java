package com.aws.codestar.components.ui;

import com.aws.codestar.components.pageobjects.ObitsLandingPage;
import com.aws.codestar.components.pageobjects.ObitsPage;
import com.aws.codestar.components.pageobjects.PageGenerator;
import com.aws.codestar.components.pojo.Obit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContactFromOb
{
    WebCrawler webCrawler;

    public void searchSeattleTimes()
    {
        webCrawler = new WebCrawler();
        WebDriver driver = webCrawler.getDriver();
        String dayrange = "365";
        String seatteTimesId = "372";
        driver.get("https://www.legacy.com/obituaries/seattletimes/obituary-search.aspx?daterange=" + dayrange +
                "&townname=Seattle&keyword=a&countryid=1&stateid=61&affiliateid=" + seatteTimesId);

        ObitsLandingPage landingPage = PageGenerator.getPage(driver, ObitsLandingPage.class);
        landingPage.clickSeeResults();

        ObitsPage page = getObitsPage(driver, 50);

        int endExclusive = page.getPubDate().size() - 1;
        List<Obit> collect = IntStream.range(0, endExclusive).mapToObj(x -> createObit(page, x)).sorted(getObitComparator()).collect(Collectors.toList());

        collect.stream().forEachOrdered(x -> System.out.println(x));
    }

    private ObitsPage getObitsPage(WebDriver driver, int i)
    {
        int count = 0;
        ObitsPage page = null;
        while (count < i)
        {
            page = PageGenerator.getPage(driver, ObitsPage.class);
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            count = page.getName().size();
        }
        return page;
    }

    private Obit createObit(ObitsPage page, int x)
    {
        String name = page.getName().get(x).getText();
        String date = page.getPubDate().get(x).getText();
        Obit obit = new Obit(date, name);
        return obit;
    }

    private Comparator<Obit> getObitComparator()
    {
        Comparator<Obit> obitComparator = (x1, x2) -> x1.getPubDate().before(x2.getPubDate()) ? 1 : 0;
        return obitComparator;
    }
}
