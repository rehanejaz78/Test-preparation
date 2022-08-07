package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.servlet.ServletOutputStream;
import java.time.Duration;

public class CMSLogin {
    WebDriver driver;

    By enrollment = By.cssSelector("#BodyPH_tbEnrollment");
    By password = By.cssSelector("#BodyPH_tbPassword");    //rehan@123

    By dropdownInstitute = By.cssSelector("#BodyPH_ddlInstituteID");
    By loginbtn = By.cssSelector("#BodyPH_btnLogin");

    By Gpa = By.cssSelector("body > form:nth-child(1) > div:nth-child(11) > div:nth-child(3) > div:nth-child(3) > table:nth-child(9) > tbody:nth-child(3) > tr:nth-child(5) > td:nth-child(1)");
    By resultProviosnal = By.linkText("Provisional Result");



    public CMSLogin(WebDriver driver) {

        this.driver=driver;

    }

    public void clickResultProviosnal(){driver.findElement(resultProviosnal).click();}
    public void getResult(){

        String result = driver.findElement(Gpa).getText();
        System.out.println("Result : GPA " + result );
    }
        public void enterEnrollment () {
            driver.findElement(enrollment).sendKeys("03-134181-026");
        }

        public void enterpassword(){
        driver.findElement(password).sendKeys("rehan@123");
        }

        public void instituteSelect(){

        WebElement drop = driver.findElement(dropdownInstitute);
        Select dropdown = new Select(drop);
        dropdown.selectByVisibleText("Lahore Campus");

        }


        public void clickLogin(){
        driver.findElement(loginbtn).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-left")));

          String text = driver.findElement(By.id("ProfileInfo_lblUsername")).getText();
            Assert.assertEquals("03-134181-026",text);
            System.out.println(text);

        }

    }


