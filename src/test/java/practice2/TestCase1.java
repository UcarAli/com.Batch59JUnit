package practice2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Ali");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ali@can.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccound = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccound.isDisplayed());


        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    }
}
