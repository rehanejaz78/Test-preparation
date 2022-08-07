package Pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginHrm {

    By email = By.id("txtUsername");
    By password = By.id("txtPassword");
    By loginbtn = By.id("btnLogin");

    WebDriver driver;

   public LoginHrm(WebDriver driver){
        this.driver = driver;
    }
    public void enterEmail(){
       driver.findElement(email).sendKeys("Admin"); ;
    }
    public void enterPassword(){
        driver.findElement(password).sendKeys("admin123");
    }
    public void ClickLogin(){
        driver.findElement(loginbtn).click();


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));

        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("next-dialog-close")));
//
//        driver.findElement(By.className("next-dialog-close")).click();
//
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        isAlertPresent();




    }







}
