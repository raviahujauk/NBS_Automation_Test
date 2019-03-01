package NBSPrptptype;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NBSStepDefs {

    static {
        System.setProperty("webdriver.gecko.driver", "src/test/driver/geckodriver.exe");
    }

    WebDriver driver = new FirefoxDriver();

    @Given("^I open the url \"([^\"]*)\"$")
    public void i_open_the_url(String arg1) throws Throwable {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(arg1);
    }

    @When("^I mouse hover on menue \"([^\"]*)\"$")
    public void i_mouse_hover_on_menue(String arg1) throws Throwable {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.id("MortgagesNavItem"));
        action.moveToElement(we).perform();
        Thread.sleep(2500);
    }

    @And("^I click \"([^\"]*)\" from sub menu New mortgage customer$")
    public void i_click_from_sub_menu_New_mortgage_customer(String arg1) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"MortgagesNavItem\"]/div/div/div/div[1]/ul/li[1]/a"));
        driver.get("https://www.nationwide.co.uk/products/mortgages/our-mortgage-rates");
    }

    @And("^I click \"([^\"]*)\" option$")
    public void i_click_option(String arg1) throws Throwable {
        if (arg1.equals("No")) {
            driver.findElement(By.xpath("//label[@id='selectorItemHaveNationwideMortgage1']/span")).click();
        }
    }

    @And("^I click mortgage type \"([^\"]*)\" option$")
    public void i_click_mortgage_type_option(String arg1) throws Throwable {
        if (arg1.equals("I'm changing lender")) {
            driver.findElement(By.xpath("//*[@id=\"selectorItemNationwideMortgageTypeNo2\"]")).click();
            }
        }

    @And("^I enter \"([^\"]*)\" amount$")
    public void i_enter_amount(String arg1) throws Throwable {
        driver.findElement(By.id("SearchPropertyValue")).sendKeys(arg1);
    }

    @And("^I enter Mortgage amount \"([^\"]*)\"$")
    public void i_enter_Mortgage_amount(String arg1) throws Throwable {
        driver.findElement(By.id("SearchMortgageAmount")).sendKeys(arg1);
    }

    @And("^I enter Term value \"([^\"]*)\"$")
    public void i_enter_Term_value(String arg1) throws Throwable {
        driver.findElement(By.id("SearchMortgageTerm")).sendKeys(arg1);
    }

    @And("^I click find a mortgage rate button$")
    public void i_click_find_a_mortgage_rate_button() throws Throwable {
        driver.findElement(By.id("myButton")).click();
        Thread.sleep(6000);
    }

    @And("^I select mortgage type filter \"([^\"]*)\"$")
    public void i_select_mortgage_type_filter(String arg1) throws Throwable {
        if(arg1.equals("Fixed")) {
            driver.findElement(By.id("fixed")).click();
            Thread.sleep(4000);
        }
    }

    @And("^I select product fee filter \"([^\"]*)\"$")
    public void i_select_product_fee_filter(String arg1) throws Throwable {
        if(arg1.equals("With Fee")) {
            driver.findElement(By.id("product-fee-fee")).click();
            Thread.sleep(4000);
        }
    }

    @Then("^I verify result returns following products$")
    public void i_verify_result_returns_following_products(DataTable arg1) throws Throwable {
        List<List<String>> data = arg1.raw();
        List<WebElement> elementList = driver.findElements(By.id("NewMortgageRateTables"));
        for (int i=0; i<data.size();i++) {
            for(WebElement row : elementList){
                if(row.getText().equals(data.get(i).get(0)))
                Assert.assertEquals(row.getText(),data.get(i).get(0));
            }
        }
    }

    @And("^I click \"([^\"]*)\" link$")
    public void i_click_link(String arg1) throws Throwable {
        WebElement we = driver.findElement(By.cssSelector("#NewMortgageRateTables > div.ratesTableWrapper._5yr"));
        we.findElement(By.linkText("More info and apply")).click();
    }

    @And("^I click \"([^\"]*)\" button for the \"([^\"]*)\" product$")
    public void i_click_button_for_the_product(String arg1, String arg2) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"prod131258\"]/section[2]/div/div[2]/a")).click();
    }

    @And("^I verify next page heading \"([^\"]*)\"$")
    public void i_verify_next_page_heading(String arg1) throws Throwable {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Start your remortgage application')]"));
        Assert.assertTrue("Text not found!", list.size() > 0);
    }


}




