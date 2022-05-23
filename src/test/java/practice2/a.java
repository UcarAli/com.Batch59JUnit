package practice2;

import com.github.javafaker.Faker;
import utilities.TestBase;

public class a extends TestBase {
    public static void main(String[] args) {


        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String eMail=faker.internet().emailAddress();
        String password=faker.internet().password();
        System.out.println(faker.address().fullAddress());
    }
}
