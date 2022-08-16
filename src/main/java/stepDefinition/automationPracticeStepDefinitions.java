package stepDefinition;

import cucumber.api.PendingException;

import cucumber.api.java.cs.A;

import cucumber.api.java.en.And;

import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;

import org.junit.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class automationPracticeStepDefinitions {

    private static WebDriver driver;

    @Given("^I navigate to homepage \"([^\"]*)\"$")
    public void i_navigate_to_homepage(String url) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(url);

    }

    @Then("^I click on searchbar and search \"([^\"]*)\"$")
    public void i_click_on_searchbar_and_search(String item) throws Throwable {
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(item);
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
    }

    @Then("^I validate that the results returned matches the search \"([^\"]*)\"$")
    public void i_validate_that_the_results_returned_matches_the_search(String Item) throws Throwable {
        String ItemName = driver.findElement(By.xpath("//a[@title=\"" + Item + "\"][normalize-space()=\"" + Item + "\"]")).getText();
        Assert.assertEquals(ItemName, Item);
    }

    @Then("^I click on \"([^\"]*)\" category$")

    public void iClickOnCategory(String arg0) throws Throwable {

        driver.findElement(By.xpath("//a[@title='Women']")).isDisplayed();

        driver.findElement(By.xpath("//a[@title='Women']")).click();

    }

    @Then("^I select any value from the \"([^\"]*)\" and \"([^\"]*)\" filter item$")

    public void iSelectAnyValueFromTheAndFilterItem(String color, String category) throws Throwable {

        driver.findElement(By.xpath("//*[@class=\"layered_color\"]/a[text()=\"" + color + "\"]//parent::label//parent::li/input")).isDisplayed();

        driver.findElement(By.xpath("//*[@class=\"layered_color\"]/a[text()=\"" + color + "\"]//parent::label//parent::li/input")).click();


        driver.findElement(By.xpath("//*[@class=\"layered_filter\"]/ul/li/label/a[text()=\"" + category + "\"]")).isDisplayed();

        driver.findElement(By.xpath("//*[@class=\"layered_filter\"]/ul/li/label/a[text()=\"" + category + "\"]")).click();


    }

    @And("^I validate that the results returned matches the filter criteria with \"([^\"]*)\" and \"([^\"]*)\"$")

    public void iValidateThatTheResultsReturnedMatchesTheFilterCriteriaWithAnd(String color, String category) throws Throwable {

        driver.findElement(By.xpath("//li[normalize-space()='Categories: " + category + "']")).isDisplayed();

        driver.findElement(By.xpath("//li[normalize-space()='Color: " + color + "']")).isDisplayed();

    }


    @Then("^I select any \"([^\"]*)\" from the \"([^\"]*)\" section and add them to cart$")

    public void iSelectAnyFromTheSectionAndAddThemToCart(String item, String Popular) throws Throwable {

//                            *--------Click on Popular tab------*

        driver.findElement(By.xpath("//a[normalize-space()=\"" + Popular + "\"]")).isDisplayed();

        driver.findElement(By.xpath("//a[normalize-space()=\"" + Popular + "\"]")).click();


        //                            *--------select any item------*


        Actions act = new Actions(driver);

        WebElement Item = driver.findElement(By.xpath("//a[@title=\"" + item + "\"][normalize-space()=\"" + item + "\"]"));

        act.moveToElement(Item).build().perform();


        driver.findElement(By.xpath("(//span[contains(text(),'Add to cart')])[1]")).isDisplayed();

        driver.findElement(By.xpath("(//span[contains(text(),'Add to cart')])[1]")).click();


    }


    @And("^I validate that the \"([^\"]*)\" has successfully been added to the cart$")

    public void iValidateThatTheHasSuccessfullyBeenAddedToTheCart(String item) throws Throwable {


        driver.findElement(By.xpath("//h2[normalize-space()='Product successfully added to your shopping cart']")).isDisplayed();


        driver.findElement(By.xpath("//span[@class=\"product-name\" and text()=\"" + item + "\"]")).isDisplayed();


        driver.findElement(By.xpath("//span[@class='ajax_cart_product_txt ']")).isDisplayed();


        driver.findElement(By.xpath("//*[@title=\"Proceed to checkout\"]")).isDisplayed();


    }

}