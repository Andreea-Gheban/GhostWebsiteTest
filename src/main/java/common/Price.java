package common;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static common.BaseClass.driver;

public class Price {
    public static final By priceTitle = new By.ByXPath("//h1[@class='text-4xl sm:text-7xl font-extrabold tracking-tight leading-none text-white']");
    public static final By members = new By.ByXPath("//span[@class='text-gray-500 text-sm capitalize tracking-normal']//span[@class='text-pink-900']");
    public static final By updatedPrice = new By.ByXPath("//p[@class='text-slate-900 tracking-tight text-5xl font-bold']");

    public static void clickOnPricePageButton() {
        WebElement pricingLink = driver.findElement(By.xpath("//a[contains(text(), 'Pricing')]"));
        pricingLink.click();
        WebElement pageTitle = driver.findElement(By.xpath("//h1[@class='text-4xl sm:text-7xl font-extrabold tracking-tight leading-none text-white']\n"));
        Assert.assertTrue(pageTitle.isDisplayed());
    }

    public static void priceTitleIsDisplayed() {
        driver.findElement(priceTitle).isDisplayed();
    }

    public static void updateAudienceTo20K() {
        WebElement slider = driver.findElement(By.id("members"));
        Actions actions = new Actions(driver);

        actions.moveToElement(slider, (int) (-slider.getRect().width / 2.1), 0).moveByOffset((20*slider.getRect().width / 100),  0).click().build().perform();
    }

    public static void scrollUpToPriceButtonPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        WebElement pricingLink = driver.findElement(By.xpath("//a[contains(text(), 'Pricing')]"));
        pricingLink.click();
        WebElement pageTitle = driver.findElement(By.xpath("//h1[@class='text-4xl sm:text-7xl font-extrabold tracking-tight leading-none text-white']\n"));
        Assert.assertTrue(pageTitle.isDisplayed());
    }

    public static String checkMembersNumberWasUpdated() {
        return driver.findElement(members).getText();

    }
    public static String checkPriceWasUpdated(){
        return driver.findElement(updatedPrice).getText();
    }

}
