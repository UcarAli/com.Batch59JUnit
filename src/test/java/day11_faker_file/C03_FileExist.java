package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));
        //icinde oldugu projenin dosya yolunu(path) verir
        //C:\Users\x\IdeaProjects\com.Batch59JUnit

        System.out.println(System.getProperty("user.home"));
        //C:\Users\x  -  her bilgisayarada farkli olabilir

        //C:\Users\x\Downloads
        // homePath + "\Downloads"


        //Masa ustundeki text.txt dosyasinin varligini test edelim
        //C:\Users\x\Desktop\text.txt
        String dosyoYolu = System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyoYolu);

        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz
        Bunun icin
         her bilgisayarin birbirinden farkli olan yolunu bulmak icin
         */
        String fakliKisim = System.getProperty("user.home");

        // herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim = "\\Desktop\\text.txt";

        String masaustuDosyoYolu = fakliKisim+ortakKisim;
//        System.out.println(Files.exists(Paths.get(masaustuDosyoYolu)));

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyoYolu)));


    }

}
