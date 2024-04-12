package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Resources extends BaseClass {

    public static final By firstPageTitle = new By.ByXPath("//span[normalize-space()='Independent technology']");
    public static final By firstPagePartialTitle = new By.ByXPath("//span[@class='text-pink-900 font-extrabold']");
    public static final By signInButton = new By.ByXPath("//a[normalize-space()='Sign in']");
    public static final String RESOURCES_BUTTON = "Resources";
    public static final String START_HERE_BUTTON = "Start Here";
    private static final By startHereTitle = new By.ByXPath("//h1[@class='superhero']");
    public static final By searchInput = new By.ById("search-input");
    private static final By articleTitle = new By.ByXPath("//h1[@class='gh-title']");


    public static void clickOnStartHereButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//p[contains(text(), 'Start here')]")).click();
    }

    public static boolean searchInputIsVisible() {
        return driver.findElement(searchInput).isDisplayed();
    }

    public static void setSearchInput(String text) {
        driver.findElement(searchInput).sendKeys(text);
    }

    public static void submitSearchInput() {
        driver.findElement(searchInput).submit();
    }

    public static boolean firstPageTitleIsVisible() {
        return driver.findElement(firstPageTitle).isDisplayed();
    }

    public static boolean firstPagePartialTitleIsVisible() {
        return driver.findElement(firstPagePartialTitle).isDisplayed();
    }

    public static boolean signInButtonIsVisible() {

        return driver.findElement(signInButton).isDisplayed();
    }

    public static void clickOnResourcesButton() {
        WebElement clickable = driver.findElement(new By.ByXPath("//button[normalize-space()='Resources']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(clickable).click().perform();
    }

    public static String startHereTitleIsVisible() {
        return driver.findElement(startHereTitle).getText();
    }

    public static void sendInputToSearch(String text) {
        WebElement searchInput = driver.findElement(By.id("search-input"));
        searchInput.sendKeys(text);
        searchInput.submit();
    }

    public static void clickOnButton(String button) {
        switch (button) {
            case RESOURCES_BUTTON -> clickOnResourcesButton();
            case START_HERE_BUTTON -> clickOnStartHereButton();
        }
    }
    public static void userOpenTenthResult(){
        WebElement tenthResult = driver.findElement(By.xpath("(//a[@class='resource-list-item'])[10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tenthResult);
        tenthResult.click();
    }
    public static String checkArticleOpened(){
       return driver.findElement(articleTitle).getText();

    }
}
