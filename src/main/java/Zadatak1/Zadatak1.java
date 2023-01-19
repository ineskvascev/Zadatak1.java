package Zadatak1;
/*
Automatizovati navodjenje na sajtu https://automationexercise.com.
Otici na pocetnu stranu, kliknuti na "Signup / Login", unesite u polja za "New User Signup!" pomocu faker-a - ime i email.
Kliknuti dugme Signup.
Pored neophodnih polja na Signup ekranu uneti i date of birth, cekirati Title i "Receive special offers from our partners!".
Country staviti na "Canada".
Docekace vas ekran Account created, kliknuti "Continue". Vratice vas na pocetnu stranicu.
Za kraj kliknuti Delete Account, opet kliknuti Continue.

Waitere po potrebi dodavati.

Ako ste poslali username za domace, ne morate vise slati, gledacu po username-u na githubu jel okaceno ili nije pa cu
pisati ako ima nekih problema.
 */

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class Zadatak1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ina\\Desktop\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://automationexercise.com/%22");

        WebElement buttonsignUpLogIn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        buttonsignUpLogIn.click();


        Faker faker = new Faker();

        String name = faker.name().fullName();
        WebElement nameSignUp = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        nameSignUp.sendKeys(name);

        String email = faker.internet().emailAddress();
        WebElement emailSignUp = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        emailSignUp.sendKeys(email);

        WebElement buttonSignUp = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        buttonSignUp.click();


        WebElement title = driver.findElement(By.id("id_gender2"));
        WebElement labelTitle = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[1]/div[2]/label"));
        title.click();

        String password = faker.internet().password();
        WebElement passwordSignUp = driver.findElement(By.id("password"));
        passwordSignUp.sendKeys(password);


        WebElement selectDay = driver.findElement(By.id("days"));
        Select day = new Select(selectDay);                       //Web element selectDay prosledjuje se klasi Select () !

        WebElement selectMonth = driver.findElement(By.id("months"));
        Select month = new Select(selectMonth);

        WebElement selectYear = driver.findElement(By.id("years"));
        Select year = new Select(selectYear);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400);", "");

        WebElement checkBox2 = driver.findElement(By.id("optin"));
        WebElement labelCheckBox2 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[7]/label"));
        checkBox2.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        labelCheckBox2.click();

        JavascriptExecutor javascriptExecutor1 = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400);", "");

        WebElement firstName = driver.findElement(By.id("first_name"));
        String name1 = faker.name().firstName();
        firstName.sendKeys(name1);

        WebElement lastName = driver.findElement(By.id("last_name"));
        String lastName1 = faker.name().lastName();
        lastName.sendKeys(lastName1);

        WebElement address = driver.findElement(By.id("address1"));
        String address1 = faker.address().fullAddress();
        address.sendKeys(address1);

        JavascriptExecutor javascriptExecutor2 = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400);", "");

        WebElement selectCountry = driver.findElement(By.id("country"));
        Select country = new Select(selectCountry);
        selectCountry.sendKeys("Canada");

        WebElement state = driver.findElement(By.id("state"));
        String state1 = faker.address().state();
        state.sendKeys(state1);

        WebElement city = driver.findElement(By.id("city"));
        String city1 = faker.address().city();
        city.sendKeys(city1);

        JavascriptExecutor javascriptExecutor3 = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400);", "");

        WebElement zipCode = driver.findElement(By.id("zipcode"));
        String zipCode1 = faker.address().zipCode();
        zipCode.sendKeys(zipCode1);

        WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
        String mobileNumber1 = faker.phoneNumber().cellPhone();
        mobileNumber.sendKeys(mobileNumber1);

        WebElement buttonCreateAccount = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
        buttonCreateAccount.click();

        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        buttonContinue.click();

        driver.navigate().to("https://automationexercise.com/%22");

        WebElement buttonDeleteAccount = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        buttonDeleteAccount.click();

        WebElement buttonContinue1 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        buttonContinue1.click();

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       driver.quit();

    }
}
