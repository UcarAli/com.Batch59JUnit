package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q3 {

    /*
         ...Exercise3...
        // http://the-internet.herokuapp.com/add_remove_elements/
        // click on the "Add Element" button 100 times
        // write a function that takes a number, and clicks the "Delete" button given number of times,
        // and then validates that given number of buttons was deleted

        1.method : createButtons(100)
        2.deleteButtonsAndValidate()
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void createButtons(){
        for (int i = 0; i <100 ; i++) {
            driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        }
    }

    @Test
    public void deleteButtonsAndValidate(){
        int takesANnumber = (int)(Math.random()*100);
        System.out.println("Silinecek element adedi : "+takesANnumber);
        int deleteOncesiElementAdedi=driver.findElements(By.xpath("//button[@onclick='deleteElement()']")).size();
        for (int i = 0; i <takesANnumber ; i++) {
            driver.findElement(By.xpath("(//button[@onclick='deleteElement()'])[1]")).click();
        }
        int deleteSonrasiElementAdedi=driver.findElements(By.xpath("//button[@onclick='deleteElement()']")).size();
        System.out.println(deleteOncesiElementAdedi-deleteSonrasiElementAdedi);
        if ((deleteOncesiElementAdedi-deleteSonrasiElementAdedi)==takesANnumber){
            System.out.println("Test PASSED. \n"+takesANnumber+" aded element silindi. "+deleteSonrasiElementAdedi+" aded element kaldi.");
        }else {
            System.out.println("Test FAILED");
        }



    }






}
