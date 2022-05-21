package day12_senkronizasyon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait{
    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //     Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin
    protected WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
        implicitlyWait() yukarida kapattim
        cunku explicitWait() nasil calistigini gorebilmek,
        konuyu anlamak icin gerekliydi.Ayni nedenle befor after metodlari TestBase class dan buraya aldim
        kendi notum...
         */

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void implicitWaitTesti(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYaziElementi = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackYaziElementi.isDisplayed());
    }

    @Test
    public void explicitWaitTesti(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        yazinin yazilmasini beklerken yazinin locatesini kullanmak sorun olur
        cunku henuz gorunmeyen bir yazinin locate edilmeside mumkun olmayabilir
        (HTML kodlari yazan developer farkli uygulamalar yapabilir)
        bu durumda bekleme islemi ve locate i birlikte yapmaliyiz
         */
        WebElement itsGoneYaziElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());


        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYaziElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackYaziElementi.isDisplayed());
    }




}
