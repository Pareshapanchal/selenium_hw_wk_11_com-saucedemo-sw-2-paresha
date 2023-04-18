package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    //initialise base url link
    String baseUrl = "https://www.saucedemo.com/";
    // public String browser="Chrome"; // Option to choose Chrome browser please remove comment"//"
   // public String browser="FireFox";// Option to choose FireFox browser please remove comment"//"
    public String browser="Edge";// Option to choose Edge browser "
    @Before
    //loaunching different browser
    public void setUp(){openBrowser(baseUrl,browser); }
    @Test
    //1. userSholdLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id ='login-button']")).click();
        //Verify the text “PRODUCTS”
        String actualProductsDisplay = driver.findElement(By.xpath("//span[@class='title']")).getText();
        String expectedProductsDisplay ="Products";
        Assert.assertEquals("Title is not matching",expectedProductsDisplay,actualProductsDisplay);
    }
    @Test
    //2. verifyThatSixProductsAreDisplayedOnPage
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id ='login-button']")).click();
        //Verify that six products are displayed on page
        int numberOfProduct = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        if(numberOfProduct == 6)
           System.out.println("Total number of products displayed on the page is correct:  "+ numberOfProduct);
        else
            System.out.println("Total number of products displayed on the page is incorrect"+ numberOfProduct);

    }
    //cloing browser
    @After
    public void tearDown(){closeBrowser();}
}
