package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class GhostWebsiteTest {
    @Test
    public void ghostTest() {
        WebDriver driver;
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();
        // Step A: Navigate to https://ghost.org/
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // Navigate to the website
        driver.get("https://ghost.org/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement signInButton = driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
        Assert.assertTrue(signInButton.isDisplayed());
        // Step B: Navigate to "Start here" section using the "Resources" menu
        WebElement resourcesMenu = driver.findElement(By.xpath("//button[normalize-space()='Resources']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(resourcesMenu).click().perform();
        Assert.assertTrue(resourcesMenu.isDisplayed());
        WebElement startHereButton = driver.findElement(By.xpath("//p[contains(text(), 'Start here')]"));
//        Assert.assertTrue(startHereButton.isDisplayed());
        driver.findElement(By.xpath("//p[contains(text(), 'Start here')]")).click();

        // Step C: Search for “create new blog”
        WebElement searchInput = driver.findElement(By.id("search-input"));
        Assert.assertTrue(searchInput.isDisplayed());
        searchInput.sendKeys("create new blog");
        searchInput.submit();

        // Step D: Open the 10th result
        WebElement tenthResult = driver.findElement(By.xpath("(//a[@class='resource-list-item'])[10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tenthResult);
        tenthResult.click();

        // Step E: Scroll to the top of the page and open the “Pricing” section
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        WebElement pricingLink = driver.findElement(By.xpath("//a[contains(text(), 'Pricing')]"));
        pricingLink.click();
        WebElement pageTitle = driver.findElement(By.xpath("//h1[@class='text-4xl sm:text-7xl font-extrabold tracking-tight leading-none text-white']\n"));
        Assert.assertTrue(pageTitle.isDisplayed());

//        Check initial price value

        WebElement initialValue = driver.findElement(By.xpath("//p[@class='text-slate-900 tracking-tight text-5xl font-bold']"));
        initialValue.getText();

//         Step F: Change the “Based on an audience” slider to 20k members
        WebElement slider = driver.findElement(By.id("members"));
        int currentPosition = slider.getLocation().getX();
        int targetPosition = 2000 - currentPosition;

        actions.clickAndHold(slider).moveByOffset(targetPosition, 0).release().perform();


        // Verify that all the prices have increased (You need to implement this verification based on your specific scenario)
        WebElement valueAfterIncreaseAudience = driver.findElement(By.xpath("//p[@class='text-slate-900 tracking-tight text-5xl font-bold']"));
        Assert.assertNotEquals(initialValue, valueAfterIncreaseAudience);

        // Close the browser
        driver.quit();

    }
}
