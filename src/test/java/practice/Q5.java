package practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {

    /*
       ...Exercise5...
      @BeforeClass ın icerisinde driver i kuralim
      maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
      Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
      Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
      @AfterClass ta driver ı kapatalim

       */

    static WebDriver driver;

    @BeforeClass
    public static void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
//       Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[text()='Kabul ediyorum']")).click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

//      Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
        driver.get("https://www.amazon.com");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "www.amazon.com";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

}
