package Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class registrationFacebookTest {

    private WebDriver getfullRegistrationTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        return driver;
    }
    @Test
    public void fullRegistrationTest() throws InterruptedException {
        WebDriver driver = getfullRegistrationTest();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@ajaxify='/reg/spotlight/']")).click();

        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("John");
        Thread.sleep(2000);
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        Thread.sleep(2000);
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        Thread.sleep(2000);
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        WebElement dias = driver.findElement(By.id("day"));
        Select comboBoxdias = new Select(dias);
        comboBoxdias.selectByValue("26");

        WebElement Mes = driver.findElement(By.id("month"));
        Select comboBoxMes = new Select(Mes);
        comboBoxMes.selectByVisibleText("jun");

        WebElement Año = driver.findElement(By.id("year"));
        Select comboBoxAño = new Select(Año);
        comboBoxAño.selectByValue("1980");

        driver.findElement(By.xpath("//*[@name='sex' and @value= '2']")).click();









    }



}
