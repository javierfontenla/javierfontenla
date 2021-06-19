package Examen;

import Clase6.DataFactory;
import Clase6.DataProviderGenerator;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class prueba_mailchimp {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.mailchimp.com/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
    @Test(priority = 4)
    public void validarTituloTest() throws InterruptedException {

        WebElement cookiesButton = driver.findElement(By.id("onetrust-close-btn-container"));
        cookiesButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        System.out.println("---> " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login | Mailchimp", "El titulo no es el indicado");

        Thread.sleep(5000);
        driver.close();



    }
    @Test(priority = 3)
    public void iniciarSesionPageTest() throws InterruptedException {
        WebElement cookiesButton = driver.findElement(By.id("onetrust-close-btn-container"));
        cookiesButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement loginMessege1 = driver.findElement(By.xpath("//*[contains(text(),'Log In')]"));
        System.out.println(loginMessege1.getText());
        Assert.assertEquals(loginMessege1.getText(),"Log In", "No se encuentra ese text");

        WebElement loginMessege2 = driver.findElement(By.xpath("//*[contains(text(),'Need a Mailchimp account?')]"));
        System.out.println(loginMessege2.getText());
        Assert.assertEquals(loginMessege2.getText(),"Need a Mailchimp account?", "No se encuentra ese text");

        Thread.sleep(5000);
        driver.close();



    }
    @Test(priority = 2)
    public void loginErrorTest() throws InterruptedException {
        WebElement cookiesButton = driver.findElement(By.id("onetrust-close-btn-container"));
        cookiesButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.findElement(By.id("username")).sendKeys("XXXXX@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);
        WebElement errorMsgElement = driver.findElement(By.xpath("//*[contains(text(),'Looks like you forgot your password there')]"));
        Assert.assertEquals(errorMsgElement.getText(), "Looks like you forgot your password there, XXXXX@gmail.com.", "Se esperaba error por falta de contraseña");

        Thread.sleep(2000);
        WebElement checkBox = driver.findElement(By.xpath("//*[@value='Y']"));
        if (checkBox.isSelected()== true){
            Assert.assertTrue(false, "El checkbox esta seleccionado");
        }

        Thread.sleep(5000);
        driver.close();


    }
    @Test(priority = 1)
    public void fakeEmailTest() throws InterruptedException {
        driver.navigate().to("https://login.mailchimp.com/signup/");
        WebElement cookiesButton = driver.findElement(By.id("onetrust-close-btn-container"));
        cookiesButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        driver.findElement(By.id("email")).sendKeys(email);

        driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(), "https://login.mailchimp.com/signup/", "La url no contiene la palabra signup");

        Thread.sleep(5000);
        driver.close();

    }

    @Test(priority = 0 , dataProviderClass = dataProviderCase5.class, dataProvider="emailsExamen")
    public void dataProviderEmailTest(String emails, String password) throws InterruptedException {
        WebElement cookiesButton = driver.findElement(By.id("onetrust-close-btn-container"));
        cookiesButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.findElement(By.id("username")).sendKeys(emails);
        driver.findElement(By.id("password")).sendKeys(password);

        //Thread.sleep(2000);
        //WebElement captchaButton = driver.findElement(By.cssSelector("[class='recaptcha-checkbox-border']"));
        //captchaButton.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);
        WebElement errorMensaje = driver.findElement(By.cssSelector("[class='c-mediaBody--centered']"));
        Assert.assertEquals(errorMensaje.getText(), "Whoops, an unknown error occurred. Please try to log in again.", "El mensaje de error no es el esperado");

        Thread.sleep(5000);
        driver.close();

    }








}
