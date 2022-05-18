package day09_handleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){

        // 1- amazon ana sayfaya gidin
        driver.get("https://amazon.com");
        String ilkSayfaHandleDegeri= driver.getWindowHandle();
        /*
            CDwindow-4062F2D78BD37C7921FEBC32A9B51C74
            bu kod acilan sayfanin unique has kodudur.
            Selenium sayfalar arasi geciste bu window handle degerini kullanir

            eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
            su anda bulundugumuz sayfaya gecmek istiyorsak
            driver.switchTo().window("CDwindow-4062F2D78BD37C7921FEBC32A9B51C74");
            bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz.
        */

        // 2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi=  driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        String sayfaUrl = driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.TAB);
        /*
            Bu komutu kullandigimizda driver otomatik olarak olusturulan new Tab'a gecer
            yeni tab'da gorevi gerceklestirmek icin adimlari bastan almamiz gerekir
         */
        System.out.println("driver'in URL'si : "+driver.getCurrentUrl());
        driver.get(sayfaUrl);
//        ilkUrunResmi.click(); // yeni sayfaya gectigimizden ilkUrunResmi gormez.
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        // 4- yeni tab'da acilan urunun title yazdirin
        WebElement urunTitleElementi=driver.findElement(By.xpath("//span[@id=\"productTitle\"]"));
        System.out.println(urunTitleElementi.getText());
        System.out.println(driver.getCurrentUrl());

        // ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());

    }

}
