package Clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EjercicioGit {


    public String URL_SALESFORCE = "https://login.salesforce.com/?locale=eu";
    public WebDriver driver;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/?locale=eu");
    }

    @Test(priority = 3)
    public void LoginFailureTest(){
        driver.get("https://login.salesforce.com/?locale=eu");

        WebElement logo = driver.findElement(By.id("logo"));
        Assert.assertTrue(logo.isDisplayed(), "El logo se encuentra en pantalla");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("test@test.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123466");

        driver.findElement(By.id("Login")).click();

        WebElement errorMessege = driver.findElement(By.id("error"));
        System.out.println(errorMessege.getText());

        String expectedError = "Your access to salesforce.com has been disabled by" + " your system administrator. Please contact your Administrator for" + " more information.";

        Assert.assertEquals(expectedError, errorMessege.getText());





    }








}
