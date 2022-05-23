package day13_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class C02_WebTables extends TestBase {
    @Test
    public void test01(){
        // Bir class oluşturun : C02_WebTables
        // login() metodun oluşturun ve oturum açın.
        // https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //           ○ Username : manager
        //           ○ Password : Manager1!
        login();

        // table() metodu oluşturun
        //           ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //           ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        table();

        // printRows() metodu oluşturun //tr
        //           ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //           ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //           ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        printRows();

    }

    public void printRows() {
        //● printRows( ) metodu oluşturun //tr
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi= driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : " + satirlarListesi.size());
        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each: satirlarListesi
        ) {
            System.out.println(each.getText());
        }
        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each: cellList
        ) {
            System.out.println(each.getText());
        }
        // Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklarListesi.size() ; i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }
        List<WebElement> emailSutunListesi=
                driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each: emailSutunListesi) {
            System.out.println(each.getText());
        }
    }

    public void table() {
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklariListesi= driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun Sayisi : " + sutunBasliklariListesi.size());

        // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

        // Tum body'i bir String olarak yazdirmak isterseniz
        // body webElementini locate edip, getText() method'u ile yazdirabilirsiniz
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
    }

    public void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        Actions action = new Actions(driver);
        WebElement userName = driver.findElement(By.id("UserName"));
        action.click(userName)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }

}
