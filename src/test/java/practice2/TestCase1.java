package practice2;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase1 extends TestBase {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    @Test
    public void test1() {
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePageVisible = driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue(homePageVisible.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement signUp = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signUp.click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSgnUp = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSgnUp.isEnabled());

        //6. Enter name and email address
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String eMail=faker.internet().emailAddress();
        String password=faker.internet().password(); faker.business();

        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(firstName+lastName);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(eMail);

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccound = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccound.isDisplayed());


        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement titleWebElementi = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        Actions actions = new Actions(driver);
        actions.click(titleWebElementi)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("2022")
                .perform();


        //10. Select checkbox 'Sign up for our newsletter!'
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .perform();

        //11. Select checkbox 'Receive special offers from our partners!'
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .perform();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        actions.sendKeys(Keys.TAB)
                .sendKeys(firstName)
                .sendKeys(Keys.TAB)
                .sendKeys(lastName)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("No 2")
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Florida")
                .sendKeys(Keys.TAB)
                .sendKeys("Tallahassee")
                .sendKeys(Keys.TAB)
                .sendKeys("32300")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .perform();

        //13. Click 'Create Account button'
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedElmt = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreatedElmt.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //16. Verify that 'Logged in as username' is visible
        WebElement loggedInAsUName = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[9]/a"));
        Assert.assertTrue(loggedInAsUName.isDisplayed());


        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    }
}
