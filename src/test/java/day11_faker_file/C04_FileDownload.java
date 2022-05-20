package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim

    @Test
    public void test() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. code.txt dosyasını indirelim
        WebElement dummylinki = driver.findElement(By.xpath("//a[text()='dummy.txt']"));
        dummylinki.click();
        Thread.sleep(5000);

        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosya downloads'a indirilecektir, bize downloads'un dosya yolu lazim
        String farkliKisim= System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\dummy.txt";

        String arananDosyaYolu= farkliKisim+ortakKisim;

        // geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));

        // Buda tek satirda mbenim yaptigim yol
        String expectedDosyaYolu= System.getProperty("user.home")+"\\Downloads\\dummy.txt";
        Assert.assertTrue(Files.exists(Paths.get(expectedDosyaYolu)));


    }


}
