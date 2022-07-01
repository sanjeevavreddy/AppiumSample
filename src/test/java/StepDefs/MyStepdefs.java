package StepDefs;

import StepDefs.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;


public class MyStepdefs extends Base {


    String MOVIE_NAME = "";

    @Before
    public void StartAppiumServer() throws MalformedURLException {
        createDriverInstance();
    }

    @Given("^user opened the Prime Appication and on login Screen$")
    public void VerifyAppIsOpened() {
        Assert.assertTrue(driver().findElement(By.xpath("//*[@resource-id=\"ap_email\"]")).isDisplayed(), "User landed on home screen");
    }

    @After
    public void closeDriver() {
        if(driver()!=null)
        closeDriverInstance();
    }


    @Then("User login to the application using {string}")
    public void userLoginToTheApplicationUsing(String UserName) throws InterruptedException, IOException {
        driver().findElement(By.xpath("//*[@resource-id=\"ap_email\"]")).sendKeys(UserName);
        driver().findElement(By.xpath("//*[@resource-id=\"ap_password\"]")).sendKeys("aveejnas");

        driver().findElement(By.xpath("//*[@resource-id=\"signInSubmit\"]")).click();
        driver().findElement(By.xpath("//*[@content-desc=\"Home\"]"));


        TouchActions touchActions = new TouchActions(driver());
        touchActions.doubleTap(null);


//        driver().navigate().back();

    }

    @Then("User navigate to Search Screen")
    public void userNavigateToSearchScreen() {

        driver().findElement(By.xpath("//*[@content-desc=\"Find\"]")).click();
        driver().findElement(By.xpath("//*[@resource-id=\"com.amazon.avod.thirdpartyclient:id/find_search_box_input\"]"));
    }

    @When("User enter the Movie Name in the search box {string}")
    public void userEnterTheMovieNameInTheSearchBox(String movie) {
        MOVIE_NAME = movie;
        driver().findElement(By.xpath("//*[@resource-id=\"com.amazon.avod.thirdpartyclient:id/find_search_box_input\"]")).click();
        driver().findElement(By.xpath("//*[@resource-id=\"com.amazon.avod.thirdpartyclient:id/find_search_box_input\"]")).sendKeys(movie);
        driver().findElement(By.xpath("//*[@resource-id=\"com.amazon.avod.thirdpartyclient:id/find_search_box_input\"]")).click();
    }

    @And("click on Enter Button")
    public void clickOnEnterButton() {
            ((AndroidDriver) driver()).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @Then("User should be displayed with the Movie Name$")
    public void userShouldBeDisplayedWithTheMovieName() {
        driver().findElement(By.xpath("//*[@resource-id=\"com.amazon.avod.thirdpartyclient:id/ItemTitleTextView\" and @text=\"" + MOVIE_NAME + "\"]"));
    }

    @When("User select the movie")
    public void userSelectTheMovie() {
        driver().findElement(By.xpath("//*[@resource-id=\"com.amazon.avod.thirdpartyclient:id/ItemTitleTextView\" and @text=\"" + MOVIE_NAME + "\"]")).click();
    }

    @Then("User should be displayed with Movie Information Page")
    public void userShouldBeDisplayedWithMovieInformationPage() {
        driver().findElement(By.xpath("//*[@resource-id=\"com.amazon.avod.thirdpartyclient:id/header_short_synopsis\"]"));
    }

    @When("User click on Watch Now or Continue Watching")
    public void userClickOnWatchNowOrContinueWatching() {
        driver().findElement(By.xpath("//*[@resource-id=\"com.amazon.avod.thirdpartyclient:id/detail_page_header_play_button\"]")).click();
    }

    @Then("the movie should start playing")
    public void theMovieShouldStartPlaying() {
        driver().findElement(By.xpath("//*[@resource-id=\"com.amazon.avod.thirdpartyclient:id/PlayerAttachments\"]"));
    }

//    @AfterStep
    public void afterStep() throws IOException {
        takeScreenshot();
    }
}
