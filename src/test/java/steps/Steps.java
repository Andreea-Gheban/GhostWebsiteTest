package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Duration;

import static common.Price.*;
import static common.Resources.*;

public class Steps {
    

    @Given("The user navigate to the ghost page")
    public void theUserNavigateToTheGhostPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(firstPageTitleIsVisible());
        Assert.assertTrue(firstPagePartialTitleIsVisible());
        Assert.assertTrue(signInButtonIsVisible());
    }

    @And("The user open the tenth result")
    public void theUserOpenTheTenthResult() {
        userOpenTenthResult();
    }

    @Then("The user can check that content is loaded")
    public void theUserCanCheckThatContentIsLoaded() {
        Assert.assertEquals("How to format a blog post: A complete guide for new writers", checkArticleOpened());
    }

    @Then("The can see that page with guides opens")
    public void theCanSeeThatPageWithGuidesOpens() {
        Assert.assertEquals("Start here.", startHereTitleIsVisible());
    }

    @When("The user click on {string} menu")
    public void theUserClickOnMenu(String page) {
        clickOnButton(page);
    }

    @And("The user click on Start here section")
    public void theUserClickOnSection() {
        clickOnStartHereButton();
    }

    @When("The user search for {string}")
    public void theUserSearchFor(String input) {
        setSearchInput(input);
        submitSearchInput();
    }

    @When("I the user click on Price button")
    public void iTheUserClickOnPriceButton() {
        clickOnPricePageButton();
    }

    @Then("The user can see that the Price page opens")
    public void theUserCanSeeThatThePricePageOpens() {
        priceTitleIsDisplayed();
    }

    @When("The user change the audience slider to 20k members")
    public void theUserChangeTheAudienceSliderToKMembers() {
        updateAudienceTo20K();
//        wait is added here to check if audience slider moved to 20k members
        waitFor( 10);
    }

    @And("The user scroll up to the Price button page")
    public void theUserScrollUpToThePriceButtonPage() {
        scrollUpToPriceButtonPage();
    }

    @Then("The user can check that price has been updated")
    public void theUserCanCheckThatPriceHasBeenUpdated() {
        Assert.assertEquals("20,000", checkMembersNumberWasUpdated());
        Assert.assertEquals("149", checkPriceWasUpdated());
    }
}
