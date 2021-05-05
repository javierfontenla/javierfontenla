package Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio14 {
   // Crear un método con un nombre a seleccionar
   // Acceder a Netflix: https://www.netflix.com/uy/
   // Mostrar los elementos h1 y h2 que hay en el sitio
   // Refrescar la página
    //Mostrar el texto de los botones que se encuentran en la página
   // Mostrar la cantidad de elementos div que contiene el sitio
   // Obtener y mostrar el título de la página
   // Mostrar la cantidad de elementos de tipos link
   @Test
   public void ejercicio14Netflix(){
       System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.netflix.com/uy/");
       driver.manage().window().maximize();

       List<WebElement> listH1s = driver.findElements(By.tagName("h1"));
       System.out.println("La cantidad de H1s es: " + listH1s.size());

       for (WebElement h1: listH1s){
           System.out.println("---> H1" + h1.getText());
       }

       List<WebElement> listH2s = driver.findElements(By.tagName("h2"));
       System.out.println("La cantidad de h2s es: " + listH2s.size());

       for (WebElement h2: listH2s){
           System.out.println("---> H2" + h2.getText());
       }

       driver.navigate().refresh();
       List<WebElement> listbuttons = driver.findElements(By.tagName("button"));
       for (WebElement btn: listbuttons){
           System.out.println("---> buttons" + btn.getText());
       }

       List<WebElement> listdivs = driver.findElements(By.tagName("div"));
       System.out.println("La cantidad de divs del sitio es: " + listdivs.size());

       String title = driver.getTitle();
       System.out.println("El titulo del sitio es: " + title);

       List<WebElement> listLinks = driver.findElements(By.tagName("a"));
       System.out.println("La cantidad de links del sitio es: " + listLinks.size());







   }










}
