package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String basUrl = "http://the-internet.herokuapp.com/login";

    @Before

    public void setUp(){

        openBrowser(basUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){


        //* Enter “tomsmith” username

        sendKeysToElement(By.xpath("//input[@name='username']"),"tomsmith");



        //* Enter “SuperSecretPassword!” password

        sendKeysToElement(By.xpath("//input[@type='password']"),"SuperSecretPassword!");



        //* Click on ‘LOGIN’ button

        clickOnElement(By.xpath("//button[@type='submit']"));



        //* Verify the text “Secure Area”

        getTextFromElement(By.xpath("//i[@class='icon-lock']"));



    }
    @Test
    public void verifyTheUsernameErrorMessage(){


        //* Enter “tomsmith1” username

        sendKeysToElement(By.xpath("//input[@name='username']"),"tomsmith1");



        //* Enter “SuperSecretPassword!” password

        sendKeysToElement(By.xpath("//input[@type='password']"),"SuperSecretPassword");



        //* Click on ‘LOGIN’ button

        clickOnElement(By.xpath("//button[@type='submit']"));



        //* Verify the error message “Your username is invalid!”

        getTextFromElement(By.xpath("//div[@class='flash error']"));



    }

    @Test
    public void verifyThePasswordErrorMessage(){

        //* Enter “tomsmith” username

        sendKeysToElement(By.xpath("//input[@name='username']"),"tomsmith");



        //* Enter “SuperSecretPassword” password

        sendKeysToElement(By.xpath("//input[@type='password']"),"SuperSecretPassword");




        //* Click on ‘LOGIN’ button

        clickOnElement(By.xpath("//button[@type='submit']"));

        //* Verify the error message “Your password is invalid!”

        getTextFromElement(By.xpath("//div[@id='flash']"));




    }

    @After
    public void tearDown(){

        // closeBrowser();
    }

}
