package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {

    private WebDriver getspotifyByPlaceHolderTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spotify.com/uy/signup/");
        return driver;

    }
    @Test
    public void spotifyByPlaceHolderTest(){
        WebDriver driver = getspotifyByPlaceHolderTest();

        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("tester@test123.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("tester@test123.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("HolaMund");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("TesterSelenium");

        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("04");

        WebElement Mes = driver.findElement(By.id("month"));
        Select comboboxMes = new Select(Mes);
        comboboxMes.selectByVisibleText("Mayo");

        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1993");

        driver.findElement(By.xpath("(//*[contains(text(), 'No binario')]) [1]")).click();



    }


}
