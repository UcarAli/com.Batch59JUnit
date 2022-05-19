package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q6 {
    /*
      ...Exercise6...
   // 1. Amazon.com'a gidelim.
   // 2. DropDown üzerinde Books secelim.(All yazan yerde)
   //    kategorilerin hepsini konsola yazdiralim
   // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
   // 4. Sonuc sayisini ekrana yazdiralim.
   // 5. Sonucların Les Miserables i icerdigini assert edelim
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

    // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com");

    // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByValue("search-alias=stripbooks-intl-ship");

    //    kategorilerin hepsini konsola yazdiralim
        List<WebElement> listDdm = driver.findElements(By.xpath("//select[@id='searchDropdownBox']"));
        for (WebElement each:listDdm) {
            System.out.println(each.getText());
        }

    // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Les Miserables"+ Keys.ENTER);

    // 4. Sonuc sayisini ekrana yazdiralim.
        String aramaSonucu=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();

    // 5. Sonucların Les Miserables i icerdigini assert edelim
        String expectedResult="Les Miserables";
        Assert.assertTrue(aramaSonucu.contains(expectedResult));

    }

}